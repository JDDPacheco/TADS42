package com.luizfelipe.recycler.entity;

public class Fornecedor {
    private int codigo;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public Fornecedor(int codigo, String nome, String telefone, String email, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() { return endereco; }
}

