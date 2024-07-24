package Assignment.Day18.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton { public static void main(String[] args) {
    DatabaseSingleton dbSingleton = DatabaseSingleton.getInstance();
    Connection connection = dbSingleton.establishConnection("jdbc:mysql://localhost:3306/wipro",  "root",  "rps@123");
    // Use the connection
    dbSingleton.closeConnection();
}
    // Private static instance of the class
    private static volatile DatabaseSingleton instance;

    // Private connection object
    private Connection connection;

    // Private constructor to prevent instantiation
    private DatabaseSingleton() {}

    // Public method to get the singleton instance
    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            synchronized (DatabaseSingleton.class) {
                if (instance == null) {
                    instance = new DatabaseSingleton();
                }
            }
        }
        return instance;
    }

    // Method to establish a database connection
    public Connection establishConnection(String url, String username, String password) {
        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found!");
        } catch (SQLException e) {
            System.out.println("Error establishing database connection!");
        }
        return connection;
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection!");
        }
    }

    // Prevent serialization
    private Object readResolve() {
        return instance;
    }

    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned");
    }
}
