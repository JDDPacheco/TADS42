package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.dra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import edu.ifam.dra.aplicacao_dra2024.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaOutputDTO>> list(){

        List<PessoaOutputDTO> pessoasDTO = pessoaService.list();

        if(!pessoasDTO.isEmpty()){
            return new ResponseEntity<>(pessoasDTO,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<PessoaOutputDTO>> create(@RequestBody PessoaInputDTO pessoaInputDTO, UriComponentsBuilder uriBuilder)
    {

        http://localhost:8080/api/pessoas

        try {
            Pessoa pessoa = pessoaInputDTO.build(cidadeRepository);
            Pessoa pessoaCriada = pessoaRepository.save(pessoa);
            PessoaOutputDTO pessoaOutputDTO = new PessoaOutputDTO(pessoaCriada);

            UriComponents uriComponents = uriBuilder.path("api/pessoas/{id}").buildAndExpand(pessoaOutputDTO.getId());
            URI uri = uriComponents.toUri();

            Link selfLink = WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(PessoaController.class).getById(pessoaOutputDTO.getId())
            ).withSelfRel();

            Link deleteLink = WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(PessoaController.class).deleteById(pessoaOutputDTO.getId())
            ).withRel("delete-pessoas");

            EntityModel<PessoaOutputDTO>resource = EntityModel.of(pessoaOutputDTO,selfLink,deleteLink);

            return ResponseEntity.created(uri).contentType(MediaType.APPLICATION_JSON).body(resource);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }

    }


    //    http://localhost:8080/api/pessoa/1
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa getById(@PathVariable Long id){
        return pessoaRepository.findById(id).get();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
