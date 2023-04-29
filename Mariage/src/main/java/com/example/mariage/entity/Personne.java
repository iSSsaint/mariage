package com.example.mariage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "personneHomme", orphanRemoval = true)
    @JsonIgnore
    private List<Mariage> mariagesHomme = new ArrayList<>();
    @OneToMany(mappedBy = "personneFemme", orphanRemoval = true)
    @JsonIgnore
    private List<Mariage> mariagesFemme = new ArrayList<>();

    public Personne(String cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
