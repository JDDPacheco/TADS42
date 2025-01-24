package br.edu.ifam.tads.dra.laboratorio.axios.repository;

import br.edu.ifam.tads.dra.laboratorio.axios.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
