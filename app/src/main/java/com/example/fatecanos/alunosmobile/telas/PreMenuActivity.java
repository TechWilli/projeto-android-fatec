package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.modelos.UsuarioBean;

public class PreMenuActivity extends AppCompatActivity {

    Button areaAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_menu);

        areaAluno = (Button) findViewById(R.id.btareaalunos);
        areaAluno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(PreMenuActivity.this, MenuActivity.class);
                startActivity(it);
            }
        });


    }

}
