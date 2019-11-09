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
import com.example.fatecanos.alunosmobile.dbs.ControllerDisciplina;
import com.example.fatecanos.alunosmobile.modelos.DisciplinaBean;

public class ListDisActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeDisciplinas;
    List<DisciplinaBean> disciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dis);
        final ControllerDisciplina di = new ControllerDisciplina(getBaseContext());
        ListaDeDisciplinas = (ListView) findViewById(R.id.listadis);
        disciplinas = di.listarDisciplinas();
        ArrayAdapter<DisciplinaBean> adapter = new ArrayAdapter<DisciplinaBean>(this,android.R.layout.simple_list_item_1, disciplinas);
        ListaDeDisciplinas.setAdapter(adapter);
        ListaDeDisciplinas.setOnItemClickListener(this);
        ListaDeDisciplinas.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        DisciplinaBean dis = (DisciplinaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListDisActivity.this, UptDisActivity.class);
        it.putExtra("Disciplina", dis);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        DisciplinaBean dis = (DisciplinaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListDisActivity.this, UptDisActivity.class);
        it.putExtra("Disciplina", dis);
        startActivity(it);
        //Toast.makeText(getApplicationContext(),"Item Clicado :-" + position + " ID= " + dis.getId(),Toast.LENGTH_LONG).show();
    }
}
