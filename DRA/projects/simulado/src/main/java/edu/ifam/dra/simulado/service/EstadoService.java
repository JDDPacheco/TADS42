package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.dto.EstadoOutputDTO;
import edu.ifam.dra.simulado.model.Estado;
import edu.ifam.dra.simulado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoOutputDTO> list (){
        List<Estado> estados = estadoRepository.findAll();
        List<EstadoOutputDTO> estadosDTO = new ArrayList<>();
        for(Estado estado: estados){
            estadosDTO.add(new EstadoOutputDTO(estado));
        }
        return estadosDTO;
    }

    public EstadoOutputDTO create(Estado estado){
        return new EstadoOutputDTO(estadoRepository.save(estado));
    }

    public EstadoOutputDTO getByIBGE(String ibge){
        return new EstadoOutputDTO(estadoRepository.findById(ibge).get());
    }

    public boolean delete(String ibge){
        if(estadoRepository.existsById(ibge)){
            estadoRepository.deleteById(ibge);
            return !estadoRepository.existsById(ibge);
        }else{
            return false;
        }
    }

    public EstadoOutputDTO update(Estado estado){
        return new EstadoOutputDTO(estadoRepository.save(estado));
    }
}
