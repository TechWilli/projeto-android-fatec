package com.example.fatecanos.alunosmobile.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoHelper extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "ALUNOS_FATECANOS_TESTE3.db"; // na ultima versao deixar só ALUNOSFATECANOS

    public static final String TABELA = "ALUNOS";
    public static final String TABELA_DIS = "DISCIPLINAS";
    public static final String TABELA_NOTA = "NOTAS";

    private static final int VERSAO_SCHEMA = 1;

    private final String S_CREATE;
    private final String S_CREATE_DIS;
    private final String S_CREATE_NOTA;

    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.S_CREATE = "CREATE TABLE ALUNOS " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "LOGIN TEXT, " +
                "SENHA TEXT, " +
                "RA TEXT, " +
                "CURSO TEXT);";

        this.S_CREATE_DIS = "CREATE TABLE DISCIPLINAS " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DISCIPLINA TEXT, " +
                "PROFESSOR TEXT, " +
                "CURSO TEXT, " +
                "PERIODO TEXT);";

        this.S_CREATE_NOTA = "CREATE TABLE NOTAS " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ALUNO TEXT, " +
                "P1 TEXT, " +
                "P2 TEXT, " +
                "SITFINAL TEXT);";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE);
        db.execSQL(S_CREATE_DIS);
        db.execSQL(S_CREATE_NOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_DIS);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_NOTA);
        onCreate(db);
    }

}
