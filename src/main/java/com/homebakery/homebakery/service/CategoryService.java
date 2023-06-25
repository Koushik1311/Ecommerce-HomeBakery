package com.homebakery.homebakery.service;

// imports
import java.util.List;

import com.homebakery.homebakery.model.Category;

public interface CategoryService {

    // method for find all categories and return as a list
    List<Category> findAll();

    // method for find category by id
    Category findById(int theId);

    // method for saving new category and updating existing category
    void save(Category category);

    // method for deleting category by id
    void deleteById(int theId);
}
