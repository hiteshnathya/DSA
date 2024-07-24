package Assignment.Day18.task1;
// DatabaseSingleton.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
    // Private constructor to prevent instantiation from outside
    private DatabaseSingleton() {}

    // Private static instance of the singleton class
    private static DatabaseSingleton instance = null;

    // Private Connection object
    private Connection connection = null;

    // Public static method to get the instance of the singleton class
    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
            // Initialize database connection here
            instance.initDatabaseConnection();
        }
        return instance;
    }

    // Private method to initialize database connection
    private void initDatabaseConnection() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Initialize database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password");

            System.out.println("Database connection initialized");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error initializing database connection: " + e.getMessage());
        }
    }

    // Method to get a database connection
    public Connection getConnection() {
        return connection;
    }

    // Method to close a database connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
}

// Main.java

