package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.dto.LogradouroInputDTO;
import edu.ifam.dra.simulado.dto.LogradouroOutputDTO;
import edu.ifam.dra.simulado.model.Logradouro;
import edu.ifam.dra.simulado.repository.CidadeRepository;
import edu.ifam.dra.simulado.repository.LogradouroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogradouroService {

    @Autowired
    private LogradouroRepository logradouroRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<LogradouroOutputDTO> list(){
        List<Logradouro> logradouros = logradouroRepository.findAll();
        List<LogradouroOutputDTO> logradourosDTO = new ArrayList<>();
        for(Logradouro logradouro: logradouros){
            logradourosDTO.add(new LogradouroOutputDTO(logradouro));
        }
        return logradourosDTO;
    }

    public LogradouroOutputDTO create(LogradouroInputDTO logradouro){
        return new LogradouroOutputDTO(logradouroRepository.save(logradouro.build(cidadeRepository)));
    }

    public LogradouroOutputDTO findByCEP(String cep){
        return new LogradouroOutputDTO(logradouroRepository.findById(cep).get());
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
