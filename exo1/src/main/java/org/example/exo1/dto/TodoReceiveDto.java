package org.example.exo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo1.model.Todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoReceiveDto {
    private String title;
    private String description;
    private String date;
    private Boolean isValidate;

    public Todo dtoToEntity(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormated = LocalDate.parse(this.date, formatter);
        return Todo.builder()
                .title(this.title)
                .description(this.description)
                .date(dataFormated)
                .isValidate(false).build();
    }

    public Todo dtoToEntityUpdate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormated = LocalDate.parse(this.date, formatter);
        return Todo.builder()
                .title(this.title)
                .description(this.description)
                .date(dataFormated)
                .isValidate(this.isValidate).build();
    }
}
