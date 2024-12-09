package edu.ifam.dra.simulado.repository;

import edu.ifam.dra.simulado.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {
}
