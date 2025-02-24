package com.example.database;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgresConnectionManagerIT {

    /**
     * Integration test for PostgresConnectionManager.
     * This test assumes that:
     *  - The PostgreSQL instance is running on localhost.
     *  - The connection URL in PostgresConnectionManager is updated with the correct database name.
     *  - The credentials are set to:
     *         USER: "postgres"
     *         PASSWORD: "pass123"
     */
    @Test
    public void testGetConnection() {
        try (Connection connection = PostgresConnectionManager.getConnection()) {
            assertNotNull(connection, "Connection should not be null");
            // Check if connection is valid with a 2-second timeout.
            assertTrue(connection.isValid(2), "Connection should be valid");
        } catch (SQLException e) {
            fail("Failed to obtain connection: " + e.getMessage());
        }
    }
}
