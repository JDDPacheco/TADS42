package edu.ifam.dra.aplicacao_dra2024.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String estado;

    @ManyToOne
    private List<Pessoa> pessoas;
}
