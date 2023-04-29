package com.example.mariage.repo;

import com.example.mariage.entity.Mariage;
import com.example.mariage.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface MariageRepository extends JpaRepository<Mariage, Long> {
    Optional<Mariage> findMariageByDateAndSalle(LocalDate date, Salle salle);
}