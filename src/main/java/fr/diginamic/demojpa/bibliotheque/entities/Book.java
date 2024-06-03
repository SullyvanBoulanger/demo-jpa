package fr.diginamic.demojpa.bibliotheque.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "TITRE")
    private String title;

    @Column(name = "AUTEUR")
    private String author;

    @ManyToMany
    @JoinTable(
        name = "COMPO",
        joinColumns = @JoinColumn(name = "ID_LIVRE", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_EMPRUNT", referencedColumnName = "ID")
    )
    private List<Loan> loans = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Book[id = ").append(id)
            .append(", title = \"").append(title)
            .append("\", author = \"").append(author).append("\"]");
        
        return stringBuilder.toString();
    }
}
