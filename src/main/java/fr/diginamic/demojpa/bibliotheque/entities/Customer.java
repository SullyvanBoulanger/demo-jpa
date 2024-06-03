package fr.diginamic.demojpa.bibliotheque.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String lastName;

    @Column(name = "PRENOM")
    private String firstName;

    @OneToMany(mappedBy = "customer")
    private List<Loan> loans = new ArrayList<>();
}
