package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.model.Logradouro;

public class LogradouroOutputDTO {

    private String cep;
    private String nome;
    private Cidade cidade;

    public LogradouroOutputDTO(Logradouro logradouro) {
        this.cep = logradouro.getCep();
        this.nome = logradouro.getNome();
        this.cidade = logradouro.getCidade();
    }

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
