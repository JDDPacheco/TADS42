package br.edu.ifam.tads.dra.laboratorio.axios.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mes;

    @ManyToMany(mappedBy = "vendas", fetch = FetchType.LAZY)
    private List<Produto> produtos;

    public Venda() {}

    public Venda(Long id, String mes, List<Produto> produtos) {
        this.id = id;
        this.mes = mes;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
