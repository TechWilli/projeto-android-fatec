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

    /*public UsuarioBean validarUsuarios(UsuarioBean usuEnt) {
        UsuarioBean usu = new UsuarioBean();
        String loginPar = '"' + usuEnt.getLogin().trim() + '"';
        String senhaPar = '"' + usuEnt.getSenha().trim() + '"';
        String selectQuery = "SELECT ID, LOGIN, SENHA, STATUS, TIPO FROM USUARIOS WHERE LOGIN = ? AND SENHA = ? " ;
        String[] whereArgs = new String [] {loginPar,senhaPar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        usu.setLogin("0 = " + loginPar + "1 = " +senhaPar);
        if (cursor.moveToFirst()) {
            do {
                usu.setId(""+cursor.getInt(0));
                usu.setLogin(cursor.getString(1));
                usu.setSenha(cursor.getString(2));
                usu.setStatus(cursor.getString(3));
                usu.setTipo(cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return usu;
    }

    public List<UsuarioBean> listarUsuariosTeste() {
        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        for (int i = 0; i < 10; i++ ) {
            UsuarioBean usu = new UsuarioBean();
            usu.setId(" Id " + i);
            usu.setLogin(" Login " + i);
            usu.setSenha(" Senha " + i);
            usu.setStatus(" Status " + i);
            usu.setTipo(" Tipo " + i);
            usuarios.add(usu);
        }
        return usuarios;
    }*/
}
