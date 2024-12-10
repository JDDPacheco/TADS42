package edu.ifam.dra.simulado.dto;

import edu.ifam.dra.simulado.model.Pessoa;
import edu.ifam.dra.simulado.repository.LogradouroRepository;

public class PessoaInputDTO{

    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String cepLogradouro;
    private String numeroEndereco;
    private String complementoEndereco;

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

    public String getCepLogradouro() {
        return cepLogradouro;
    }

    public void setCepLogradouro(String cepLogradouro) {
        this.cepLogradouro = cepLogradouro;
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

    public Pessoa build(LogradouroRepository logradouroRepository){
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(this.cpf);
        pessoa.setNome(this.nome);
        pessoa.setEmail(this.email);
        pessoa.setTelefone(this.telefone);
        pessoa.setLogradouro(logradouroRepository.findById(this.cepLogradouro).get());
        pessoa.setNumeroEndereco(this.numeroEndereco);
        pessoa.setComplementoEndereco(this.complementoEndereco);
        return pessoa;
    }
}
