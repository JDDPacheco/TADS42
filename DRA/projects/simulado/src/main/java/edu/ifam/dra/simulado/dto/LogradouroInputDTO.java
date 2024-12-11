package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Logradouro;
import edu.ifam.dra.simulado.repository.CidadeRepository;

public class LogradouroInputDTO {
    private String cep;
    private String nome;
    private String cidadeIBGE;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidadeIBGE() {
        return cidadeIBGE;
    }

    public void setCidadeIBGE(String cidadeIBGE) {
        this.cidadeIBGE = cidadeIBGE;
    }

    public Logradouro build(CidadeRepository cidadeRepository){
        Logradouro logradouro = new Logradouro();
        logradouro.setCep(this.cep);
        logradouro.setNome(this.nome);
        logradouro.setCidade(cidadeRepository.findById(this.cidadeIBGE).get());
        return logradouro;
    }
}
