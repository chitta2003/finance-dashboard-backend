package com.chitta.finance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chitta.finance.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}