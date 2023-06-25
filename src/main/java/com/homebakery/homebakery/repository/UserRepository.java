package com.homebakery.homebakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homebakery.homebakery.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
