package org.example.exo1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo1.dto.TodoResponseDto;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private Boolean isValidate;

    public TodoResponseDto entityToDto(){
        return TodoResponseDto.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .date(this.date)
                .isValidate(this.isValidate).build();
    }
}
