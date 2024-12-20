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
        Logradouro logradouro_input = logradouro.build(cidadeRepository);
        Logradouro logradouro_created = logradouroRepository.save(logradouro_input);
        return new LogradouroOutputDTO(logradouro_created);
        //return logradouro_output;
        //return new LogradouroOutputDTO(logradouroRepository.save(logradouro.build(cidadeRepository)));
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

    public LogradouroOutputDTO update(LogradouroInputDTO logradouroInputDTO){
        Logradouro logradouro = logradouroInputDTO.build(cidadeRepository);
        if(logradouroRepository.existsById(logradouro.getCep()))
            return new LogradouroOutputDTO(logradouroRepository.save(logradouro));
        else
            return null;
    }

}
