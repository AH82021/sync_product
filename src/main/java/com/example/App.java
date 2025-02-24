package com.example;

import com.example.model.Product;
import com.example.service.ProductService;

public class App {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        // Sample operation - actual logic is to be implemented
        Product product = new Product(1, "Sample Product", 9.99);
        productService.addProduct(product);

        // TODO: Add further interactive or command-line functionality as needed
    }
}

