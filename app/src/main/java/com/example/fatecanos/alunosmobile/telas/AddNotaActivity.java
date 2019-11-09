package com.example.fatecanos.alunosmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerNota;
import com.example.fatecanos.alunosmobile.modelos.NotaBean;

public class AddNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);
        final ControllerNota no = new ControllerNota(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserirnota);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomealuno = (EditText) findViewById(R.id.nomealuno);
                EditText p1 = (EditText) findViewById((R.id.p1));
                EditText p2 = (EditText) findViewById(R.id.p2);
                EditText sitfinal = (EditText) findViewById(R.id.sitfinal);

                String nomeAlunoString = nomealuno.getText().toString();
                String p1String = p1.getText().toString();
                String p2String = p2.getText().toString();
                String sitFinalString = sitfinal.getText().toString();

                NotaBean nota = new NotaBean();
                nota.setId("");
                nota.setNomeAluno(nomeAlunoString);
                nota.setP1(p1String);
                nota.setP2(p2String);
                nota.setSitFinal(sitFinalString);
                String msg = no.inserir(nota);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
