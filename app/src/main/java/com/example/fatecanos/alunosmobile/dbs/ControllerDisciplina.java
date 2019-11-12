package com.example.fatecanos.alunosmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fatecanos.alunosmobile.modelos.DisciplinaBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerDisciplina {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerDisciplina(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(DisciplinaBean dis) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("DISCIPLINA", dis.getDisciplina());
        valores.put("PROFESSOR", dis.getProf());
        valores.put("CURSO", dis.getCurso());
        valores.put("PERIODO", dis.getPeriodo());
        resultado = db.insert(BancoHelper.TABELA_DIS, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir disciplina";
        } else {
            retorno = "Disciplina Inserida com sucesso";
        }
        return retorno;
    }

    public String excluir(DisciplinaBean dis) {
        String retorno = "Disciplina Excluida com Sucesso";
        String where = "ID = " + dis.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELA_DIS,where,null);
        db.close();
        return retorno;
    }

    public String alterar(DisciplinaBean dis) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Disciplina Alterada com sucesso";
        String where = "ID = " + dis.getId();
        valores = new ContentValues();
        valores.put("DISCIPLINA", dis.getDisciplina());
        valores.put("PROFESSOR", dis.getProf());
        valores.put("CURSO", dis.getCurso());
        valores.put("PERIODO", dis.getPeriodo());
        db.update(BancoHelper.TABELA_DIS, valores,where,null);
        db.close();
        return retorno;
    }

    public List<DisciplinaBean> listarDisciplinas() {
        List<DisciplinaBean> disciplinas = new ArrayList<DisciplinaBean>();
        String selectQuery = "SELECT * FROM DISCIPLINAS" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                DisciplinaBean dis = new DisciplinaBean();
                dis.setId(""+cursor.getInt(0));
                dis.setDisciplina(cursor.getString(1));
                dis.setProf(cursor.getString(2));
                dis.setCurso(cursor.getString(3));
                dis.setPeriodo(cursor.getString(4));
                disciplinas.add(dis);
            } while (cursor.moveToNext());
        }
        return disciplinas;
    }

    public List<DisciplinaBean> listarDisciplinas(DisciplinaBean disEnt) {
        List<DisciplinaBean> disciplinas = new ArrayList<DisciplinaBean>();
        String parametro = disEnt.getProf();
        String selectQuery = "SELECT ID, DISCIPLINA, PROFESSOR, CURSO, PERIODO FROM DISCIPLINAS WHERE PROFESSOR LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                DisciplinaBean dis = new DisciplinaBean();
                dis.setId(""+cursor.getInt(0));
                dis.setDisciplina(cursor.getString(1));
                dis.setProf(cursor.getString(2));
                dis.setCurso(cursor.getString(3));
                dis.setPeriodo(cursor.getString(4));
                disciplinas.add(dis);
            } while (cursor.moveToNext());
        }
        return disciplinas;
    }

}
