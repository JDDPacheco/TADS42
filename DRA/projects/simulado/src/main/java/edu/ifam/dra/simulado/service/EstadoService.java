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
        List<Estado> estados = estadoRepository.findAll();
        return estados;
    }

    public Estado create(Estado estado){
        Estado estadoCreated = estadoRepository.save(estado);
        return estadoCreated;
    }

    public Estado getByIBGE(String ibge){
        Estado estadoFound = estadoRepository.findById(ibge).get();
        return estadoFound;
    }

    public boolean delete(String ibge){
        if(estadoRepository.existsById(ibge)){
            estadoRepository.deleteById(ibge);
            if(!estadoRepository.existsById(ibge)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
