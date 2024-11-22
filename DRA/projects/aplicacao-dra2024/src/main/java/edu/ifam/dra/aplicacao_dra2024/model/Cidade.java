package edu.ifam.dra.aplicacao_dra2024.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String estado;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    private List<Pessoa> pessoas = new ArrayList<>();
}
