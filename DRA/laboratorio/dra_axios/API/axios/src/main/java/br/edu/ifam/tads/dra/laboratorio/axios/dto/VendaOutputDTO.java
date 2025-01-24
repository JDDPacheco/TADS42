package br.edu.ifam.tads.dra.laboratorio.axios.dto;

import br.edu.ifam.tads.dra.laboratorio.axios.model.Produto;
import br.edu.ifam.tads.dra.laboratorio.axios.model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaOutputDTO {
    private String mes;
    private List<ProdutoOutputDTO> produtos;

    public VendaOutputDTO(Venda venda){
        this.mes = venda.getMes();
        this.produtos = new ArrayList<>();
        for(Produto produtos: venda.getProdutos()){
            this.produtos.add(new ProdutoOutputDTO(produtos));
        };
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public List<ProdutoOutputDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoOutputDTO> produtos) {
        this.produtos = produtos;
    }
}
