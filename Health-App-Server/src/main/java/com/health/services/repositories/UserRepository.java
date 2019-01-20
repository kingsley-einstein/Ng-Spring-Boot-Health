package com.health.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.services.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUniqueToken(String uniqueToken);
    User findByEmail(String email);
    User findByName(String name);
}