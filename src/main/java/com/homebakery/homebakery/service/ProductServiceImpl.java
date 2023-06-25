package com.homebakery.homebakery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.homebakery.homebakery.model.Product;
import com.homebakery.homebakery.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> result = productRepository.findById(id);

        Product product = null;
        if (result.isPresent())
            product = result.get();

        else
            throw new RuntimeException("Did not find the Product - " + id);

        return product;

    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProductByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

}
