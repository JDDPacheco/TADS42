package edu.ifam.dra.axiosAPI.dto;

import edu.ifam.dra.axiosAPI.model.Pessoa;
import edu.ifam.dra.axiosAPI.repository.InteresseRepository;

public class PessoaInputDTO{

    private String nome;
    private String matricula;
    private String interesse;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    public Pessoa build(InteresseRepository interesseRepository){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setMatricula(this.matricula);
        pessoa.setInteresse(interesseRepository.findByNome(this.interesse));
        return pessoa;
    }
}
