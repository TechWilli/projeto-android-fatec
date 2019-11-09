package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerDisciplina;
import com.example.fatecanos.alunosmobile.modelos.DisciplinaBean;

public class UptDisActivity extends AppCompatActivity {

    Button uptDis, delDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_dis);
        final ControllerDisciplina di = new ControllerDisciplina(getBaseContext());
        final EditText disciplina = (EditText) findViewById(R.id.nomedis);
        final EditText prof = (EditText) findViewById(R.id.prof);
        final EditText curso = (EditText) findViewById(R.id.curso);
        final EditText periodo = (EditText) findViewById(R.id.periodo);
        Intent it = getIntent();
        final DisciplinaBean recuperado = (DisciplinaBean) it.getSerializableExtra("Disciplina");
        disciplina.setText(recuperado.getDisciplina());
        prof.setText(recuperado.getProf());
        curso.setText(recuperado.getCurso());
        periodo.setText(recuperado.getPeriodo());

        uptDis = (Button) findViewById(R.id.btalterardis);
        uptDis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String disString = disciplina.getText().toString();
                String profString = prof.getText().toString();
                String cursoString = curso.getText().toString();
                String periodoString = periodo.getText().toString();
                recuperado.setDisciplina(disString);
                recuperado.setProf(profString);
                recuperado.setCurso(cursoString);
                recuperado.setPeriodo(periodoString);
                String msg = di.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delDis = (Button) findViewById(R.id.btexcluirdis);
        delDis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = di.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
