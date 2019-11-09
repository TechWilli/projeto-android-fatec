package com.example.fatecanos.alunosmobile.modelos;

import java.io.Serializable;

public class AlunoBean implements Serializable {

    private String id;
    private String login;
    private String senha;
    private String ra;
    private String curso;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "\n" + "ID: " + id + "\nLOGIN: " + login + "\nSENHA: " + senha + "\nRA: " + ra +
                "\nCURSO: " + curso + '\n'; }
}
