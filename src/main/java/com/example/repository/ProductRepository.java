package com.example.repository;

import com.example.model.Product;

public class ProductRepository {

    private Product[] products;
    private int count;

    public ProductRepository() {
        // Initialize the products array with a fixed size, e.g., 100.
        products = new Product[100];
        count = 0;
    }

    /**
     * Adds a new product to the repository.
     *
     * @param product the product to add
     * @throws IllegalStateException if the repository is full
     */
    public void createProduct(Product product) {
        if (count >= products.length) {
            throw new IllegalStateException("Product repository is full");
        }
        products[count++] = product;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the product ID to search for
     * @return the product if found; otherwise, null
     */
    public Product readProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                return products[i];
            }
        }
        return null;
    }

    /**
     * Updates an existing product.
     *
     * @param product the product with updated values
     */
    public void updateProduct(Product product) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == product.getId()) {
                products[i] = product;
                return;
            }
        }
        // Optionally, you could throw an exception if the product is not found.
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the product ID to delete
     */
    public void deleteProduct(int id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                // Shift the remaining products to fill the gap.
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[count - 1] = null; // Clear the last element.
                count--;
                return;
            }
        }
    }

    /**
     * Returns all products currently stored.
     *
     * @return an array of non-null products
     */
    public Product[] getAllProducts() {
        Product[] currentProducts = new Product[count];
        System.arraycopy(products, 0, currentProducts, 0, count);
        return currentProducts;
    }
}
