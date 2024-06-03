package fr.diginamic.demojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.close();
    }
}
