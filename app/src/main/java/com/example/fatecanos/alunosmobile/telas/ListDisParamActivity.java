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

import com.example.fatecanos.alunosmobile.dbs.ControllerDisciplina;
import com.example.fatecanos.alunosmobile.modelos.DisciplinaBean;

import java.util.List;

public class ListDisParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeDisciplinas;
    List<DisciplinaBean> disciplinas;
    Button pesqDis;
    ArrayAdapter<DisciplinaBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dis_param);
        final Context con = getBaseContext();
        final ControllerDisciplina di = new ControllerDisciplina(con);
        ListaDeDisciplinas = (ListView) findViewById(R.id.listadis);
        ListaDeDisciplinas.setOnItemClickListener(this);
        ListaDeDisciplinas.setOnItemLongClickListener(this);
        final EditText prof = (EditText)findViewById(R.id.prof);

        pesqDis = (Button) findViewById(R.id.btpesquisardis);
        pesqDis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String profString = prof.getText().toString();
                DisciplinaBean dis = new DisciplinaBean();
                dis.setProf(profString);
                disciplinas = di.listarDisciplinas(dis);
                adapter = new ArrayAdapter<DisciplinaBean>(con,android.R.layout.simple_list_item_1,disciplinas);
                ListaDeDisciplinas.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        DisciplinaBean dis = (DisciplinaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListDisParamActivity.this, UptDisActivity.class);
        it.putExtra("Disciplina", dis);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        DisciplinaBean dis = (DisciplinaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListDisParamActivity.this, UptDisActivity.class);
        it.putExtra("Disciplina", dis);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Clicado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
    }
}
