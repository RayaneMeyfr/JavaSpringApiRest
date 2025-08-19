package org.example.exo2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private LocalDate dateSortie;
    private String description;
    private String duree;
    private String genre;
    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    @JsonBackReference
    private Realisateur realisateur;
}
