package edu.ifam.dra.simulado.repository;

import edu.ifam.dra.simulado.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, String> {
}
