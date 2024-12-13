package msf.avaliacao1.controller;

import msf.avaliacao1.dto.VoluntarioInputDTO;
import msf.avaliacao1.dto.VoluntarioOutputDTO;
import msf.avaliacao1.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VoluntarioOutputDTO> create(VoluntarioInputDTO voluntarioInput){
        try{
            
        } catch (Exception e) {
            throw new RuntimeException(e);
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
}
