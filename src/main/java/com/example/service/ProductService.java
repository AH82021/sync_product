package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService() {
        this.productRepository = new ProductRepository();
    }

    // Create a new product
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        productRepository.createProduct(product);
    }

    // Read a product by id
    public Product getProduct(int id) {
        return productRepository.readProduct(id);
    }

    // Update an existing product
    public void updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        productRepository.updateProduct(product);
    }

    // Delete a product by id
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    // List all products
    public Product[] listProducts() {
        return productRepository.getAllProducts();
    }
}
