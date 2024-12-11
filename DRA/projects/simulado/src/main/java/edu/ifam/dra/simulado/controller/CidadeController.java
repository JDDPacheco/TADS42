package edu.ifam.dra.simulado.controller;

import edu.ifam.dra.simulado.dto.CidadeInputDTO;
import edu.ifam.dra.simulado.dto.CidadeOutputDTO;
import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.repository.EstadoRepository;
import edu.ifam.dra.simulado.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity<List<CidadeOutputDTO>> list(){
        try{
            List<CidadeOutputDTO> cidadesDTO = cidadeService.list();
            if(cidadesDTO != null)
                return new ResponseEntity<>(cidadesDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeOutputDTO> create(@RequestBody CidadeInputDTO cidade){
        try{
            CidadeOutputDTO cidadeDTO = cidadeService.create(cidade);
            if(cidadeDTO != null)
                return new ResponseEntity<>(cidadeDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(value = "/{ibge}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CidadeOutputDTO> getByIBGE(@PathVariable String ibge){
        try{
            CidadeOutputDTO cidadeDTO = cidadeService.getByIBGE(ibge);
            if(cidadeDTO != null)
                return new ResponseEntity<>(cidadeDTO, HttpStatus.OK);
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
