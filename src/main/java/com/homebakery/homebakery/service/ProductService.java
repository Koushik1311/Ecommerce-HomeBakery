package com.homebakery.homebakery.service;

import java.util.List;

import com.homebakery.homebakery.model.Product;

public interface ProductService {
    // method for find all categories and return as a list
    List<Product> findAll();

    // method for find category by id
    Product findById(int id);

    // method for saving new category and updating existing category
    void save(Product product);

    // method for deleting category by id
    void deleteById(int id);

    List<Product> findAllProductByCategoryId(int id);
}
