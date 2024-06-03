package fr.diginamic.demojpa.bibliotheque.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "EMPRUNT")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "DELAI")
    private int delay;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Customer customer;

    @ManyToMany
    @JoinTable(
        name = "COMPO",
        joinColumns = @JoinColumn(name = "ID_EMPRUNT", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_LIVRE", referencedColumnName = "ID")
    )
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Loan[id = ").append(id).append("]");
        
        return stringBuilder.toString();
    }
}
