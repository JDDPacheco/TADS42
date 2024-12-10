package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Pessoa;

public class PessoaOutputDTO {

    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String nomeLogradouro;
    private String numeroEndereco;
    private String complementoEndereco;

    public PessoaOutputDTO(Pessoa pessoa){
        this.cpf = pessoa.getCpf();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.telefone = pessoa.getTelefone();
        this.nomeLogradouro = pessoa.getLogradouro().getNome();
        this.numeroEndereco = pessoa.getNumeroEndereco();
        this.complementoEndereco = pessoa.getComplementoEndereco();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }
}
