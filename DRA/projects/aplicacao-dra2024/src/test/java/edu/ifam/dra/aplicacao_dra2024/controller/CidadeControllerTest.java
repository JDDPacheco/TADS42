package edu.ifam.dra.aplicacao_dra2024.controller;

import edu.ifam.dra.aplicacao_dra2024.repository.CidadeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CidadeControllerTest {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void devePesquisarCidadePorId(){
        
    }

}
