package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.model.Estado;
import edu.ifam.dra.simulado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> list (){
        return estadoRepository.findAll();
    }

    public Estado create(Estado estado){
        return estadoRepository.save(estado);
    }

    public Estado getByIBGE(String ibge){
        return estadoRepository.findById(ibge).get();
    }

    public boolean delete(String ibge){
        if(estadoRepository.existsById(ibge)){
            estadoRepository.deleteById(ibge);
            return !estadoRepository.existsById(ibge);
        }else{
            return false;
        }
    }
}
