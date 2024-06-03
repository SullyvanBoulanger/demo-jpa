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
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("-----FindBookById-----");

        Book book = entityManager.find(Book.class, 1);
        System.out.println(book);

        System.out.println("-----FindLoansFromABook-----");

        Loan loan = entityManager.find(Loan.class, 1);
        loan.getBooks().forEach(System.out::println);

        System.out.println("-----FindLoansByCustomerObject-----");

        Query query = entityManager.createQuery("SELECT loan FROM Loan loan where loan.customer = :customer");
        query.setParameter("customer", entityManager.find(Customer.class, 1));
        List<Loan> loansResultList = query.getResultList();
        loansResultList.forEach(System.out::println);

        System.out.println("-----FindLoansByCustomerId-----");

        Query queryId = entityManager.createQuery("SELECT loan FROM Loan loan where loan.customer.id = :customerId");
        queryId.setParameter("customerId", 1);
        queryId.getResultList().forEach(System.out::println);

        entityManager.close();
    }
}
