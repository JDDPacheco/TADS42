package edu.ifam.dra.simulado.service;

import edu.ifam.dra.simulado.dto.CidadeInputDTO;
import edu.ifam.dra.simulado.dto.CidadeOutputDTO;
import edu.ifam.dra.simulado.model.Cidade;
import edu.ifam.dra.simulado.repository.CidadeRepository;
import edu.ifam.dra.simulado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<CidadeOutputDTO> list(){
        List<Cidade> cidades = cidadeRepository.findAll();
        List<CidadeOutputDTO> cidadesDTO = new ArrayList<>();
        for(Cidade cidade: cidades){
            cidadesDTO.add(new CidadeOutputDTO(cidade));
        }
        return cidadesDTO;
    }

    public CidadeOutputDTO create(CidadeInputDTO cidadeInputDTO){
        return new CidadeOutputDTO(cidadeRepository.save(cidadeInputDTO.build(estadoRepository)));
    }

    public CidadeOutputDTO getByIBGE(String ibge){
        return new CidadeOutputDTO(cidadeRepository.findById(ibge).get());
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
