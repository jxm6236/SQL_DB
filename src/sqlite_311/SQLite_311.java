/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite_311;

import java.sql.*;

/**
 *
 * @author jxm6236
 */
public class SQLite_311 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // setting up database connection
            Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:sample.sqlite3", "app", "app");
            
            //Test Database Query
            Statement stmt = dbConnection.createStatement();
            String testQuery = "SELECT * FROM customer;";
            ResultSet results;

            results = stmt.executeQuery(testQuery);
            // processing results
            while (results.next()) {
                System.out.println("Result: " + results.getString("NAME"));
            }
            
            results.close();
            stmt.close();
            dbConnection.close();

        } catch (SQLException e) {
            System.out.println("Cannot connect to database.\n" + e.getMessage());
        }
    }
}
