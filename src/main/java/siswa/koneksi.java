/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package siswa;

import java.sql.*;

public class koneksi {

    // Method to establish and return a database connection
    public static Connection GetConnection() {
        Connection connection = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/pmr_visual", "root", "");
            System.out.println("Database Connected");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
        return connection;
    }

    // Main method for testing the connection
    public static void main(String[] args) {
        try (Connection connection = GetConnection()) {
            if (connection != null) {
                // Create a Statement
                Statement statement = connection.createStatement();
                
                // Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM siswa");
                
                // Iterate through the result and print the student details
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("nim") + "\t" +
                            resultSet.getString("nama") + "\t" +
                            resultSet.getString("jurusan"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during query execution: " + e.getMessage());
        }
    }
}
