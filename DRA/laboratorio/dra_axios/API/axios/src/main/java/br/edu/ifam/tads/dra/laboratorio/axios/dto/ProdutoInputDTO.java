package br.edu.ifam.tads.dra.laboratorio.axios.dto;

import br.edu.ifam.tads.dra.laboratorio.axios.model.Produto;

public class ProdutoInputDTO {
    private String nome;
    private float preco;

    public Produto build() {
        Produto produto = new Produto();
        produto.setNome(this.nome);
        produto.setPreco(this.preco);
        return produto;
    }

    public ProdutoInputDTO() {}

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