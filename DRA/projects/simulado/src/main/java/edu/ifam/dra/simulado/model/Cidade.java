package edu.ifam.dra.simulado.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade {

    @Id
    @Column(nullable = false, unique = true)
    private String ibge; //(nn, unique)

    @Column(nullable = false)
    private String nome; //(nn)

    @ManyToOne
    @JoinColumn(name = "estado_ibge", nullable = false)
    private Estado estado; //(nn)

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    private List<Logradouro> logradouros = new ArrayList<>();

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Logradouro> getLogradouros() {
        return logradouros;
    }

    public void setLogradouros(List<Logradouro> logradouros) {
        this.logradouros = logradouros;
    }
}
