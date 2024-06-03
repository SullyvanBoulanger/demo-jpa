package fr.diginamic.demojpa.recensement;

import fr.diginamic.demojpa.recensement.entities.Region;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * If you want to run this class, please change the url in persistence.xml to access recensement database
 */
public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recensement");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Region region = entityManager.find(Region.class, 1);
        System.out.println(region);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Region newRegion = new Region();
        newRegion.setName("Normandie");
        entityManager.persist(newRegion);

        entityTransaction.commit();

        entityManager.close();
    }
}
