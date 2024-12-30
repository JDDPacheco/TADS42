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
        try {
            List<Pessoa> pessoas = pessoaRepository.findAll();
            List<PessoaOutputDTO> pessoasDTO = new ArrayList<>();

            for (Pessoa pessoa : pessoas) {
                pessoasDTO.add(new PessoaOutputDTO(pessoa));
            }

            return pessoasDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PessoaOutputDTO create(PessoaInputDTO pessoaInputDTO){
        try{
            Pessoa pessoa = pessoaInputDTO.build(cidadeRepository);
            Pessoa pessoaCriada = pessoaRepository.save(pessoa);
            return new PessoaOutputDTO(pessoaCriada);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PessoaOutputDTO getById(Long id){
        try{
            return new PessoaOutputDTO(pessoaRepository.findById(id).get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
