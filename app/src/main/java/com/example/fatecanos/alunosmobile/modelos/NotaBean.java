package com.example.fatecanos.alunosmobile.modelos;

import java.io.Serializable;

public class NotaBean implements Serializable {

    private String id;
    private String idAlu;
    private String idDis;
    private String p1;
    private String p2;
    private String sitFinal;
    private AlunoBean alu;
    private DisciplinaBean dis;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getIdAlu() { return idAlu; }

    public void setIdAlu(String idAlu) { this.idAlu = idAlu; }

    public String getIdDis() { return idDis; }

    public void setIdDis(String idDis) { this.idDis = idDis; }

    public String getP1() { return p1; }

    public void setP1(String p1) { this.p1 = p1; }

    public String getP2() { return p2; }

    public void setP2(String p2) { this.p2 = p2; }

    public String getSitFinal() { return sitFinal; }

    public void setSitFinal(String sitFinal) { this.sitFinal = sitFinal; }

    public AlunoBean getAlu() { return alu; }

    public void setAlu(AlunoBean alu) { this.alu = alu; }

    public DisciplinaBean getDis() { return dis; }

    public void setDis(DisciplinaBean dis) { this.dis = dis; }

    @Override
    public String toString() {
        return "\n" + "ID: " + id + "\nID ALUNO: " + idAlu + "\nID DISCIPLINA: " + idDis+ "\nP1: " + p1 + "\nP2: " + p2 +
                "\nSITUAÇÃO FINAL: " + sitFinal + '\n'; }
}
