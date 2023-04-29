package com.example.mariage.resource;

import com.example.mariage.entity.Personne;
import com.example.mariage.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personne")
public class PersonneResource {
    private final PersonneService personneService;

    public PersonneResource(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/all")
    public List<Personne> getAllPersonnes () {
        List<Personne> personnes = personneService.findAllPersonnes();
        return personnes;
    }

    @GetMapping("/find/{id}")
    public Optional<Personne> getPersonneById (@PathVariable("id") Long id) {
        Optional<Personne> personne = personneService.findPersonneById(id);
        return personne;
    }

    @PostMapping("/add")
    public Personne addPersonne(@RequestBody Personne personne) {
        Personne newPersonne = personneService.addPersonne(personne);
        return newPersonne;
    }

    @PutMapping("/update")
    public Personne updatePersonne(@RequestBody Personne personne) {
        Personne updatePersonne = personneService.updatePersonne(personne);
        return updatePersonne;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersonne(@PathVariable("id") Long id) {
        personneService.deletePersonne(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
