package edu.ifam.dra.simulado.controller;

import edu.ifam.dra.simulado.dto.EstadoOutputDTO;
import edu.ifam.dra.simulado.model.Estado;
import edu.ifam.dra.simulado.repository.LogradouroRepository;
import edu.ifam.dra.simulado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private LogradouroRepository logradouroRepository;

    @GetMapping
    public ResponseEntity<List<EstadoOutputDTO>> list(){
        try{
            List<EstadoOutputDTO> estadosDTO = estadoService.list();
            if(!estadosDTO.isEmpty())
                return new ResponseEntity<>(estadosDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoOutputDTO> create(@RequestBody Estado estado){
        try{
            EstadoOutputDTO estadoDTO = estadoService.create(estado);
            if(estadoDTO != null)
                return new ResponseEntity<>(estadoDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(value = "/{ibge}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstadoOutputDTO> getByIBGE(@PathVariable String ibge){
        try{
            EstadoOutputDTO estadoDTO = estadoService.getByIBGE(ibge);
            if(estadoDTO != null)
                return new ResponseEntity<>(estadoDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
