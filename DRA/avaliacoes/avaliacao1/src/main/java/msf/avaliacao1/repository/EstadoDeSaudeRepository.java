package msf.avaliacao1.repository;

import msf.avaliacao1.model.EstadoDeSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstadoDeSaudeRepository extends JpaRepository<EstadoDeSaude, Long> {
    @Query("select e from EstadoDeSaude e where e.estadoDeSaude = :parEstadoDeSaude")
    EstadoDeSaude findByNome(@Param("parEstadoDeSaude") String estadoDeSaude);
}
