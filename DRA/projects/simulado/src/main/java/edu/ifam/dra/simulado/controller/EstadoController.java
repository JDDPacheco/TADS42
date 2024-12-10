package edu.ifam.dra.simulado.controller;

import edu.ifam.dra.simulado.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    PessoaService pessoaService;


}
