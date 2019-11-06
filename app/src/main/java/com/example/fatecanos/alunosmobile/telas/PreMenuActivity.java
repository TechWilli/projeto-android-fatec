package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;

import com.example.fatecanos.alunosmobile.R;

public class PreMenuActivity extends AppCompatActivity {

    Button areaAluno, areaDisciplina, areaNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_menu);

        areaAluno = (Button) findViewById(R.id.btareaalunos);
        areaAluno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(PreMenuActivity.this, AluMenuActivity.class);
                startActivity(it);
            }
        });

        areaDisciplina = (Button) findViewById(R.id.btareadisciplinas);
        areaDisciplina.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(PreMenuActivity.this, DisMenuActivity.class);
                startActivity(it);
            }
        });

        areaNota = (Button) findViewById(R.id.btareanotas);
        areaNota.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(PreMenuActivity.this, NotaMenuActivity.class);
                startActivity(it);
            }
        });


    }

}
