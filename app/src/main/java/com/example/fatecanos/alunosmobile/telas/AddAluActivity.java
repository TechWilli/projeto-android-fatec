package com.example.fatecanos.alunosmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerAluno;
import com.example.fatecanos.alunosmobile.modelos.AlunoBean;

public class AddAluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alu);
        final ControllerAluno ge = new ControllerAluno(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText login  = (EditText) findViewById(R.id.login);
                EditText senha  = (EditText) findViewById((R.id.senha));
                EditText ra = (EditText) findViewById(R.id.ra);
                EditText curso   = (EditText) findViewById(R.id.curso);

                String loginString = login.getText().toString();
                String senhaString = senha.getText().toString();
                String raString = ra.getText().toString();
                String cursoString = curso.getText().toString();

                AlunoBean alu = new AlunoBean();
                alu.setId("");
                alu.setLogin(loginString);
                alu.setSenha(senhaString);
                alu.setRa(raString);
                alu.setCurso(cursoString);
                String msg = ge.inserir(alu);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
