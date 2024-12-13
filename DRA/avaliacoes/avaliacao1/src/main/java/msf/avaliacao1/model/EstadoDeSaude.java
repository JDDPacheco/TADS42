package msf.avaliacao1.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EstadoDeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String estadoDeSaude;

    @OneToMany(mappedBy = "estadoDeSaude", fetch = FetchType.LAZY)
    private List<Voluntario> voluntarios = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstadoDeSaude() {
        return estadoDeSaude;
    }

    public void setEstadoDeSaude(String estadoDeSaude) {
        this.estadoDeSaude = estadoDeSaude;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public void setVoluntarios(List<Voluntario> voluntarios) {
        this.voluntarios = voluntarios;
    }
}
