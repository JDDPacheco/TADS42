package teste;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaPessoa {

    private static void persistir(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa("Liliana", "4002-8922", "liliana.dp@gmail.com");


        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
    }

    private static void listar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager entityManager = fabrica.createEntityManager();

        String consulta = "select p from Pessoa p"; //JPQL: linguagem de consulta da JPA

        Query query = entityManager.createQuery(consulta);

        List<Pessoa> pessoas = query.getResultList();

        for(Pessoa p: pessoas){
            System.out.println(p.getNome());
            System.out.println(p.getEmail());
            System.out.println(p.getTelefone());
            System.out.println("******************");
        }

        entityManager.close();
        fabrica.close();
    }

    private static void consultar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = entityManager.find(Pessoa.class,1L);

        System.out.println("Pessoa:" + pessoa.getNome());

        entityManager.close();
        fabrica.close();
    }

    public static void main(String[] args) {

        persistir();
        //listar();
        //consultar();

    }
}
