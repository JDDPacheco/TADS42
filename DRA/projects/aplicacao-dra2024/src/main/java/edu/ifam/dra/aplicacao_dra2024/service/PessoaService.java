package edu.ifam.dra.aplicacao_dra2024.service;

import edu.ifam.dra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.dra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
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

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<PessoaOutputDTO> list(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaOutputDTO> pessoaDTO = new ArrayList<>();
        for(Pessoa pessoa:pessoas){
            pessoaDTO.add(new PessoaOutputDTO(pessoa));
        }
        return pessoaDTO;
    }

    public PessoaOutputDTO create(PessoaInputDTO pessoaInputDTO){
        Pessoa pessoa = pessoaInputDTO.build(cidadeRepository);
        if(pessoa.getEmail() == "" || pessoa.getEmail() == null){
            return null;
        } else if(pessoa.getNome() == "" || pessoa.getNome() == null){
            return null;
        } else if(!cidadeRepository.existsById(pessoa.getCidade().getId())){
            return null;
        }
        Pessoa pessoa_created = pessoaRepository.save(pessoa);
    }

}
