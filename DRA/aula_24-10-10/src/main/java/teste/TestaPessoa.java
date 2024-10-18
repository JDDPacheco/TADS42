package teste;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaPessoa {

    public static void main(String[] args) {

        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa("Diogo", "4002-8922", "josediogo.dp@gmail.com");


        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
    }
}
