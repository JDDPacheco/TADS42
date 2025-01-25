package edu.ifam.dra.simulado.repository;

import edu.ifam.dra.simulado.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    //@Query("select p from Pessoa p where p.cpf = :parCPF")
    //Pessoa findByCPF(@Param("parCPF") String cpf);

    //@Query("select p from Pessoa p where p.nome = :parNome")
    //Pessoa findByNome(@Param("parNome") String nome);

    @Query("select p from Pessoa p where lower(p.nome) like lower(concat('%', :parNome, '%'))")
    List<Pessoa> findByNome(@Param("parNome") String nome);
}

