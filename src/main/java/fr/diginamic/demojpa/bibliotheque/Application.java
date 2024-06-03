package fr.diginamic.demojpa.bibliotheque;

import fr.diginamic.demojpa.bibliotheque.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book = entityManager.find(Book.class, 1);
        System.out.println(book);

        entityManager.close();
    }
}
