package com.example.testfisrt.domain.entities;


import com.example.testfisrt.Contollers.RestContoller.BookContoller.Dto.RequestBook;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;
    public String author;
    public LocalDate dateRelease;
    public String description;


    public static Book From(RequestBook requestBook) {
        var book = new Book();
        book.setAuthor(requestBook.getAuthor());
        book.setName(requestBook.getName());
        book.setDescription(requestBook.getDesc());
        book.setDateRelease(requestBook.getDateRelease());

        return book;
    }
}
