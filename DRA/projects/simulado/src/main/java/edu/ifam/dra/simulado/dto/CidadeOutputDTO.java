package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.model.Estado;

public class CidadeOutputDTO {

    private String ibge;
    private String nome;
    private String estado;

    public CidadeOutputDTO(Cidade cidade){
        this.ibge = cidade.getIbge();
        this.nome = cidade.getNome();
        this.estado = cidade.getEstado().getNome();
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
