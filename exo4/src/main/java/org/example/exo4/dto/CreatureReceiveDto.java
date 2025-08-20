package org.example.exo4.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4.model.Creature;
import org.example.exo4.model.CreatureType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatureReceiveDto {
    private String name;
    @Min(value = 0, message = "L'âge ne peut pas être négatif")
    private int age;
    @Min(value = 10, message = "Le poids doit être au moins 10")
    @Max(value = 200, message = "Le poids ne peut pas dépasser 200")
    private double weight;
    private boolean dangerous;
    private CreatureType creatureType;

    public Creature dtoToEntity() {
        return Creature.builder()
                .name(name)
                .age(age)
                .weight(weight)
                .dangerous(dangerous)
                .creatureType(creatureType)
                .build();
    };
}
