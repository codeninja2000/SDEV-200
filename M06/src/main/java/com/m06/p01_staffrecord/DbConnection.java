package com.m06.p01_staffrecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DbConnection is a utility class for managing database connections.
 * It provides methods to establish and close connections to a database.
 */
public class DbConnection {
    private static String url;
    private static String user;
    private static String password;
    private Connection connection;

    public DbConnection(String url, String user, String password) {
        if (url == null || user == null || password == null) {
            throw new IllegalArgumentException("Database connection parameters cannot be null");
        }
        if (url.isEmpty() || user.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Database connection parameters cannot be empty");
        }
        if (!url.startsWith("jdbc:")) {
            throw new IllegalArgumentException("Database URL must start with 'jdbc:'");
        }
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established successfully.");
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void testConnection() throws SQLException {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connection to the database established successfully.");
            } else {
                System.out.println("Failed to establish connection to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            throw e;
        }
    }


}
