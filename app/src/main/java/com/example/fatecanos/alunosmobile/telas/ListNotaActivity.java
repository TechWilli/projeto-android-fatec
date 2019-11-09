package com.example.fatecanos.alunosmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerNota;
import com.example.fatecanos.alunosmobile.modelos.NotaBean;

public class ListNotaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeNotas;
    List<NotaBean> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nota);
        final ControllerNota no = new ControllerNota(getBaseContext());
        ListaDeNotas = (ListView) findViewById(R.id.listanota);
        notas = no.listarNotas();
        ArrayAdapter<NotaBean> adapter = new ArrayAdapter<NotaBean>(this,android.R.layout.simple_list_item_1, notas);
        ListaDeNotas.setAdapter(adapter);
        ListaDeNotas.setOnItemClickListener(this);
        ListaDeNotas.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        NotaBean nota = (NotaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListNotaActivity.this, UptNotaActivity.class);
        it.putExtra("Nota", nota);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        NotaBean nota = (NotaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListNotaActivity.this, UptNotaActivity.class);
        it.putExtra("Nota", nota);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Clicado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
    }
}
