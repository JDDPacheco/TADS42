package br.edu.ifam.tads.dra.laboratorio.axios.repository;

import br.edu.ifam.tads.dra.laboratorio.axios.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
