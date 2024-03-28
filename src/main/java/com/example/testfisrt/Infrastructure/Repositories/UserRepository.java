package com.example.testfisrt.Infrastructure.Repositories;

import com.example.testfisrt.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByUsername(String username);
}
