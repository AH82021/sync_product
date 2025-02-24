package com.example.model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ProductTest {

    @Test
    public void testInstanceVariablesCount() {
        Field[] fields = Product.class.getDeclaredFields();
        int instanceFieldCount = 0;
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                instanceFieldCount++;
            }
        }
        assertEquals(3, instanceFieldCount, "Product should have exactly 3 instance variables");
    }

    @Test
    public void testGetterAndSetter() {
        Product product = new Product();
        product.setId(1);
        product.setName("Test Product");
        product.setPrice(19.99);

        assertEquals(1, product.getId(), "Getter for id should return the value set by setter");
        assertEquals("Test Product", product.getName(), "Getter for name should return the value set by setter");
        assertEquals(19.99, product.getPrice(), "Getter for price should return the value set by setter");
    }

    @Test
    public void testEqualsAndHashCode() {
        Product product1 = new Product(1, "Test Product", 19.99);
        Product product2 = new Product(1, "Test Product", 19.99);
        Product product3 = new Product(2, "Different Product", 29.99);

        // Check equals method
        assertTrue(product1.equals(product2), "Products with identical values should be equal");
        assertFalse(product1.equals(product3), "Products with different values should not be equal");

        // Check hashCode method for equal objects
        assertEquals(product1.hashCode(), product2.hashCode(), "Equal products should have the same hash code");
    }

    @Test
    public void testToString() {
        Product product = new Product(1, "Test Product", 19.99);
        String toStringValue = product.toString();
        assertNotNull(toStringValue, "toString should not return null");
        // Verify that toString contains each of the instance variable values.
        assertTrue(toStringValue.contains("1"), "toString should contain the product id");
        assertTrue(toStringValue.contains("Test Product"), "toString should contain the product name");
        assertTrue(toStringValue.contains("19.99"), "toString should contain the product price");
    }
}
