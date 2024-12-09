package edu.ifam.dra.simulado.model;

import jakarta.persistence.*;

@Entity
public class Pessoa {

    @Column(nullable = false)
    private String nome; //(nn)

    @Id
    @Column(nullable = false, unique = true)
    private String cpf; //(nn, unique)

    @Column(nullable = false, unique = true)
    private String email; //(nn, unique)

    private String telefone;

    @ManyToOne
    @Column(nullable = false)
    private Logradouro logradouro;

    @Column(nullable = false)
    private String numeroEndereco;

    private String complementoEndereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }
}
