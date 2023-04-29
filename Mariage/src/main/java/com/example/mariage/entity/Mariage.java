package com.example.mariage.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Mariage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long numero;
    private LocalDate date;
    private int nombre;
    private int nombreMinimumTemoins;
    private int capaciteMinimal;
    private int nombreMaxInviteEpoux;
    @ManyToOne
    @JoinColumn(name = "personne_homme_id")
    private Personne personneHomme;
    @ManyToOne
    @JoinColumn(name = "personne_femme_id")
    private Personne personneFemme;

    @ManyToMany()
    @JoinTable(name = "mariage_invites",
            joinColumns = @JoinColumn(name = "mariage_id"),
            inverseJoinColumns = @JoinColumn(name = "invites_id"))
    private List<Invite> invites = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    public Mariage(LocalDate date, int nombre, int nombreMinimumTemoins, int capaciteMinimal, int nombreMaxInviteEpoux) {
        this.date = date;
        this.nombre = nombre;
        this.nombreMinimumTemoins = nombreMinimumTemoins;
        this.capaciteMinimal = capaciteMinimal;
        this.nombreMaxInviteEpoux = nombreMaxInviteEpoux;
    }
}
