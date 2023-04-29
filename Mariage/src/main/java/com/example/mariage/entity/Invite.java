package com.example.mariage.entity;

import com.example.mariage.StatutInvite;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Invite extends Personne {
    @Enumerated(EnumType.STRING)
    private StatutInvite statutInvite;

    @ManyToMany(mappedBy = "invites")
    @JsonIgnore
    private List<Mariage> mariages = new ArrayList<>();

    public Invite(String cin, String nom, String prenom, StatutInvite statutInvite) {
        super(cin, nom, prenom);
        this.statutInvite = statutInvite;
    }

    @Override
    public String toString() {
        return "Invite{" +
                super.toString() +
                "statutInvite=" + statutInvite +
                '}';
    }
}
