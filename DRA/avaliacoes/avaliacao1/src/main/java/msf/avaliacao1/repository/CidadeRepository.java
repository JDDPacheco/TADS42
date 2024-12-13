package msf.avaliacao1.repository;

import msf.avaliacao1.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    @Query("select c from Cidade c where c.nome = :parNome")
    Cidade findByNome(@Param("parNome") String nome);
}
