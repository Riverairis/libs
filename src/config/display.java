/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class display {
    private static Connection connect;

    public static Connection getConnection() throws SQLException {
        if (connect == null || connect.isClosed()) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "");
        }
        return connect;
    }
     
     public static int getNumBooks() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM books");
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        }
        return 0;
    }

    public static int getNumUsers() throws SQLException {
        Connection connection = getConnection();
        if (connection != null) {
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM tbl");
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        }
        return 0;
    }

    
    
    
}

