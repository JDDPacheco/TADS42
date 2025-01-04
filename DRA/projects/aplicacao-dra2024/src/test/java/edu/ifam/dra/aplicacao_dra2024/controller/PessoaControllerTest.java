package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.model.Cidade;
import edu.ifam.dra.aplicacao_dra2024.model.Pessoa;
import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import edu.ifam.dra.aplicacao_dra2024.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PessoaControllerTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void devePesquisarPessoaPorId(){

        // Condição Inicial
        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setEstado("AM");

        Cidade cidadeSalva = cidadeRepository.save(cidade);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Diogo");
        pessoa.setCidade(cidadeSalva);
        pessoa.setEmail("josediogo.dp@gmail.com");
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        // Executar a ação
        ResponseEntity<Pessoa> response = testRestTemplate.getForEntity("/api/pessoas/"+pessoaSalva.getId(),Pessoa.class);

        //Validações

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        Pessoa pessoaRetornada = response.getBody();
        assertEquals(pessoaSalva.getId(), pessoaRetornada.getId());
        assertEquals(pessoaSalva.getNome(), pessoaRetornada.getNome());
        assertEquals(pessoaSalva.getEmail(), pessoaRetornada.getEmail());


    }

}
