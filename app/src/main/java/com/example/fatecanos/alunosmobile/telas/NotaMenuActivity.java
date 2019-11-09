package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fatecanos.alunosmobile.R;

public class NotaMenuActivity extends AppCompatActivity{

    Button addNota, listNota, listNotaPar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_menu);
        Intent it = getIntent();

        listNota = (Button) findViewById(R.id.btlistnota);
        listNota.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(NotaMenuActivity.this, ListNotaActivity.class);
                startActivity(it);
            }
        });

        listNotaPar = (Button) findViewById(R.id.btlistnotaParam);
        listNotaPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(NotaMenuActivity.this, ListNotaParamActivity.class);
                startActivity(it);
            }
        });

        addNota = (Button) findViewById(R.id.btnovanota);
        addNota.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(NotaMenuActivity.this, AddNotaActivity.class);
                startActivity(it);
            }
        });
    }
}
