package com.example.fatecanos.alunosmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fatecanos.alunosmobile.modelos.AlunoBean;
import com.example.fatecanos.alunosmobile.modelos.DisciplinaBean;
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
        valores.put("IDALUNO", nota.getIdAlu());
        valores.put("IDDISCIPLINA", nota.getIdDis());
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
        valores.put("IDALUNO", nota.getIdAlu());
        valores.put("IDDISCIPLINA", nota.getIdDis());
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
                nota.setIdAlu(""+cursor.getInt(1));
                nota.setIdDis(""+cursor.getInt(2));
                nota.setP1(cursor.getString(3));
                nota.setP2(cursor.getString(4));
                nota.setSitFinal(cursor.getString(5));
                notas.add(nota);
            } while (cursor.moveToNext());
        }
        return notas;
    }

    public List<NotaBean> listarNotas(NotaBean notaEnt) {
        List<NotaBean> notas = new ArrayList<NotaBean>();
        String parametro = notaEnt.getSitFinal();
        String selectQuery = "SELECT ID, IDALUNO, IDDISCIPLINA, P1, P2, SITFINAL FROM NOTAS WHERE SITFINAL LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                NotaBean nota = new NotaBean();
                nota.setId(""+cursor.getInt(0));
                nota.setIdAlu(""+cursor.getInt(1));
                nota.setIdDis(""+cursor.getInt(2));
                nota.setP1(cursor.getString(3));
                nota.setP2(cursor.getString(4));
                nota.setSitFinal(cursor.getString(5));
                notas.add(nota);
            } while (cursor.moveToNext());
        }
        return notas;
    }

}
