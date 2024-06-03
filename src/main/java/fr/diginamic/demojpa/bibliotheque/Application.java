package fr.diginamic.demojpa.bibliotheque;

import java.util.List;

import fr.diginamic.demojpa.bibliotheque.entities.Book;
import fr.diginamic.demojpa.bibliotheque.entities.Customer;
import fr.diginamic.demojpa.bibliotheque.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book = entityManager.find(Book.class, 1);
        System.out.println(book);

        Loan loan = entityManager.find(Loan.class, 1);
        loan.getBooks().forEach(System.out::println);

        Query query = entityManager.createQuery("SELECT loan FROM Loan loan where loan.customer = :customer");
        query.setParameter("customer", entityManager.find(Customer.class, 1));
        List<Loan> loansResultList = query.getResultList();

        loansResultList.forEach(System.out::println);

        entityManager.close();
    }
}
