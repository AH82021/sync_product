package com.example.repository;

import com.example.model.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void testCreateAndReadProduct() {
        ProductRepository repo = new ProductRepository();
        Product product = new Product(1, "Test Product", 19.99);
        repo.createProduct(product);

        Product retrieved = repo.readProduct(1);
        // Initially, expect the test to fail until the method is implemented.
        assertNotNull(retrieved, "Product should be created and retrieved");
    }

    @Test
    void testUpdateProduct() {
        ProductRepository repo = new ProductRepository();
        Product product = new Product(2, "Test Product 2", 29.99);
        repo.createProduct(product);

        product.setPrice(39.99);
        repo.updateProduct(product);

        Product updated = repo.readProduct(2);
        assertEquals(39.99, updated.getPrice(), "Product price should be updated");
    }

    @Test
    void testDeleteProduct() {
        ProductRepository repo = new ProductRepository();
        Product product = new Product(3, "Test Product 3", 9.99);
        repo.createProduct(product);

        repo.deleteProduct(3);
        Product deleted = repo.readProduct(3);
        assertNull(deleted, "Product should be deleted");
    }
}
