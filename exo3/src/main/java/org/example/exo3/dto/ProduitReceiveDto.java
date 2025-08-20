package org.example.exo3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo3.model.Produit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitReceiveDto {
    private String nom;
    private float prix;

    public Produit dtoToProduit() {
        return Produit.builder().nom(this.nom).prix(this.prix).build();
    }
}
