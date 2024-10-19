package teste;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaPessoa {

    private static void persistir(String cpf, String nome, String email, String telefone){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa(nome, telefone, email, cpf);

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
            System.out.println(p.getCpf());
            System.out.println(p.getId());
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

    private static void remover(long id){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager entityManager = fabrica.createEntityManager();

        entityManager.getTransaction().begin();
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
    }

    private static void alterar(long id, String nome){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager entityManager = fabrica.createEntityManager();

        entityManager.getTransaction().begin();
        Pessoa pessoa = entityManager.find(Pessoa.class, id);
        pessoa.setNome(nome);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
    }

    private static void mesclar(long id, String nome){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager entityManager = fabrica.createEntityManager();

        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setEmail("josediogo.dp@gmail.com");
        pessoa.setTelefone("4002-8922");

        entityManager.getTransaction().begin();

        entityManager.merge(pessoa);

        entityManager.getTransaction().commit();

        entityManager.close();
        fabrica.close();
    }

    public static void main(String[] args) {


        persistir("00340091240", "Liliana", "lilica@gmail.com", "(92) 99247-0453");
        //consultar();
        //remover(2L);
        //alterar(3, "Diogo");
        //mesclar(3, "José");
        listar();
    }
}
