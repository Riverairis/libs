package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dbConnector {

    private static dbConnector instance;
    public Connection connect;

    public dbConnector() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    public static synchronized dbConnector getInstance() {
        if (instance == null) {
            instance = new dbConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connect;
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        PreparedStatement pstmt = connect.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }

    // Function to save data
    public boolean insertData(String sql) {
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Inserted Successfully!");
            pstmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false;
        }
    }

    // Function to insert data
    public int insert(String sql) {
        int result;
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Inserted Successfully!");
            pstmt.close();
            result = 1;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            result = 2;
        }
        return result;
    }

    // Function to update data
    public void updatedata(String sql) {
        try {
            PreparedStatement pstmt = connect.prepareStatement(sql);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            } else {
                System.out.println("Data Update Failed!");
            }
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }

    public void updateData(String sql) throws SQLException {
        PreparedStatement pstmt = connect.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
