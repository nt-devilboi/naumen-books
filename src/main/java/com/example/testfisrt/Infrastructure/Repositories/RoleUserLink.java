package com.example.testfisrt.Infrastructure.Repositories;

import com.example.testfisrt.domain.entities.Role;
import com.example.testfisrt.domain.entities.RoleAccount;
import com.example.testfisrt.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleUserLink extends JpaRepository<RoleAccount,Long> {
    Optional<Set<RoleAccount>> findByAccount(Account user);


    Optional<Set<RoleAccount>> findByRole(Role role);
}
