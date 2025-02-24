package com.example.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionManager {
    // TODO: Consider externalizing these configuration values using environment variables or a configuration file.
    private static final String URL = "jdbc:postgresql://localhost:5432/analysis";
    private static final String USER = "postgres";
    private static final String PASSWORD = "arman2015";

    // Static block to load the PostgreSQL JDBC driver
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // Log the exception properly in real-world applications
            System.err.println("PostgreSQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        }
    }

    // Private constructor to prevent instantiation
    private PostgresConnectionManager() {}

    /**
     * Obtains a new database connection.
     *
     * @return a new Connection instance
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        // Using DriverManager to obtain a connection.
        // Remember to use try-with-resources when using this connection.
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
