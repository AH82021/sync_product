package com.example;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    @Test
    void testAppInitialization() {
        // Test the main method initialization
        App.main(new String[]{});
    }

    @Test

    void  testCheckUsername() {
        App app = new App();
        assertTrue(app.checkUsername("username123"), "Username should be more than 8 characters");
        assertFalse(app.checkUsername("user"), "Username should be less than 8 characters");
    }
}
