package msf.avaliacao1.model;

import jakarta.persistence.*;

@Entity
public class Voluntario {

    @Id
    @Column(nullable = false, unique = true)
    private String passaporte;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String idade;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String tipoSanguineo;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidadeInteresse;

    @ManyToOne
    @JoinColumn(name = "estado_de_saude_id", nullable = false)
    private EstadoDeSaude estadoDeSaude;

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

    public Cidade getCidadeInteresse() {
        return cidadeInteresse;
    }

    public void setCidadeInteresse(Cidade cidadeInteresse) {
        this.cidadeInteresse = cidadeInteresse;
    }

    public EstadoDeSaude getEstadoDeSaude() {
        return estadoDeSaude;
    }

    public void setEstadoDeSaude(EstadoDeSaude estadoDeSaude) {
        this.estadoDeSaude = estadoDeSaude;
    }
}
