package edu.ifam.dra.simulado.model;

import jakarta.persistence.*;

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
}
