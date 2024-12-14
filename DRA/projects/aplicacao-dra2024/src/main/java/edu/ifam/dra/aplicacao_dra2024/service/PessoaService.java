package edu.ifam.dra.aplicacao_dra2024.service;

import edu.ifam.dra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaOutputDTO> list(){

        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaOutputDTO> pessoasDTO = new ArrayList<>();

        for(Pessoa pessoa:pessoas){
            pessoasDTO.add(new PessoaOutputDTO(pessoa));
        }

        return pessoasDTO;
    }

}
