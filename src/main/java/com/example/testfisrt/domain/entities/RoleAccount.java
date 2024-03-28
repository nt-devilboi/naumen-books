package com.example.testfisrt.domain.entities;


import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "role_user")
public class RoleAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    public Role role;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Account account;
}
