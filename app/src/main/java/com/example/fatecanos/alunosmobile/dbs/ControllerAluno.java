package com.example.fatecanos.alunosmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fatecanos.alunosmobile.modelos.AlunoBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerAluno {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerAluno(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(AlunoBean alu) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("LOGIN", alu.getLogin());
        valores.put("SENHA", alu.getSenha());
        valores.put("RA", alu.getRa());
        valores.put("CURSO", alu.getCurso());
        resultado = db.insert(BancoHelper.TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir aluno";
        } else {
            retorno = "Aluno Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(AlunoBean alu) {
        String retorno = "Aluno Excluido com Sucesso";
        String where = "ID = " + alu.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA,where,null);
        db.close();
        return retorno;
    }

    public String alterar(AlunoBean alu) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Aluno Alterado com sucesso";
        String where = "ID = " + alu.getId();
        valores = new ContentValues();
        valores.put("LOGIN", alu.getLogin());
        valores.put("SENHA", alu.getSenha());
        valores.put("RA", alu.getRa());
        valores.put("CURSO", alu.getCurso());
        db.update(BancoHelper.TABELA, valores,where,null);
        db.close();
        return retorno;
    }

    public List<AlunoBean> listarAlunos() {
        List<AlunoBean> alunos = new ArrayList<AlunoBean>();
        String selectQuery = "SELECT * FROM ALUNOS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                AlunoBean alu = new AlunoBean();
                alu.setId(""+cursor.getInt(0));
                alu.setLogin(cursor.getString(1));
                alu.setSenha(cursor.getString(2));
                alu.setRa(cursor.getString(3));
                alu.setCurso(cursor.getString(4));
                alunos.add(alu);
            } while (cursor.moveToNext());
        }
        return alunos;
    }

    public List<AlunoBean> listarAlunos(AlunoBean aluEnt) {
        List<AlunoBean> alunos = new ArrayList<AlunoBean>();
        String parametro = aluEnt.getLogin();
        String selectQuery = "SELECT ID, LOGIN, SENHA, RA, CURSO FROM ALUNOS WHERE LOGIN LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                AlunoBean alu = new AlunoBean();
                alu.setId(""+cursor.getInt(0));
                alu.setLogin(cursor.getString(1));
                alu.setSenha(cursor.getString(2));
                alu.setRa(cursor.getString(3));
                alu.setCurso(cursor.getString(4));
                alunos.add(alu);
            } while (cursor.moveToNext());
        }
        return alunos;
    }

    public AlunoBean validarAlunos(AlunoBean aluEnt) {
        AlunoBean alu = new AlunoBean();
        String loginPar = '"' + aluEnt.getLogin().trim() + '"';
        String senhaPar = '"' + aluEnt.getSenha().trim() + '"';
        String selectQuery = "SELECT ID, LOGIN, SENHA, RA, CURSO FROM ALUNOS WHERE LOGIN = ? AND SENHA = ? " ;
        String[] whereArgs = new String [] {loginPar,senhaPar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        alu.setLogin("0 = " + loginPar + "1 = " +senhaPar);
        if (cursor.moveToFirst()) {
            do {
                alu.setId(""+cursor.getInt(0));
                alu.setLogin(cursor.getString(1));
                alu.setSenha(cursor.getString(2));
                alu.setRa(cursor.getString(3));
                alu.setCurso(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return alu;
    }

    public List<AlunoBean> listarAlunosTeste() {
        List<AlunoBean> alunos = new ArrayList<AlunoBean>();
        for (int i = 0; i < 10; i++ ) {
            AlunoBean alu = new AlunoBean();
            alu.setId(" Id " + i);
            alu.setLogin(" Login " + i);
            alu.setSenha(" Senha " + i);
            alu.setRa(" Ra " + i);
            alu.setCurso(" Curso " + i);
            alunos.add(alu);
        }
        return alunos;
    }
}
