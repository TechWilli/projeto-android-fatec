package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerAluno;
import com.example.fatecanos.alunosmobile.modelos.AlunoBean;

public class UptAluActivity extends AppCompatActivity {

        Button uptAlu, delAlu;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_upt_alu);
            final ControllerAluno ge = new ControllerAluno(getBaseContext());
            final EditText login = (EditText)findViewById(R.id.login);
            final EditText senha = (EditText)findViewById((R.id.senha));
            final EditText ra = (EditText)findViewById(R.id.ra);
            final EditText curso = (EditText)findViewById(R.id.curso);
            Intent it = getIntent();
            final AlunoBean recuperado = (AlunoBean) it.getSerializableExtra("Aluno");
            login.setText(recuperado.getLogin());
            senha.setText(recuperado.getSenha());
            ra.setText(recuperado.getRa());
            curso.setText(recuperado.getCurso());

            uptAlu = (Button) findViewById(R.id.btalterar);
            uptAlu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String loginString = login.getText().toString();
                    String senhaString = senha.getText().toString();
                    String raString = ra.getText().toString();
                    String cursoString = curso.getText().toString();
                    recuperado.setLogin(loginString);
                    recuperado.setSenha(senhaString);
                    recuperado.setRa(raString);
                    recuperado.setCurso(cursoString);
                    String msg = ge.alterar(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });

            delAlu = (Button) findViewById(R.id.btexcluir);
            delAlu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String msg = ge.excluir(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
            });


        }
    }
