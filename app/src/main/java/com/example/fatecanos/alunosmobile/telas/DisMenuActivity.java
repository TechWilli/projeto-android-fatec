package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fatecanos.alunosmobile.R;

public class DisMenuActivity extends AppCompatActivity{

    Button addDis, listDis, listDisPar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis_menu);
        Intent it = getIntent();

        listDis = (Button) findViewById(R.id.btlistdis);
        listDis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(DisMenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });

        listDisPar = (Button) findViewById(R.id.btlistdisParam);
        listDisPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(DisMenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });

        addDis = (Button) findViewById(R.id.btnovadis);
        addDis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(DisMenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });
    }
}
