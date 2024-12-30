package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.dto.PessoaInputDTO;
import edu.ifam.dra.aplicacao_dra2024.dto.PessoaOutputDTO;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import edu.ifam.dra.aplicacao_dra2024.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Pessoas", description = "APIs para gerenciamento de pessoas")
public class PessoaController {


    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    @Operation(summary = "Listar todas as pessoas", description = "Retorna uma lista de todas as pessoas registradas.")
    public ResponseEntity<List<PessoaOutputDTO>> list(){

        List<PessoaOutputDTO> pessoasDTO = pessoaService.list();

        if(!pessoasDTO.isEmpty()){
            return new ResponseEntity<>(pessoasDTO,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar uma nova pessoa", description = "Adiciona a nova pessoa ao banco de dados e retorna a pessoa adicionada.")
    public ResponseEntity<EntityModel<PessoaOutputDTO>> create(@RequestBody PessoaInputDTO pessoaInputDTO, UriComponentsBuilder uriBuilder)
    {

        http://localhost:8080/api/pessoas

        try {
            PessoaOutputDTO pessoaOutputDTO = pessoaService.create(pessoaInputDTO);

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
    @Operation(summary = "Buscar pessoa por ID", description = "Retorna os detalhes de uma pessoa específica.")
    public ResponseEntity<PessoaOutputDTO> getById(@PathVariable Long id){
        try {
            PessoaOutputDTO pessoaLocalizada = pessoaService.getById(id);
            return new ResponseEntity<>(pessoaLocalizada, HttpStatus.FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleta pessoa por ID", description = "Tenta excluí a pessoa e retorna o status da operação.")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        try {
            Optional<Pessoa> pessoa = pessoaRepository.findById(id);
            if (pessoa.isPresent()) {
                pessoaRepository.delete(pessoa.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

}
