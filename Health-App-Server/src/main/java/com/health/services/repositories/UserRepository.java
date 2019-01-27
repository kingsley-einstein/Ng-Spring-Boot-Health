package com.health.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.services.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUniqueToken(String uniqueToken);
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
}