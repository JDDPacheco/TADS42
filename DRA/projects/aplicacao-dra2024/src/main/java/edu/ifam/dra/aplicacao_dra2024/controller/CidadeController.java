package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.model.Cidade;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<List<Cidade>> list(){
        try{
            List<Cidade> cidades = cidadeRepository.findAll();
            if(!cidades.isEmpty()){
                return new ResponseEntity<>(cidades, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cidade> create(@RequestBody Cidade cidade){
        try{
            Cidade cidade_created = cidadeRepository.save(cidade);
            return new ResponseEntity<>(cidade_created, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
