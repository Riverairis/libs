/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.display;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import library.LoginForm;

/**
 *
 * @author Hp
 */
public class admindashboard extends javax.swing.JFrame {

    /**
     * Creates new form admindashboard
     */
    public admindashboard() {
        initComponents();
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
        jPanel3 = new javax.swing.JPanel();
        label2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        books = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        users = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label2.setBackground(new java.awt.Color(0, 0, 0));
        label2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });
        jPanel3.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 110, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/male_user_50px.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Welcome to Library ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 850, 50));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 910, 70);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setText("LOGOUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(70, 460, 100, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel1.setText("REMOVE BOOKS");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 230, 160, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-book-reading-24.png"))); // NOI18N
        jLabel2.setText("VIEW AVAILABLE BOOKS");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 280, 220, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Contact_26px.png"))); // NOI18N
        jLabel3.setText("VIEW USERS");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 330, 120, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel4.setText("ADD BOOKS");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 180, 130, 30);

        jPanel6.setBackground(new java.awt.Color(153, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Home_26px_2.png"))); // NOI18N
        jLabel10.setText("Home Page ");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 40));

        jPanel2.add(jPanel6);
        jPanel6.setBounds(0, 100, 250, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 250, 510);

        jPanel4.setBackground(new java.awt.Color(153, 0, 0));
        jPanel4.setLayout(null);

        books.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        books.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_Book_Shelf_50px.png"))); // NOI18N
        jPanel4.add(books);
        books.setBounds(60, 50, 130, 50);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(0, 0, 230, 20);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(330, 340, 230, 140);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("No. of Users");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(600, 310, 110, 20);

        jPanel5.setBackground(new java.awt.Color(153, 0, 0));
        jPanel5.setLayout(null);

        users.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_People_50px.png"))); // NOI18N
        jPanel5.add(users);
        users.setBounds(60, 50, 120, 50);

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8);
        jPanel8.setBounds(0, 0, 230, 20);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(600, 340, 230, 140);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("No. of Books");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 310, 110, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cover2.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(250, 70, 660, 220);

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
        
        try {
            int numBooks = display.getNumBooks();
            int numUsers = display.getNumUsers();

            books.setText(" " + numBooks);
            users.setText(" " + numUsers);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error getting number of books or users: " + ex.getMessage());
            ex.printStackTrace();
        }
        }
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null, "Logout Successful!");
        LoginForm dash = new LoginForm();
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        viewusers loginForm = new viewusers();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        ADD loginForm = new ADD();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        remove loginForm = new remove();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       Viewavab loginForm = new Viewavab();
        loginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked

    }//GEN-LAST:event_label2MouseClicked

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
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admindashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel books;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel8;
    public javax.swing.JLabel label2;
    private javax.swing.JLabel users;
    // End of variables declaration//GEN-END:variables
}
