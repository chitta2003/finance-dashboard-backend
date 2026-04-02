package com.chitta.finance.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chitta.finance.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}