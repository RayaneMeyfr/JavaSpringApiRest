package org.example.exo2.repository;

import org.example.exo2.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByRealisateurNom(String nom);
}
