package com.farmacia.drogariaDeVerdade.model;

import java.util.Date;

public class Usuario {
    private String nome;
    private String senha;
    private Date data;
    private String cpf;
    
    public Usuario(){
    }

    public Usuario(String nome, String senha, Date data, String cpf) {
        this.nome = nome;
        this.senha = senha;
        this.data = data;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
