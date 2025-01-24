package br.edu.ifam.tads.dra.laboratorio.axios.dto;

import br.edu.ifam.tads.dra.laboratorio.axios.model.Produto;

public class ProdutoOutputDTO {
    private Long id;
    private String nome;
    private float preco;

    public ProdutoOutputDTO() {}

    public ProdutoOutputDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}

