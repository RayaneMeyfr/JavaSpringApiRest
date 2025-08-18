package org.example.exo1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoResponseDto {
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private Boolean isValidate;
}
