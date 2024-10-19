package teste;

import model.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaCidade {

    private static void persistir(String nome, String ibge, String estado){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager entityManager = fabrica.createEntityManager();

        Cidade cidade = new Cidade(nome, ibge, estado);

        entityManager.getTransaction().begin();
        entityManager.persist(cidade);
        entityManager.getTransaction().commit();
        entityManager.close();
        fabrica.close();
    }

    private static void listar(){
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager entityManager = fabrica.createEntityManager();

        String consulta = "select c from Cidade c"; //JPQL: linguagem de consulta da JPA

        Query query = entityManager.createQuery(consulta);

        List<Cidade> cidades = query.getResultList();

        for(Cidade c: cidades){
            System.out.println(c.getId());
            System.out.println(c.getNome());
            System.out.println(c.getEstado());
            System.out.println(c.getIbge());
            System.out.println("******************");
        }

        entityManager.close();
        fabrica.close();
    }

    public static void main(String[] args) {

        persistir("Manaquiri", "1302553", "AM");
        //consultar();
        //remover(2L);
        //alterar(3, "Diogo");
        //mesclar(3, "José");
        listar();
    }
}
