package com.example.mariage.service;

import com.example.mariage.entity.Mariage;
import com.example.mariage.entity.Personne;
import com.example.mariage.entity.Salle;
import com.example.mariage.repo.MariageRepository;
import com.example.mariage.repo.PersonneRepository;
import com.example.mariage.repo.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    private final PersonneRepository personneRepository;
    private final MariageRepository mariageRepository;
    private final SalleRepository salleRepository;

    public PersonneService(PersonneRepository personneRepository, MariageRepository mariageRepository, SalleRepository salleRepository) {
        this.personneRepository = personneRepository;
        this.mariageRepository = mariageRepository;
        this.salleRepository = salleRepository;
    }

    public Personne addPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public List<Personne> findAllPersonnes() {
        return personneRepository.findAll();
    }

    public Personne updatePersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    public Optional<Personne> findPersonneById(Long id) {
        return personneRepository.findById(id);
    }

    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
    }

    public Mariage reserver(Personne homme, Personne femme, Mariage mariage) {
        mariage.setPersonneHomme(homme);
        homme.getMariagesHomme().add(mariage);
        mariage.setPersonneFemme(femme);
        femme.getMariagesFemme().add(mariage);
        personneRepository.save(homme);
        personneRepository.save(femme);
        return mariageRepository.save(mariage);
    }

    public Boolean confirmer(Mariage mariage, Salle salle) {
        if(mariageRepository.findMariageByDateAndSalle(mariage.getDate(), salle) == null
                && mariage.getCapaciteMinimal() <= salle.getCapacite()) {
            mariage.setSalle(salle);
            mariageRepository.save(mariage);
            return true;
        }
        return false;
    }




}
