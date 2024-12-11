package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.model.Logradouro;

public class LogradouroOutputDTO {

    private String cep;
    private String nome;
    private String cidade;

    public LogradouroOutputDTO(Logradouro logradouro) {
        this.cep = logradouro.getCep();
        this.nome = logradouro.getNome();
        this.cidade = logradouro.getCidade().getNome();
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
