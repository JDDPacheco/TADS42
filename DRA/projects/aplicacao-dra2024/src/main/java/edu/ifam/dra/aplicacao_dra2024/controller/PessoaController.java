package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> list(){
        return pessoaRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa getById(@PathVariable Long id){
        return pessoaRepository.findById(id).get();
    };

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        // Verifica se o registro existe antes de tentar excluir
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            // Verifica se a exclusão foi bem-sucedida
            if (!pessoaRepository.existsById(id)) {
                return "Deletado com sucesso!";
            } else {
                return "Erro ao deletar. O item não foi excluído.";
            }
        } else {
            return "Item não encontrado.";
        }
    }

}
