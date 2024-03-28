package com.example.testfisrt.domain.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "library")
public class Library
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public Account account;
    @OneToMany
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    public List<Book> books;
}
