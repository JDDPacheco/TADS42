package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.dto.PessoaInputDTO;
import edu.ifam.dra.simulado.dto.PessoaOutputDTO;
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

    public PessoaOutputDTO findByCPF(String cpf){
        return new PessoaOutputDTO(pessoaRepository.findById(cpf).get());
    }

    public boolean delete(String cpf){
        if(pessoaRepository.existsById(cpf)){
            pessoaRepository.deleteById(cpf);
            return !pessoaRepository.existsById(cpf);
        }else{
            return false;
        }
    }
}
