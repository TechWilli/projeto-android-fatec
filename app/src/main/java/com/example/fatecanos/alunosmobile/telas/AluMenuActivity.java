package com.example.fatecanos.alunosmobile.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.fatecanos.alunosmobile.R;
import com.example.fatecanos.alunosmobile.modelos.UsuarioBean;

public class AluMenuActivity extends AppCompatActivity {

    Button addUsu, listUsu, listUsuPar;
    //TextView textUsuLogado;
    //UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alu_menu);
        Intent it = getIntent();
        //usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");

        listUsu = (Button) findViewById(R.id.btlistusu);
        //textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado);
        //textUsuLogado.setText(usuLogado.getLogin());
        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AluMenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });

        listUsuPar = (Button) findViewById(R.id.btlistusuParam);
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AluMenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });

        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(AluMenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });
    }

}
