package msf.avaliacao1.dto;

import msf.avaliacao1.model.Voluntario;

public class VoluntarioOutputDTO {
    private String passaporte;
    private String nome;
    private String idade;
    private String telefone;
    private String email;
    private String tipoSanguineo;
    private String estadoDeSaude;
    private String cidadeInteresse;
    private String pais;

    public VoluntarioOutputDTO(Voluntario voluntario){
        this.passaporte = voluntario.getPassaporte();
        this.nome = voluntario.getNome();
        this.idade = voluntario.getIdade();
        this.telefone = voluntario.getTelefone();
        this.email = voluntario.getEmail();
        this.tipoSanguineo = voluntario.getTipoSanguineo();
        this.estadoDeSaude = voluntario.getEstadoDeSaude().getEstadoDeSaude();
        this.cidadeInteresse = voluntario.getCidadeInteresse().getNome();
        this.pais = voluntario.getCidadeInteresse().getPais().getNome();
    }

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
