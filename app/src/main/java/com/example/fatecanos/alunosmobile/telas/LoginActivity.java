package com.example.fatecanos.alunosmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.example.fatecanos.alunosmobile.dbs.ControllerAluno;
import com.example.fatecanos.alunosmobile.modelos.AlunoBean;
import com.example.fatecanos.alunosmobile.R;

public class LoginActivity extends AppCompatActivity {

    EditText login,senha;
    Button addAlu, entrar;
    String slogin;
    String ssenha;
    AlunoBean aluEnt;
    AlunoBean aluSai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final ControllerAluno ge = new ControllerAluno(getBaseContext());

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);

        slogin = login.getText().toString();
        ssenha = senha.getText().toString();

        aluEnt = new AlunoBean();
        aluEnt.setLogin(slogin);
        aluEnt.setSenha(ssenha);

        /*addAlu = (Button) findViewById(R.id.btnovoalu);
        addAlu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(LoginActivity.this, AddAluActivity.class);
                startActivity(it);
            }
        });*/

        entrar = (Button) findViewById(R.id.btentrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                aluSai = ge.validarAlunos(aluEnt);
                Intent it = new Intent(LoginActivity.this, PreMenuActivity.class);
                it.putExtra("AlunoLogado",aluSai);
                startActivity(it);
            }
        });

    }
}
