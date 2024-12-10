package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.model.Estado;

public class CidadeOutputDTO {

    private String ibge;
    private String nome;
    private Estado estado;

    public CidadeOutputDTO(Cidade cidade){
        this.ibge = cidade.getIbge();
        this.nome = cidade.getNome();
        this.estado = cidade.getEstado();
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
