package br.edu.ifam.tads.dra.laboratorio.axios.dto;

import br.edu.ifam.tads.dra.laboratorio.axios.model.Produto;
import br.edu.ifam.tads.dra.laboratorio.axios.model.Venda;

import java.util.List;

public class VendaInputDTO {
    private String mes;
    private List<Produto> produtos;

    public Venda build(){
        Venda venda = new Venda();
        venda.setMes(this.mes);
        venda.setProdutos(this.produtos);
        return venda;
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
