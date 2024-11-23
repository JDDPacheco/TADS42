package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.dra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> list(){

        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<PessoaOutputDTO> pessoasDTO= new ArrayList<>();

        for (Pessoa pessoa:pessoas){
            pessoasDTO.add(new PessoaOutputDTO(pessoa));
        }

        if(!pessoas.isEmpty()){
            return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> create(@RequestBody PessoaInputDTO pessoaInputDTO){
        try{
            Pessoa pessoa = pessoaInputDTO.build(cidadeRepository);
            if(pessoa.getEmail() == "" || pessoa.getEmail() == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else if(pessoa.getNome() == "" || pessoa.getNome() == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else if(!cidadeRepository.existsById(pessoa.getCidade().getId())){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Pessoa pessoa_created = pessoaRepository.save(pessoa);

            /** Início Testes: */
            /** Forçar erro de não criar a pessoa*/
                //pessoaRepository.deleteById(pessoa_created.getId());
            /** Fim Teste*/

            if(pessoaRepository.existsById(pessoa_created.getId())) {
                return new ResponseEntity<>(new PessoaOutputDTO(pessoa_created), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> getById(@PathVariable Long id){
        if(pessoaRepository.existsById(id)){
            Pessoa pessoa = pessoaRepository.findById(id).get();
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        try {
            // Verifica se o registro existe antes de tentar excluir
            if (pessoaRepository.existsById(id)) {
                pessoaRepository.deleteById(id);
                // Verifica se a exclusão foi bem-sucedida
                if (!pessoaRepository.existsById(id)) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT); // deletou com sucesso
                } else {
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // não foi deletado
                }
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // not found
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
