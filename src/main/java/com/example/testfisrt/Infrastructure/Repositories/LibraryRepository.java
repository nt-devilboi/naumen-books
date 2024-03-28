package com.example.testfisrt.Infrastructure.Repositories;

import com.example.testfisrt.domain.entities.Account;
import com.example.testfisrt.domain.entities.Book;
import com.example.testfisrt.domain.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    public Optional<Library> getByAccount(Account account);

}
