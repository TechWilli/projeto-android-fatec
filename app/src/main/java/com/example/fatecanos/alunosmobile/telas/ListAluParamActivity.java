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
import com.example.fatecanos.alunosmobile.dbs.ControllerAluno;
import com.example.fatecanos.alunosmobile.modelos.AlunoBean;

import java.util.List;

public class ListAluParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeAlunos;
    List<AlunoBean> alunos;
    Button pesqAlu;
    ArrayAdapter<AlunoBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alu_param);
        final Context con = getBaseContext();
        final ControllerAluno ge = new ControllerAluno(con);
        ListaDeAlunos = (ListView) findViewById(R.id.listaalu);
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); //
        final EditText login = (EditText)findViewById(R.id.login);

        pesqAlu = (Button) findViewById(R.id.btpesquisar);
        pesqAlu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String loginString = login.getText().toString();
                AlunoBean alu = new AlunoBean();
                alu.setLogin(loginString);
                alunos = ge.listarAlunos(alu);
                adapter = new ArrayAdapter<AlunoBean>(con,android.R.layout.simple_list_item_1,alunos);
                ListaDeAlunos.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        AlunoBean alu = (AlunoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListAluParamActivity.this, UptAluActivity.class);
        it.putExtra("Aluno",alu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + alu.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        AlunoBean alu = (AlunoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListAluParamActivity.this, UptAluActivity.class);
        it.putExtra("Aluno",alu);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + alu.getId(),Toast.LENGTH_LONG).show();
    }
}