package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerNota;
import com.example.fatecanos.alunosmobile.modelos.NotaBean;

import java.util.List;

public class ListNotaParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeNotas;
    List<NotaBean> notas;
    Button pesqNota;
    ArrayAdapter<NotaBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nota_param);
        final Context con = getBaseContext();
        final ControllerNota no = new ControllerNota(con);
        ListaDeNotas = (ListView) findViewById(R.id.listanota);
        ListaDeNotas.setOnItemClickListener(this);
        ListaDeNotas.setOnItemLongClickListener(this);
        final EditText sitfinal = (EditText)findViewById(R.id.sitfinal);

        pesqNota = (Button) findViewById(R.id.btpesquisarnota);
        pesqNota.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sitFinalString = sitfinal.getText().toString();
                NotaBean nota = new NotaBean();
                nota.setSitFinal(sitFinalString);
                notas = no.listarNotas(nota);
                adapter = new ArrayAdapter<NotaBean>(con,android.R.layout.simple_list_item_1,notas);
                ListaDeNotas.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        NotaBean nota = (NotaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListNotaParamActivity.this, UptNotaActivity.class);
        it.putExtra("Nota", nota);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        NotaBean nota = (NotaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListNotaParamActivity.this, UptNotaActivity.class);
        it.putExtra("Nota", nota);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Clicado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
    }

}
