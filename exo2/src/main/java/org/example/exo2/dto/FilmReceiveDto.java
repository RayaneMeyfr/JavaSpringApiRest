package org.example.exo2.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2.model.Film;
import org.example.exo2.model.Realisateur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmReceiveDto {
    private String nom;
    private String dateSortie;
    private String description;
    private String duree;
    private String genre;
    private int realisateur;

    public Film dtoToEntity(Realisateur realisateur){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormated = LocalDate.parse(this.dateSortie, formatter);
        return Film.builder()
                .nom(this.nom)
                .description(this.description)
                .duree(this.duree)
                .genre(this.genre)
                .realisateur(realisateur)
                .dateSortie(dataFormated)
                .build();
    }
}
