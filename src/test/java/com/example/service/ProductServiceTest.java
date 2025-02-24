package com.example.service;

import com.example.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
    }

    @Test
    void testAddProduct() {
        Product product = new Product(10, "Service Test Product", 49.99);
        productService.addProduct(product);
        Product retrieved = productService.getProduct(10);
        assertNotNull(retrieved, "Product should be added via service");
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product(11, "Service Test Product", 59.99);
        productService.addProduct(product);
        product.setPrice(69.99);
        productService.updateProduct(product);
        Product updated = productService.getProduct(11);
        assertEquals(69.99, updated.getPrice(), "Product price should be updated via service");
    }

    @Test // basis skeleton
    void testDeleteProduct() {
        Product product = new Product(12, "Service Test Product", 19.99);
        productService.addProduct(product);
        productService.deleteProduct(12);
        Product deleted = productService.getProduct(12);
        assertNull(deleted, "Product should be deleted via service");
    }
}
