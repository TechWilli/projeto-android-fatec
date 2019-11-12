package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerNota;
import com.example.fatecanos.alunosmobile.modelos.NotaBean;

public class UptNotaActivity extends AppCompatActivity {

    Button uptNota, delNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_nota);
        final ControllerNota no = new ControllerNota(getBaseContext());

        final EditText idaluno = (EditText) findViewById(R.id.idaluno);
        final EditText iddisciplina = (EditText) findViewById(R.id.iddisciplina);
        final EditText p1 = (EditText) findViewById(R.id.p1);
        final EditText p2 = (EditText) findViewById(R.id.p2);
        final EditText sitfinal = (EditText) findViewById(R.id.sitfinal);
        Intent it = getIntent();
        final NotaBean recuperado = (NotaBean) it.getSerializableExtra("Nota");

        idaluno.setText(recuperado.getIdAlu());
        iddisciplina.setText(recuperado.getIdDis());
        p1.setText(recuperado.getP1());
        p2.setText(recuperado.getP2());
        sitfinal.setText(recuperado.getSitFinal());

        uptNota = (Button) findViewById(R.id.btalterarnota);
        uptNota.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String idAlunoString = idaluno.getText().toString();
                String iddisciplinaString = iddisciplina.getText().toString();
                String p1String = p1.getText().toString();
                String p2String = p2.getText().toString();
                String sitFinalString = sitfinal.getText().toString();

                recuperado.setIdAlu(idAlunoString);
                recuperado.setIdDis((iddisciplinaString));
                recuperado.setP1(p1String);
                recuperado.setP2(p2String);
                recuperado.setSitFinal(sitFinalString);
                String msg = no.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delNota = (Button) findViewById(R.id.btexcluirnota);
        delNota.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = no.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}
