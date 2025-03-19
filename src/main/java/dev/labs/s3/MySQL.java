package dev.labs.s3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Enforced at build time.
// All methods defined by an implemented interface MUST appear in the class's source code:
public class MySQL implements SQL {
    private Connection connection;

    @Override
    public void connect(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    @Override
    public void executeQuery(String query) {
        try (Statement stmt = connection.createStatement()) {
            boolean isResultSet = stmt.execute(query);
            if (isResultSet) {
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    System.out.println("Result: " + rs.getString(1)); // Modify as needed
                }
            } else {
                System.out.println("Query executed successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Query execution failed: " + e.getMessage());
        }
    }

    @Override
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

