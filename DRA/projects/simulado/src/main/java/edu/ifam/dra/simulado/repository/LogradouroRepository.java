package edu.ifam.dra.simulado.repository;

import edu.ifam.dra.simulado.model.Logradouro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogradouroRepository extends JpaRepository<Logradouro, String> {
}
