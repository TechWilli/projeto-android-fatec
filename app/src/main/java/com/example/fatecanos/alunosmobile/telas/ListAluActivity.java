package com.example.fatecanos.alunosmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerAluno;
import com.example.fatecanos.alunosmobile.modelos.AlunoBean;

public class ListAluActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        ListView ListaDeAlunos;
        List<AlunoBean> alunos;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_alu);
            final ControllerAluno ge = new ControllerAluno(getBaseContext());
            ListaDeAlunos = (ListView) findViewById(R.id.listaalu);
            alunos = ge.listarAlunos();
            ArrayAdapter<AlunoBean> adapter = new ArrayAdapter<AlunoBean>(this,android.R.layout.simple_list_item_1,alunos);
            ListaDeAlunos.setAdapter(adapter);
            ListaDeAlunos.setOnItemClickListener(this); // Clique no item
            ListaDeAlunos.setOnItemLongClickListener(this); // Pressão sobre o item
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi pressionado
            // position é a posição do item no adapter
            AlunoBean alu = (AlunoBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListAluActivity.this, UptAluActivity.class);
            it.putExtra("Aluno",alu);
            startActivity(it);
            //Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + alu.getId(),Toast.LENGTH_LONG).show();
            return true;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Código para trabalhar com o item que foi clicado
            // position é a posição do item no adapter
            AlunoBean alu = (AlunoBean) parent.getItemAtPosition(position);
            Intent it = new Intent(ListAluActivity.this, UptAluActivity.class);
            it.putExtra("Aluno",alu);
            startActivity(it);
            //Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + alu.getId(),Toast.LENGTH_LONG).show();
        }
    }
