package fr.diginamic.demojpa;

import fr.diginamic.demojpa.entities.Region;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("region");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        Region region = entityManager.find(Region.class, 1);
        System.out.println(region);

        Region newRegion = new Region();
        newRegion.setName("Normandie");
        entityManager.persist(newRegion);

        entityTransaction.commit();

        entityManager.close();
    }
}
