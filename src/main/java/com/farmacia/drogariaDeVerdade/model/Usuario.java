package com.farmacia.drogariaDeVerdade.model;

public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private String data;
    private String cpf;

    public Usuario() {
    }

    public Usuario(int id, String nome, String senha, String data, String cpf) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.data = data;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
