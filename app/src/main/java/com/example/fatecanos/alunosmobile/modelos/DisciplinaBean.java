package com.example.fatecanos.alunosmobile.modelos;

import java.io.Serializable;

public class DisciplinaBean implements Serializable {

    String id;
    String disciplina;
    String prof;
    String curso;
    String periodo;

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getDisciplina() { return disciplina; }

    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }

    public String getProf() { return prof; }

    public void setProf(String prof) { this.prof = prof; }

    public String getCurso() { return curso; }

    public void setCurso(String curso) { this.curso = curso; }

    public String getPeriodo() { return periodo; }

    public void setPeriodo(String periodo) { this.periodo = periodo; }

    @Override
    public String toString() {
        return "\n" + "ID: " + id + "\nDISCIPLINA: " + disciplina + "\nPROFESSOR: " + prof +
                "\nCURSO: " + curso + "\nPERÍODO: " + periodo + '\n'; }
}