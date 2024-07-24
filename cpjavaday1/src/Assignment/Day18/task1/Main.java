package Assignment.Day18.task1;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseSingleton dbSingleton = DatabaseSingleton.getInstance();
        Connection connection = dbSingleton.getConnection();

        if (connection != null) {
            System.out.println("Database connection established");

            // Use the connection
            try {
                // Create a statement
                java.sql.Statement statement = connection.createStatement();

                // Execute a query
                java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

                // Process the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                }

                // Close the statement and result set
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }

            // Close the database connection
            dbSingleton.closeConnection(connection);
        } else {
            System.out.println("Failed to establish database connection");
        }
    }
}
