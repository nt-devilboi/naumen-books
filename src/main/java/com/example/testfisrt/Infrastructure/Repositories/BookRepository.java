package com.example.testfisrt.Infrastructure.Repositories;

import com.example.testfisrt.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<Book> getBookByName(String name);
    public Optional<Book> getBookById(Long id);
}
