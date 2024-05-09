/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


import config.Session;
import config.display;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import library.LoginForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Hp
 */
public class Viewavab extends javax.swing.JFrame {

    /**
     * Creates new form admindashboard
     */
    public Viewavab() {
        initComponents();
        displayData();
    }
    
     public void displayData() {
    try {
        Connection connection = display.getConnection();
        if (connection != null) {
            String query = "SELECT book_id, book_name, author, Publisher, "
                         + "CASE "
                         + "    WHEN SUM(quantity) = 0 THEN 'Out of stock' "
                         + "    ELSE 'Available' "
                         + "END AS Status, "
                         + "SUM(quantity) AS quantity "
                         + "FROM books "
                         + "GROUP BY book_id, book_name, author, Publisher";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if (rs != null) {
                table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
            } else {
                JOptionPane.showMessageDialog(this, "No available books found.");
            }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        print = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        printtable = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchs = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        table.setGridColor(new java.awt.Color(153, 0, 0));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(270, 120, 620, 340);

        jPanel7.setBackground(new java.awt.Color(153, 0, 0));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, 30));

        label2.setBackground(new java.awt.Color(0, 0, 0));
        label2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        jPanel7.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 110, 70));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/male_user_50px.png"))); // NOI18N
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" Welcome to Library ");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 850, 50));

        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 0, 910, 70);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(null);

        jButton4.setBackground(new java.awt.Color(153, 0, 0));
        jButton4.setText("LOGOUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(70, 460, 100, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel5.setText("REMOVE BOOKS");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5);
        jLabel5.setBounds(30, 230, 160, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-book-reading-24.png"))); // NOI18N
        jLabel7.setText("VIEW AVAILABLE BOOKS");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 280, 220, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Contact_26px.png"))); // NOI18N
        jLabel8.setText("VIEW USERS");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel8);
        jLabel8.setBounds(30, 330, 120, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel9.setText("ADD BOOKS");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 180, 130, 30);

        jPanel6.setBackground(new java.awt.Color(153, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Home_26px_2.png"))); // NOI18N
        jLabel10.setText("Home Page ");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 100, 250, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 250, 510);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(null);

        print.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        print.setText("PRINT");
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });
        jPanel2.add(print);
        print.setBounds(30, 0, 80, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(760, 470, 130, 30);

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));
        jPanel4.setLayout(null);

        printtable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printtable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/table.png"))); // NOI18N
        printtable.setText("PRINT AS TABLE");
        printtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printtableMouseClicked(evt);
            }
        });
        jPanel4.add(printtable);
        printtable.setBounds(0, 0, 140, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(270, 470, 140, 30);

        jPanel5.setBackground(new java.awt.Color(153, 0, 0));
        jPanel5.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/print.png"))); // NOI18N
        jLabel3.setText("PRINT");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(30, 0, 80, 30);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(760, 470, 130, 30);

        searchs.setText("Input Here");
        searchs.setBorder(null);
        searchs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchsMouseClicked(evt);
            }
        });
        jPanel1.add(searchs);
        searchs.setBounds(700, 80, 160, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(700, 110, 160, 10);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11);
        jLabel11.setBounds(860, 74, 27, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(670, 80, 23, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(null, "Logout Successful!");
        LoginForm dash = new LoginForm();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        remove loginForm = new remove();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Viewavab loginForm = new Viewavab();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        viewusers loginForm = new viewusers();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        ADD loginForm = new ADD();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        admindashboard ad = new  admindashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked

    }//GEN-LAST:event_label2MouseClicked

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

    private void printtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printtableMouseClicked
       MessageFormat header = new MessageFormat("Library Management System");
      MessageFormat footer = new MessageFormat("Page{0,number,integer}");
      
      try{
          table.print(JTable.PrintMode.NORMAL, header, footer);
      } catch (PrinterException ex) {
            Logger.getLogger(Viewavab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printtableMouseClicked

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
    int row = table.getSelectedRow();
    int column = table.getSelectedColumn();
    
    if (row == -1 || column == -1) {
        return;
    }
    
    String columnName = table.getColumnName(column);
    
    Object cellData = table.getValueAt(row, column);
    
    StringBuilder rowData = new StringBuilder();
    
    rowData.append(columnName).append(" = ").append(cellData != null ? cellData.toString() : "").append("\n");
    
    for (int col = 0; col < table.getColumnCount(); col++) {
        if (col != column) {
            String otherColumnName = table.getColumnName(col);
            Object otherCellData = table.getValueAt(row, col);
            rowData.append(otherColumnName).append(" = ").append(otherCellData != null ? otherCellData.toString() : "").append("\n");
        }
    }
    
    try {
        JTextArea textArea = new JTextArea(rowData.toString());
        textArea.print();
    } catch (PrinterException ex) {
        Logger.getLogger(Viewavab.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error printing the selected row data: " + ex.getMessage());
    }
    }//GEN-LAST:event_printMouseClicked

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
            java.util.logging.Logger.getLogger(Viewavab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewavab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewavab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewavab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewavab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel label2;
    private javax.swing.JLabel print;
    private javax.swing.JLabel printtable;
    private javax.swing.JTextField searchs;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}