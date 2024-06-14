package config;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotificationManager {
    public static List<String[]> checkApproachingReturnDates(int daysBefore, int userID) {
        List<String[]> notifications = new ArrayList<>();

        java.util.Date currentDate = new java.util.Date();
        Date today = new Date(currentDate.getTime());

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, daysBefore);
        Date targetDate = new Date(cal.getTime().getTime());

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            connection = display.getConnection();
            pstmt = connection.prepareStatement(
                "SELECT book_id, return_date, status " +
                "FROM borrowings " +
                "WHERE return_date <= ? AND u_id = ? AND status != 'Returned'"
            );
            pstmt.setDate(1, targetDate);
            pstmt.setInt(2, userID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String bookID = rs.getString("book_id");
                String returnDateString = rs.getString("return_date");
                String status = rs.getString("status");

                if (status != null && status.equalsIgnoreCase("Pending")) {
                    continue; 
                }

                if (returnDateString != null && !returnDateString.isEmpty()) {
                    try {
                        Date returnDate = Date.valueOf(returnDateString);
                        String[] notification = {bookID, returnDate.toString()};
                        notifications.add(notification);
                    } catch (IllegalArgumentException e) {
                        // Handle parsing error if necessary
                    }
                } else {
                    // Handle null or empty return date string if necessary
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return notifications;
    }
}
