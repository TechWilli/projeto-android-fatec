package com.example.fatecanos.alunosmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fatecanos.alunosmobile.modelos.NotaBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerNota {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerNota(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(NotaBean nota) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("ALUNO", nota.getNomeAluno());
        valores.put("P1", nota.getP1());
        valores.put("P2", nota.getP2());
        valores.put("SITFINAL", nota.getSitFinal());
        resultado = db.insert(BancoHelper.TABELA_NOTA, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir Nota";
        } else {
            retorno = "Nota Inserida com sucesso";
        }
        return retorno;
    }

    public String excluir(NotaBean nota) {
        String retorno = "Nota Excluida com Sucesso";
        String where = "ID = " + nota.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_NOTA,where,null);
        db.close();
        return retorno;
    }

    public String alterar(NotaBean nota) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Nota Alterada com sucesso";
        String where = "ID = " + nota.getId();
        valores = new ContentValues();
        valores.put("ALUNO", nota.getNomeAluno());
        valores.put("P1", nota.getP1());
        valores.put("P2", nota.getP2());
        valores.put("SITFINAL", nota.getSitFinal());
        db.update(BancoHelper.TABELA_NOTA, valores,where,null);
        db.close();
        return retorno;
    }

    public List<NotaBean> listarNotas() {
        List<NotaBean> notas = new ArrayList<NotaBean>();
        String selectQuery = "SELECT * FROM NOTAS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                NotaBean nota = new NotaBean();
                nota.setId(""+cursor.getInt(0));
                nota.setNomeAluno(cursor.getString(1));
                nota.setP1(cursor.getString(2));
                nota.setP2(cursor.getString(3));
                nota.setSitFinal(cursor.getString(4));
                notas.add(nota);
            } while (cursor.moveToNext());
        }
        return notas;
    }

    public List<NotaBean> listarNotas(NotaBean notaEnt) {
        List<NotaBean> notas = new ArrayList<NotaBean>();
        String parametro = notaEnt.getSitFinal();
        String selectQuery = "SELECT ID, ALUNO, P1, P2, SITFINAL FROM NOTAS WHERE SITFINAL LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                NotaBean nota = new NotaBean();
                nota.setId(""+cursor.getInt(0));
                nota.setNomeAluno(cursor.getString(1));
                nota.setP1(cursor.getString(2));
                nota.setP2(cursor.getString(3));
                nota.setSitFinal(cursor.getString(4));
                notas.add(nota);
            } while (cursor.moveToNext());
        }
        return notas;
    }

    /*public AlunoBean validarAlunos(AlunoBean aluEnt) {
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
    }*/
}
