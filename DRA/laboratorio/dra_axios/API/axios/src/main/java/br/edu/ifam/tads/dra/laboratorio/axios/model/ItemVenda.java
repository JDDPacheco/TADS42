package br.edu.ifam.tads.dra.laboratorio.axios.model;

import jakarta.persistence.*;

public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private Produto produtos;

    @Column(nullable = false)
    private int quantidade;

    private float valorItemVenda;

    public ItemVenda() {}

    public ItemVenda(Long id, Produto produtos, int quantidade) {
        this.id = id;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.valorItemVenda = produtos.getPreco() * quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorItemVenda() {
        return valorItemVenda;
    }

    public void setValorItemVenda(float valorItemVenda) {
        this.valorItemVenda = valorItemVenda;
    }
}
