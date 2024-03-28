package com.example.testfisrt.domain.entities;

import com.example.testfisrt.Contollers.RestContoller.Dto.UserSingUp;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.accessibility.AccessibleContext;


@Entity
@Data
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String email;
    private String password;


    public static Account From(UserSingUp userSingUp, PasswordEncoder passwordEncoder) {
        var newAccount = new Account();
        newAccount.setUsername(userSingUp.getUsername());
        newAccount.setPassword(passwordEncoder.encode(userSingUp.getPassword()));
        newAccount.setEmail(userSingUp.getEmail());

        return newAccount;
    }
}