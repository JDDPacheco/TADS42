package msf.avaliacao1.dto;

import msf.avaliacao1.model.Voluntario;
import msf.avaliacao1.repository.CidadeRepository;
import msf.avaliacao1.repository.EstadoDeSaudeRepository;

public class VoluntarioInputDTO {
    private String passaporte;
    private String nome;
    private String idade;
    private String telefone;
    private String email;
    private String tipoSanguineo;
    private String estadoDeSaude;
    private String cidadeInteresse;

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getEstadoDeSaude() {
        return estadoDeSaude;
    }

    public void setEstadoDeSaude(String estadoDeSaude) {
        this.estadoDeSaude = estadoDeSaude;
    }

    public String getCidadeInteresse() {
        return cidadeInteresse;
    }

    public void setCidadeInteresse(String cidadeInteresse) {
        this.cidadeInteresse = cidadeInteresse;
    }

    public Voluntario build(CidadeRepository cidadeRepository, EstadoDeSaudeRepository estadoDeSaudeRepository){
        Voluntario voluntario = new Voluntario();
        voluntario.setPassaporte(this.passaporte);
        voluntario.setNome(this.nome);
        voluntario.setIdade(this.idade);
        voluntario.setTelefone(this.telefone);
        voluntario.setEmail(this.email);
        voluntario.setTipoSanguineo(this.tipoSanguineo);
        voluntario.setEstadoDeSaude(estadoDeSaudeRepository.findByNome(this.estadoDeSaude));
        voluntario.setCidadeInteresse(cidadeRepository.findByNome(this.cidadeInteresse));
        return voluntario;
    }
}
