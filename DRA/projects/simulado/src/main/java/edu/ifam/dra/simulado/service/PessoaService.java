package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.dto.LogradouroInputDTO;
import edu.ifam.dra.simulado.dto.LogradouroOutputDTO;
import edu.ifam.dra.simulado.dto.PessoaInputDTO;
import edu.ifam.dra.simulado.dto.PessoaOutputDTO;
import edu.ifam.dra.simulado.model.Logradouro;
import edu.ifam.dra.simulado.model.Pessoa;
import edu.ifam.dra.simulado.repository.LogradouroRepository;
import edu.ifam.dra.simulado.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LogradouroRepository logradouroRepository;

    public List<PessoaOutputDTO> list(){
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaOutputDTO> pessoaDTO = new ArrayList<>();
        for(Pessoa pessoa:pessoas){
            pessoaDTO.add(new PessoaOutputDTO(pessoa));
        }
        return pessoaDTO;
    }

    public PessoaOutputDTO create(PessoaInputDTO pessoaInputDTO){
        return new PessoaOutputDTO(pessoaRepository.save(pessoaInputDTO.build(logradouroRepository)));
    }

    public List<PessoaOutputDTO> findByNome(String nome){
        List<Pessoa> pessoas = pessoaRepository.findByNome(nome);
        List<PessoaOutputDTO> pessoasDTO = new ArrayList<>();
        for(Pessoa pessoa: pessoas){
            pessoasDTO.add(new PessoaOutputDTO(pessoa));
        }
        return pessoasDTO;
    }

    public boolean delete(Long id){
        if(pessoaRepository.existsById(id)){
            pessoaRepository.deleteById(id);
            return !pessoaRepository.existsById(id);
        }else{
            return false;
        }
    }

    public PessoaOutputDTO update(PessoaInputDTO pessoaInputDTO){
        Pessoa pessoa = pessoaInputDTO.build(logradouroRepository);
        if(pessoaRepository.existsById(pessoa.getId()))
            return new PessoaOutputDTO(pessoaRepository.save(pessoa));
        else
            return null;
    }
}
