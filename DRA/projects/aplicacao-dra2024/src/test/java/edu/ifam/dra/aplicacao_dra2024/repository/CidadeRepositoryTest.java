package edu.ifam.dra.aplicacao_dra2024.repository;

import edu.ifam.dra.aplicacao_dra2024.model.Cidade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class CidadeRepositoryTest {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Test
    public void deveSalvarCidadeValida(){

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setEstado("AM");

        Cidade cidadeSalva = cidadeRepository.save(cidade);

        assertThat(cidadeSalva.getId()).isNotNull();
        assertThat(cidadeSalva.getNome()).isEqualTo("Manaus");
        assertThat(cidadeSalva.getEstado()).isEqualTo("AM");
    }

    @Test
    public void naoDeveSalvarCidadeComNomeNulo(){

        Cidade cidade = new Cidade();
        cidade.setNome(null);
        cidade.setEstado("AM");

        assertThrows(DataIntegrityViolationException.class, () -> {
            cidadeRepository.save(cidade);
        });
    }

    @Test
    public void naoInserirComEstadoEmBranco(){

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setEstado(null);

        assertThrows(DataIntegrityViolationException.class, () -> {
            cidadeRepository.save(cidade);
        });
    }

    @Test
    public void naoDeveSalvarCidadeRepetida(){

        // Condição Inicial

        Cidade cidadeJaSalva = new Cidade();
        cidadeJaSalva.setNome("São Paulo");
        cidadeJaSalva.setEstado("SP");
        cidadeRepository.save(cidadeJaSalva);

        // Roteiro de Teste

        Cidade novaCidade = new Cidade();
        novaCidade.setNome("Manaus");
        novaCidade.setEstado("AM");

        assertThrows(DataIntegrityViolationException.class, () -> {
            cidadeRepository.save(novaCidade);
        });
    }

}
