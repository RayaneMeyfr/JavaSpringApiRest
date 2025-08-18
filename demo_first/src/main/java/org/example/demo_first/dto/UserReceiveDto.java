package org.example.demo_first.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo_first.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReceiveDto {
    private String name;
    private String birthday;
    private String password;

    public User dtoToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthdayDate = LocalDate.parse(birthday, formatter);
        return User.builder().
                name(name).
                birthday(birthdayDate).
                password(password).
                build();
    }
}
