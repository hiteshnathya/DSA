package Assignment.Day16.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement {
    public static void main(String[] args) {
        // Database connection settings
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
            return;
        }

        // Establish the database connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Create a PreparedStatement with a parameterized query
            String query = "SELECT * FROM employees WHERE department = ? AND salary > ?";
            try (java.sql.PreparedStatement pstmt = connection.prepareStatement(query)) {
                // Set the parameter values
                pstmt.setString(1, "Sales"); // department = 'Sales'
                pstmt.setInt(2, 50000); // salary > 50000

                // Execute the query
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    System.out.println("Query executed successfully");

                    // Process the result set
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String department = resultSet.getString("department");
                        int salary = resultSet.getInt("salary");

                        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}