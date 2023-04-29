package com.example.mariage.repo;

import com.example.mariage.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface SalleRepository extends JpaRepository<Salle, Long> {
}