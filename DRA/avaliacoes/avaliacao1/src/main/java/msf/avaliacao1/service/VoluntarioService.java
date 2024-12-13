package msf.avaliacao1.service;

import msf.avaliacao1.dto.VoluntarioInputDTO;
import msf.avaliacao1.dto.VoluntarioOutputDTO;
import msf.avaliacao1.model.Voluntario;
import msf.avaliacao1.repository.CidadeRepository;
import msf.avaliacao1.repository.EstadoDeSaudeRepository;
import msf.avaliacao1.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoDeSaudeRepository estadoDeSaudeRepository;

    public VoluntarioOutputDTO create(VoluntarioInputDTO voluntarioInputDTO){
        Voluntario voluntario_recebido = new Voluntario();
        Voluntario voluntario_salvo = new Voluntario();
        if(voluntarioRepository.existsById(voluntarioInputDTO.getPassaporte()))
            return null; //situação onde já existe o voluntário no banco da dados
        if(voluntarioInputDTO.getPassaporte() == null)
            return null; //situação onde o campo passaporte é vazio
        else if(voluntarioInputDTO.getNome() == null)
            return null; //situação onde o campo nome é vazio
        else if(voluntarioInputDTO.getIdade() == null)
            return null; //situação onde o campo idade é vazio
        else if(voluntarioInputDTO.getTelefone() == null)
            return null; //situação onde o campo telefone é vazio
        else if(voluntarioInputDTO.getEmail() == null)
            return null; //situação onde o campo email é vazio
        else if(cidadeRepository.findByNome(voluntarioInputDTO.getCidadeInteresse()) == null)
            return null; //situação onde a cidade não existe no banco de dados ou o campo cidade é vazia
        else if(estadoDeSaudeRepository.findByNome(voluntarioInputDTO.getEstadoDeSaude()) == null)
            return null; //situação onde o estado de saúde não existe no banco de dados ou o campo esatdo de saúde é vazia
        else{
            voluntario_recebido = voluntarioInputDTO.build(cidadeRepository, estadoDeSaudeRepository);
            voluntario_salvo = voluntarioRepository.save(voluntario_recebido);
            return new VoluntarioOutputDTO(voluntario_salvo);
        }
    }

    public List<VoluntarioOutputDTO> list(){
        List<Voluntario> voluntarios = voluntarioRepository.findAll();
        List<VoluntarioOutputDTO> voluntariosDTO = new ArrayList<>();
        if(voluntarios.isEmpty())
            return null;
        else{
            for(Voluntario voluntario: voluntarios){
                voluntariosDTO.add(new VoluntarioOutputDTO(voluntario));
            }
            return voluntariosDTO;
        }
    }

    public VoluntarioOutputDTO findByPassaporte(String passaporte){
        Voluntario voluntario_encontrado = voluntarioRepository.findById(passaporte).get();
        if(voluntarioRepository.existsById(passaporte))
            return new VoluntarioOutputDTO(voluntario_encontrado);
        else
            return null;
    }

    public boolean delete(String passaporte){
        Voluntario voluntario_encontrado = voluntarioRepository.findById(passaporte).get();
        if(voluntarioRepository.existsById(passaporte)){
            voluntarioRepository.delete(voluntario_encontrado);
            if(voluntarioRepository.existsById(passaporte))
                return false; // o voluntário não foi excluido
            else
                return true; // voluntario excluido
        }
        else
            return false; // o voluntario não existe
    }

}
