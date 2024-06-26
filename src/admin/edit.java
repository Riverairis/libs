/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.display;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import library.LoginForm;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Hp
 */
public class edit extends javax.swing.JFrame {

    /**
     * Creates new form ADD
     */
    public edit() {
        initComponents();
        setTitle("LIBRARY");
          displayData();
    }
    
   public void displayData() {
    try {
        Connection connection = display.getConnection();
        if (connection != null) {
            String query = "SELECT book_id, ISBN, book_name, author, Publisher, "
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

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pub = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        quan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        stat = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchs = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(153, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setBackground(new java.awt.Color(0, 0, 0));
        label2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        jPanel6.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 110, 70));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Home_26px_2.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/male_user_50px.png"))); // NOI18N
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Welcome to Library ");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 850, 50));

        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 0, 910, 70);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(null);

        update.setBackground(new java.awt.Color(153, 0, 0));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel4.add(update);
        update.setBounds(90, 470, 90, 23);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book ID");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(40, 80, 90, 30);

        id.setBackground(new java.awt.Color(51, 51, 51));
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setEnabled(false);
        jPanel4.add(id);
        id.setBounds(40, 110, 210, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Book Name");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(40, 180, 90, 40);

        name.setBackground(new java.awt.Color(51, 51, 51));
        name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(name);
        name.setBounds(40, 210, 210, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Author");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(40, 230, 90, 40);

        author.setBackground(new java.awt.Color(51, 51, 51));
        author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(author);
        author.setBounds(40, 260, 210, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Publisher");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(40, 280, 90, 40);

        pub.setBackground(new java.awt.Color(51, 51, 51));
        pub.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(pub);
        pub.setBounds(40, 310, 210, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(40, 330, 90, 40);

        quan.setBackground(new java.awt.Color(51, 51, 51));
        quan.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(quan);
        quan.setBounds(40, 360, 210, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Status");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(40, 380, 200, 40);

        stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Out of Stock" }));
        jPanel4.add(stat);
        stat.setBounds(40, 410, 210, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ISBN");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(40, 140, 80, 20);

        isbn.setBackground(new java.awt.Color(51, 51, 51));
        isbn.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(isbn);
        isbn.setBounds(40, 160, 210, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 280, 510);

        table.setGridColor(new java.awt.Color(153, 0, 0));
        jScrollPane1.setViewportView(table);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(300, 120, 600, 370);

        searchs.setText("Input Here");
        searchs.setBorder(null);
        searchs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchsMouseClicked(evt);
            }
        });
        jPanel3.add(searchs);
        searchs.setBounds(710, 80, 160, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(710, 110, 160, 10);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel11);
        jLabel11.setBounds(870, 70, 27, 50);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel8);
        jLabel8.setBounds(680, 80, 23, 40);

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

    
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String bookID = id.getText().trim();
        String bookName = name.getText().trim();
        String authorName = author.getText().trim();
        String quantity = quan.getText().trim();
        String status = (String) stat.getSelectedItem();
        String publisher = pub.getText().trim();
        String isbno = isbn.getText().trim();
    
        if (bookID.isEmpty() || bookName.isEmpty() || authorName.isEmpty() || quantity.isEmpty() || status.isEmpty() || publisher.isEmpty() || isbno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }
        if (!quantity.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Quantity must be a valid number.");        
                quan.setText("");
                   return;
            }
        try {
            Connection connection = display.getConnection();
            if (connection != null) {

                String updateQuery = "UPDATE books SET book_name = ?, ISBN = ?, author = ?, Publisher = ?, quantity = ? WHERE book_id = ?";
                PreparedStatement pstmt = connection.prepareStatement(updateQuery);
                pstmt.setString(1, bookName);
                pstmt.setString(2, isbno);
                pstmt.setString(3, authorName);
                pstmt.setString(4, publisher);
                pstmt.setString(5, quantity);
                pstmt.setString(6, bookID);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Book information updated successfully.");
                    displayData();

                    id.setText("");
                    name.setText("");
                    author.setText("");
                    quan.setText("");
                    stat.setSelectedIndex(0);
                    pub.setText("");
                    isbn.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update book information. Book ID not found.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to establish a connection to the database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating book information: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        admindashboard ad = new  admindashboard();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

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
                String query = "SELECT book_id, ISBN, book_name, author, Publisher, Status, quantity FROM books WHERE book_id LIKE ? OR ISBN LIKE ? OR book_name LIKE ? OR author LIKE ? OR Publisher LIKE ? OR Status LIKE ? OR quantity LIKE ?";
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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        displayData();
    }//GEN-LAST:event_jLabel8MouseClicked
    
    
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
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField author;
    public javax.swing.JTextField id;
    public javax.swing.JTextField isbn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel label2;
    public javax.swing.JTextField name;
    public javax.swing.JTextField pub;
    public javax.swing.JTextField quan;
    private javax.swing.JTextField searchs;
    public javax.swing.JComboBox<String> stat;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
