package edu.ifam.dra.simulado.controller;

import edu.ifam.dra.simulado.dto.LogradouroOutputDTO;
import edu.ifam.dra.simulado.service.LogradouroService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LogradouroController {
    private LogradouroService logradouroService;

    public ResponseEntity<List<LogradouroOutputDTO>> list(){
        try {
            List<LogradouroOutputDTO> logradouros = logradouroService.list();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
