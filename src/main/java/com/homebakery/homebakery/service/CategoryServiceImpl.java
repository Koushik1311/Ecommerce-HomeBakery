package com.homebakery.homebakery.service;

// imports
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.homebakery.homebakery.model.Category;
import com.homebakery.homebakery.repository.CategoryRepository;

// CategoryService is implemented in this class 
// Class name CategoryServiceImpl
@Service
public class CategoryServiceImpl implements CategoryService {

    // filds
    // Repository fild
    private CategoryRepository categoryRepository;

    // Constructor Injection which sets the value of "categoryRepository"
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Find all the categories and returns as a list
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Category will be find by id and it will check is the id available or nor
    // if the id got foud it will return the result but if it is not found it will
    // throw runtime error
    @Override
    public Category findById(int theId) {
        Optional<Category> result = categoryRepository.findById(theId);

        Category category = null;

        if (result.isPresent()) {
            category = result.get();
        } else {
            // we didn't find the category throw runtime exception
            throw new RuntimeException("Did not find category - " + theId);
        }

        return category;
    }

    // this will create or update categoty
    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    // this will delete a category using its id
    @Override
    public void deleteById(int theId) {
        categoryRepository.deleteById(theId);
    }

}
