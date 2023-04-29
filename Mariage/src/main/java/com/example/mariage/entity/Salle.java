package com.example.mariage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String adresse;
    private String ville;
    private int capacite;

    @OneToMany(mappedBy = "salle", orphanRemoval = true)
    private List<Mariage> mariages = new ArrayList<>();

    public Salle(String nom, String adresse, String ville, int capacite) {
        this.nom = nom;
        this.adresse = adresse;
        this.ville = ville;
        this.capacite = capacite;
    }
}
