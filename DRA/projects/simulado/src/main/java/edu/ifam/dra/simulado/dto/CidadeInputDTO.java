package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.repository.EstadoRepository;

public class CidadeInputDTO {

    private String ibge;
    private String nome;
    private String estadoIBGE;

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

    public String getEstadoIBGE() {
        return estadoIBGE;
    }

    public void setEstadoIBGE(String estadoIBGE) {
        this.estadoIBGE = estadoIBGE;
    }

    public Cidade build(EstadoRepository estadoRepository){
        Cidade cidade = new Cidade();
        cidade.setIbge(this.ibge);
        cidade.setNome(this.nome);
        cidade.setEstado(estadoRepository.findById(this.estadoIBGE).get());
        return cidade;
    }
}
