package edu.ifam.dra.simulado.repository;

import edu.ifam.dra.simulado.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, String> {
}
