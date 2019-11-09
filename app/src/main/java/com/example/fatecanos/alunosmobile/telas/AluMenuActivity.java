package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fatecanos.alunosmobile.R;

public class AluMenuActivity extends AppCompatActivity {

    Button addAlu, listAlu, listAluPar;
    //TextView textAluLogado;
    //AlunoBean aluLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alu_menu);
        Intent it = getIntent();
        //aluLogado = (AlunoBean) it.getSerializableExtra("AlunoLogado");

        listAlu = (Button) findViewById(R.id.btlistalu);
        //textAluLogado = (TextView) findViewById(R.id.lbAluLogado);
        //textAluLogado.setText(aluLogado.getLogin());
        listAlu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AluMenuActivity.this, ListAluActivity.class);
                startActivity(it);
            }
        });

        listAluPar = (Button) findViewById(R.id.btlistaluParam);
        listAluPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AluMenuActivity.this, ListAluParamActivity.class);
                startActivity(it);
            }
        });

        addAlu = (Button) findViewById(R.id.btnovoalu);
        addAlu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AluMenuActivity.this, AddAluActivity.class);
                startActivity(it);
            }
        });
    }

}
