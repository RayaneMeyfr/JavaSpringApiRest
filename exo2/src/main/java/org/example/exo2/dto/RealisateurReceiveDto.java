package org.example.exo2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo2.model.Film;
import org.example.exo2.model.Realisateur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealisateurReceiveDto {
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String nationalite;
    private List<Film> films;

    public Realisateur dtoToEntity(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormated = LocalDate.parse(this.dateNaissance, formatter);
        return Realisateur.builder()
                .nom(this.nom)
                .prenom(this.prenom)
                .dateNaissance(dataFormated)
                .nationalite(this.nationalite)
                .films(this.films)
                .build();
    }
}
