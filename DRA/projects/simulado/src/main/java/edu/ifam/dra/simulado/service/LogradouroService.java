package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.model.Logradouro;
import edu.ifam.dra.simulado.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogradouroService {

    @Autowired
    private LogradouroRepository logradouroRepository;

    public List<Logradouro> list(){
        return logradouroRepository.findAll();
    }

    public Logradouro create(Logradouro logradouro){
        return logradouroRepository.save(logradouro);
    }

    public Logradouro findByCEP(String cep){
        return logradouroRepository.findById(cep).get();
    }

    public boolean delete(String cep){
        if(logradouroRepository.existsById(cep)) {
            logradouroRepository.deleteById(cep);
            return (!logradouroRepository.existsById(cep));
        }else{
            return false;
        }
    }

}
