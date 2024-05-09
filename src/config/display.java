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
import javax.swing.JOptionPane;

public class display {
    private static Connection connect;

    public static Connection getConnection() throws SQLException {
        if (connect == null || connect.isClosed()) {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "");
        }
        return connect;
    }
    
    
    
    
     public static void borrowBook(String bookID) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                PreparedStatement checkStmt = connection.prepareStatement("SELECT * FROM books WHERE book_id = ? AND Status = 'Available'");
                checkStmt.setString(1, bookID);
                ResultSet checkResult = checkStmt.executeQuery();

                if (checkResult.next()) {
                    PreparedStatement borrowStmt = connection.prepareStatement("UPDATE books SET Status = 'Borrowed' WHERE book_id = ?");
                    borrowStmt.setString(1, bookID);
                    int rowsUpdated = borrowStmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Book borrowed successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to borrow the book.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Book with ID " + bookID + " is not available for borrowing.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to establish a connection to the database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error borrowing book: " + ex.getMessage());
            ex.printStackTrace();
        }
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

