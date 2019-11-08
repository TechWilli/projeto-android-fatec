package com.example.fatecanos.alunosmobile.telas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.dbs.ControllerDisciplina;
import com.example.fatecanos.alunosmobile.modelos.DisciplinaBean;

public class AddDisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dis);
        final ControllerDisciplina di = new ControllerDisciplina(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserirdis);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomedis = (EditText) findViewById(R.id.nomedis);
                EditText prof = (EditText) findViewById((R.id.prof));
                EditText curso = (EditText) findViewById(R.id.curso);
                EditText periodo = (EditText) findViewById(R.id.periodo);

                String disString = nomedis.getText().toString();
                String profString = prof.getText().toString();
                String cursoString = curso.getText().toString();
                String periodoString = periodo.getText().toString();

                DisciplinaBean dis = new DisciplinaBean();
                dis.setId("");
                dis.setDisciplina(disString);
                dis.setProf(profString);
                dis.setCurso(cursoString);
                dis.setPeriodo(periodoString);
                String msg = di.inserir(dis);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}
