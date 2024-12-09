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
        List<Cidade> cidades = cidadeRepository.findAll();
        return cidades;
    }

    public Cidade create(Cidade cidade){
        Cidade cidadeCreated = cidadeRepository.save(cidade);
        return cidadeCreated;
    }

    public Cidade getByIBGE(String ibge){
        Cidade cidadeFound = cidadeRepository.findById(ibge).get();
        return cidadeFound;
    }

    public boolean delete(String ibge){
        if(cidadeRepository.existsById(ibge)){
            cidadeRepository.deleteById(ibge);
            if(!cidadeRepository.existsById(ibge)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
