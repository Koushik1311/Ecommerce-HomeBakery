package com.homebakery.homebakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homebakery.homebakery.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
