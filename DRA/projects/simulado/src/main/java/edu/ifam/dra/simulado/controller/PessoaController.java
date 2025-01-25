package edu.ifam.dra.simulado.controller;

import edu.ifam.dra.simulado.dto.PessoaInputDTO;
import edu.ifam.dra.simulado.dto.PessoaOutputDTO;
import edu.ifam.dra.simulado.model.Pessoa;
import edu.ifam.dra.simulado.repository.PessoaRepository;
import edu.ifam.dra.simulado.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> list(){
        try{
            List<PessoaOutputDTO> pessoasDTO = pessoaService.list();
            if(pessoasDTO != null)
                return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> create(@RequestBody PessoaInputDTO pessoa){
        try{
            PessoaOutputDTO pessoaDTO = pessoaService.create(pessoa);
            if(pessoaDTO != null)
                return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(value = "/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PessoaOutputDTO>> getByNome(@PathVariable String nome){
        try{
            List<PessoaOutputDTO> pessoasDTO = pessoaService.findByNome(nome);
            if(pessoasDTO != null)
                return new ResponseEntity<>(pessoasDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping(value = "/{ibge}")
    public ResponseEntity<String> delete(@PathVariable String ibge){
        try{
            boolean deleted = cidadeService.delete(ibge);
            if (deleted)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
