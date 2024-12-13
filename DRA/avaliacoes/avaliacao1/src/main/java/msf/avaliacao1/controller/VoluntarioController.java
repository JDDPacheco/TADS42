package msf.avaliacao1.controller;

import msf.avaliacao1.dto.VoluntarioInputDTO;
import msf.avaliacao1.dto.VoluntarioOutputDTO;
import msf.avaliacao1.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VoluntarioOutputDTO> create(@RequestBody VoluntarioInputDTO voluntarioInput){
        try{
            VoluntarioOutputDTO voluntarioDTO = voluntarioService.create(voluntarioInput);
            if(voluntarioDTO != null)
                return new ResponseEntity<>(voluntarioDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<VoluntarioOutputDTO>> list (){
        try{
            List<VoluntarioOutputDTO> voluntarios = voluntarioService.list();
            if(voluntarios.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<>(voluntarios, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping(value = "/{passaporte}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VoluntarioOutputDTO> findByPassaporte(@PathVariable String passaporte){
        try{
            VoluntarioOutputDTO voluntarioDTO = voluntarioService.findByPassaporte(passaporte);
            if(voluntarioDTO != null)
                return new ResponseEntity<>(voluntarioDTO, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping(value = "/{passaporte}")
    public ResponseEntity<String> delete(@PathVariable String passaporte){
        try{
            boolean deleted = voluntarioService.delete(passaporte);
            if (deleted)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
