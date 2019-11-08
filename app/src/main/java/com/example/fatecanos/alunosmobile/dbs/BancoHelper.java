package com.example.fatecanos.alunosmobile.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "ALUNOS_FATECANOS_TESTE.db"; // na ultima versao deixar só ALUNOSFATECANOS

    public static final String TABELA = "USUARIOS";
    public static final String TABELA_DIS = "DISCIPLINAS";

    private static final int VERSAO_SCHEMA = 1;

    private final String S_CREATE;
    private final String S_CREATE_DIS;

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATE = "CREATE TABLE USUARIOS " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "LOGIN TEXT, " +
                "SENHA TEXT, " +
                "STATUS TEXT, " +
                "TIPO TEXT);";

        this.S_CREATE_DIS = "CREATE TABLE DISCIPLINAS " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DISCIPLINA TEXT, " +
                "PROFESSOR TEXT, " +
                "CURSO TEXT, " +
                "PERIODO TEXT);";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE);
        db.execSQL(S_CREATE_DIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_DIS);
        onCreate(db);
    }

}
