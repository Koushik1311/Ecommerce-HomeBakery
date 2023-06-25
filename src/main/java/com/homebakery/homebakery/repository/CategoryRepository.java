package com.homebakery.homebakery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homebakery.homebakery.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
