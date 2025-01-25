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
    private List<ItemVenda> itensVenda;

    private float valorTotal;

    public Venda() {}

    public Venda(Long id, String mes, List<ItemVenda> itensVenda) {
        this.id = id;
        this.mes = mes;
        this.itensVenda = itensVenda;
        float valorTotal = 0;
        for(ItemVenda item: itensVenda){
            valorTotal = valorTotal + item.getValorItemVenda();
        }
        this.valorTotal = valorTotal;
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }
}
