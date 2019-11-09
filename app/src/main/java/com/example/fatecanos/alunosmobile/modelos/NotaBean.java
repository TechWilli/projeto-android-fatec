package com.example.fatecanos.alunosmobile.modelos;

import java.io.Serializable;

public class NotaBean implements Serializable {

    private String id;
    private String nomeAluno;
    private String p1;
    private String p2;
    private String sitFinal;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getNomeAluno() { return nomeAluno; }

    public void setNomeAluno(String nomeAluno) { this.nomeAluno = nomeAluno; }

    public String getP1() { return p1; }

    public void setP1(String p1) { this.p1 = p1; }

    public String getP2() { return p2; }

    public void setP2(String p2) { this.p2 = p2; }

    public String getSitFinal() { return sitFinal; }

    public void setSitFinal(String sitFinal) { this.sitFinal = sitFinal; }

    @Override
    public String toString() {
        return "\n" + "ID: " + id + "\nALUNO: " + nomeAluno + "\nP1: " + p1 + "\nP2: " + p2 +
                "\nSITUAÇÃO FINAL: " + sitFinal + '\n'; }
}
