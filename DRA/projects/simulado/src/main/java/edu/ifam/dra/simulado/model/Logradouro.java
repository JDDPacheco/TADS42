package edu.ifam.dra.simulado.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Logradouro {
    @Id
    @Column(nullable = false, unique = true)
    private String cep; //(nn, unique)

    @Column(nullable = false)
    private String nome; //(nn)

    @ManyToOne
    @Column(nullable = false)
    private Cidade cidade; //(nn)

    @OneToMany(mappedBy = "logradouro", fetch = FetchType.LAZY)
    private List<Pessoa> pessoas = new ArrayList<>();

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
