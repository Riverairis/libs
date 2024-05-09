/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.*;
import config.Session;
import config.display;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.LoginForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Hp
 */
public class returnbook extends javax.swing.JFrame {

    /**
     * Creates new form ADD
     */
    public returnbook() {
        initComponents();
        displayData();
    }
    
     public void displayData() {
    try {
        Session sess = Session.getInstance();
        int userID = sess.getId();

        Connection connection = display.getConnection();
        if (connection != null) {
            // Select all attributes from the books table
            String query = "SELECT * FROM books";
            ResultSet rsBooks = connection.createStatement().executeQuery(query);

            // Create a map to store book status
            Map<String, String> bookStatusMap = new HashMap<>();

            // Initialize book status from the books table
            while (rsBooks.next()) {
                String bookID = rsBooks.getString("book_id");
                String status = rsBooks.getInt("Quantity") > 0 ? "Available" : "Out of Stock";
                bookStatusMap.put(bookID, status);
            }

            rsBooks.close();

            // Select the borrowed books for the logged-in user
            query = "SELECT book_id FROM borrowings WHERE u_id = ?";
            PreparedStatement pstmtBorrowed = connection.prepareStatement(query);
            pstmtBorrowed.setInt(1, userID);
            ResultSet rsBorrowed = pstmtBorrowed.executeQuery();

            // Update book status from the borrowings table
            while (rsBorrowed.next()) {
                String bookID = rsBorrowed.getString("book_id");
                bookStatusMap.put(bookID, "Borrowed");
            }

            rsBorrowed.close();
            pstmtBorrowed.close();

            // Populate table with book details and statuses
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Book ID");
            model.addColumn("Book Name");
            model.addColumn("Author");
            model.addColumn("Status");

            for (Map.Entry<String, String> entry : bookStatusMap.entrySet()) {
                String bookID = entry.getKey();
                String status = entry.getValue();

                query = "SELECT * FROM books WHERE book_id = ?";
                PreparedStatement pstmtBookDetails = connection.prepareStatement(query);
                pstmtBookDetails.setString(1, bookID);
                ResultSet rsBookDetails = pstmtBookDetails.executeQuery();

                if (rsBookDetails.next()) {
                    Object[] rowData = new Object[4];
                    rowData[0] = rsBookDetails.getString("book_id");
                    rowData[1] = rsBookDetails.getString("book_name");
                    rowData[2] = rsBookDetails.getString("author");
                    rowData[3] = status;
                    model.addRow(rowData);
                }

                rsBookDetails.close();
                pstmtBookDetails.close();
            }

            table.setModel(model);

        } else {
            JOptionPane.showMessageDialog(this, "Failed to establish a connection to the database.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error fetching data from database: " + ex.getMessage());
        ex.printStackTrace();
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        turn = new javax.swing.JButton();
        ret = new javax.swing.JTextField();
        searchs = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(153, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/male_user_50px.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Welcome to Library ");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 850, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Home_26px_2.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, -1, 30));

        label2.setBackground(new java.awt.Color(0, 0, 0));
        label2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        jPanel5.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 110, 70));

        jPanel3.add(jPanel5);
        jPanel5.setBounds(0, 0, 910, 70);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Book ID to Return");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(20, 220, 170, 30);

        turn.setBackground(new java.awt.Color(153, 0, 0));
        turn.setText("Return");
        turn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnActionPerformed(evt);
            }
        });
        jPanel4.add(turn);
        turn.setBounds(80, 460, 80, 30);

        ret.setBackground(new java.awt.Color(51, 51, 51));
        ret.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(ret);
        ret.setBounds(20, 260, 210, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 250, 510);

        searchs.setText("Input Here");
        searchs.setBorder(null);
        searchs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchsMouseClicked(evt);
            }
        });
        jPanel3.add(searchs);
        searchs.setBounds(680, 80, 180, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel11);
        jLabel11.setBounds(860, 70, 50, 50);

        table.setGridColor(new java.awt.Color(153, 0, 0));
        jScrollPane1.setViewportView(table);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(270, 120, 620, 370);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(680, 110, 180, 10);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel4);
        jLabel4.setBounds(650, 80, 23, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        userdashboard dash = new userdashboard();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void turnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnActionPerformed
    try {
    String bookID = ret.getText().trim();

    if (bookID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a book ID.");
        return;
    }

    Connection connection = display.getConnection();
    if (connection != null) {
        // Check if the book is borrowed
        PreparedStatement checkStmt = connection.prepareStatement("SELECT * FROM borrowings WHERE book_id = ?");
        checkStmt.setString(1, bookID);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            // Update the status of the book to "Available" in the books table
            PreparedStatement updateBookStatusStmt = connection.prepareStatement("UPDATE books SET Status = 'Available', Quantity = Quantity + 1 WHERE book_id = ?");
            updateBookStatusStmt.setString(1, bookID);
            int rowsAffected = updateBookStatusStmt.executeUpdate();

            if (rowsAffected > 0) {
                // Delete the borrowing entry
                PreparedStatement deleteBorrowingStmt = connection.prepareStatement("DELETE FROM borrowings WHERE book_id = ?");
                deleteBorrowingStmt.setString(1, bookID);
                int deletedRows = deleteBorrowingStmt.executeUpdate();

                if (deletedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Book returned successfully.");
                    displayData();
                    ret.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to return book.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update book status.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Book with ID " + bookID + " is not borrowed.");
        }

        checkStmt.close();
        rs.close();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to establish a connection to the database.");
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Error returning book: " + ex.getMessage());
    ex.printStackTrace();
}
    }//GEN-LAST:event_turnActionPerformed

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked

    }//GEN-LAST:event_label2MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         Session sess = Session.getInstance();
        
        if(sess.getId() == 0){
            JOptionPane.showMessageDialog(null, "No Account, Login First!");
            LoginForm lg = new LoginForm();
            lg.setVisible(true);
            this.dispose();
        }else{
        label2.setText(""+sess.getFname());
       
        } 
    }//GEN-LAST:event_formWindowActivated

    private void searchsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchsMouseClicked
        searchs.setText("");
    }//GEN-LAST:event_searchsMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        try {
            String searchTerm = searchs.getText().trim();
            if (!searchTerm.isEmpty() && !searchTerm.equals("Input Here")) {
                Connection connection = display.getConnection();
                if (connection != null) {
                    String query = "SELECT book_id, book_name, author, Publisher, Status, quantity FROM books WHERE book_id LIKE ? OR book_name LIKE ? OR author LIKE ? OR Publisher LIKE ? OR Status LIKE ? OR quantity LIKE ?";
                    PreparedStatement pstmt = connection.prepareStatement(query);
                    String likeTerm = "%" + searchTerm + "%";
                    for (int i = 1; i <= 6; i++) {
                        pstmt.setString(i, likeTerm);
                    }
                    ResultSet rs = pstmt.executeQuery();

                    if (rs != null) {
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                        rs.close();
                    } else {
                        JOptionPane.showMessageDialog(this, "No matching books found.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to establish a connection to the database.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a search term.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching search results: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        displayData();
    }//GEN-LAST:event_jLabel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel label2;
    private javax.swing.JTextField ret;
    private javax.swing.JTextField searchs;
    private javax.swing.JTable table;
    private javax.swing.JButton turn;
    // End of variables declaration//GEN-END:variables
}