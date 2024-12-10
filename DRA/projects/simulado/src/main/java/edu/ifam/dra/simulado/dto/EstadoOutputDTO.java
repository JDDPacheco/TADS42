package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Estado;

public class EstadoOutputDTO {

    private String ibge;
    private String nome;

    public EstadoOutputDTO(Estado estado) {
        this.ibge = estado.getIbge();
        this.nome = estado.getNome();
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
}
