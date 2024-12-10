package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> list(){
        return cidadeRepository.findAll();
    }

    public Cidade create(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    public Cidade getByIBGE(String ibge){
        return cidadeRepository.findById(ibge).get();
    }

    public boolean delete(String ibge){
        if(cidadeRepository.existsById(ibge)){
            cidadeRepository.deleteById(ibge);
            return !cidadeRepository.existsById(ibge);
        }else{
            return false;
        }
    }
}
