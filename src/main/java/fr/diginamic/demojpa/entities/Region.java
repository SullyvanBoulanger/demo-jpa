package fr.diginamic.demojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REGION")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NOM")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Region[id = ").append(id).append(", name = \"").append(name).append("\"]");
        return stringBuilder.toString();
    }
}
