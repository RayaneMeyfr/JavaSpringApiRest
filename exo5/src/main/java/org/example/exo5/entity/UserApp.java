package org.example.exo5.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo5.enums.Role;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @Column(unique = true)
    private String email;
    private String password;
    private Role role;

    public UserApp(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role == 0 ? Role.ROLE_USER : Role.ROLE_ADMIN;
    }
}

