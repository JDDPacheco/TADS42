package msf.avaliacao1.repository;

import msf.avaliacao1.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, String> {
}
