/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Hp
 */
public class user extends javax.swing.JFrame {

    String Action;

    /**
     * Creates new form adduser
     */
    public user() {
        initComponents();
        setTitle("LIBRARY");
    }
    
    public void close(){              
        viewusers ad = new viewusers();
        ad.setVisible(true);
        this.dispose();
    }
    
     public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    
public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }

public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }

public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}

public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }

    public boolean duplicateCheck() {
    dbConnector dbc = new dbConnector();

    try {
        String query = "SELECT * FROM tbl WHERE u_username = ? OR u_email = ?";
        PreparedStatement pstmt = dbc.getConnection().prepareStatement(query);
        pstmt.setString(1, us.getText());
        pstmt.setString(2, em.getText());
        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()) {
            String existingEmail = resultSet.getString("u_email");
            String existingUsername = resultSet.getString("u_username");

            if (!existingEmail.equals(em.getText()) && !existingUsername.equals(us.getText())) {
                JOptionPane.showMessageDialog(null, "Email already exists! Please use a different one.");
                em.setText("");
                return true; 
            }

            if (!existingUsername.equals(us.getText())) {
                JOptionPane.showMessageDialog(null, "Username already exists! Please choose a different one.");
                us.setText("");
                return true; 
            }

            return false;
        } else {
            return false;
        }

    } catch (SQLException ex) {
        System.out.println("Database Error: " + ex.getMessage());
        return false;
    }
}

        private boolean isValidEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                                "[a-zA-Z0-9_+&*-]+)*@" +
                                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                                "A-Z]{2,7}$";

            Pattern pat = Pattern.compile(emailRegex);
            if (email == null)
                return false;
            return pat.matcher(email).matches();
        }
        
        private boolean integer(String input) {
    try {
        Long.parseLong(input);
        return true;
    } catch (NumberFormatException e) {
        return false;
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
        jLabel3 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        nums = new javax.swing.JTextField();
        us = new javax.swing.JTextField();
        ps = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        label = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        stat = new javax.swing.JLabel();
        stats = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JButton();
        select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BACK");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(690, 470, 60, 50);
        jPanel1.add(fn);
        fn.setBounds(120, 80, 250, 30);
        jPanel1.add(ln);
        ln.setBounds(120, 130, 250, 30);
        jPanel1.add(em);
        em.setBounds(120, 180, 250, 30);

        nums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numsActionPerformed(evt);
            }
        });
        jPanel1.add(nums);
        nums.setBounds(120, 230, 250, 30);
        jPanel1.add(us);
        us.setBounds(120, 280, 250, 30);
        jPanel1.add(ps);
        ps.setBounds(120, 330, 250, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Type: ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 410, 50, 30);

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jPanel1.add(type);
        type.setBounds(230, 410, 140, 30);

        label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label.setText("Label");
        label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelActionPerformed(evt);
            }
        });
        jPanel1.add(label);
        label.setBounds(180, 470, 90, 30);

        id.setEditable(false);
        id.setEnabled(false);
        jPanel1.add(id);
        id.setBounds(120, 30, 250, 30);

        stat.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        stat.setText("Status:");
        jPanel1.add(stat);
        stat.setBounds(130, 370, 48, 30);

        stats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel1.add(stats);
        stats.setBounds(230, 370, 140, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("First Name:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 80, 80, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Last Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 130, 80, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 180, 38, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Number:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 230, 60, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Username:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 280, 70, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Password:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 330, 70, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("ID:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 40, 17, 17);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(420, 30, 290, 340);

        remove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(610, 390, 100, 30);

        select.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(420, 390, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        close();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void numsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numsActionPerformed
    
    private void labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelActionPerformed
        if (Action.equals("Add")) {
        if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() || us.getText().isEmpty() || ps.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else if (ps.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must have at least 8 characters!");
            ps.setText("");
        } else if (!isValidEmail(em.getText())) {
            JOptionPane.showMessageDialog(null, "Invalid email format!");
            em.setText("");
        } else if (!integer(nums.getText())) {
            JOptionPane.showMessageDialog(null, "Number must be an integer!");
            nums.setText("");
        } else if (duplicateCheck()) {
            System.out.println("Duplicate Exist");
        } else if (destination.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a photo!");
        } else {
            try {
                dbConnector dbc = new dbConnector();
                String pass = passwordHasher.hashPassword(ps.getText());

                int result = dbc.insert("INSERT INTO tbl(u_fname, u_lname, u_email, u_username, u_password, Number, u_type, u_status, u_image) "
                        + "VALUES ('" + fn.getText() + "','" + ln.getText() + "','" + em.getText() + "','" + us.getText() + "','" + pass + "','" + nums.getText() + "','" + type.getSelectedItem() + "','" + stats.getSelectedItem() + "','" +destination+"')");
                try {
                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    System.out.println("Insert Image Error: " + ex);
                }
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "Successfully Save!");
                    close();
                } else {
                    System.out.println("Saving Data Failed!");
                }
            } catch (NoSuchAlgorithmException ex) {
                JOptionPane.showMessageDialog(null, "Error occurred while Saving: " + ex);
            }
        }
    } else if (Action.equals("Update")) {
        if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() || us.getText().isEmpty() || ps.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        } else if (ps.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must have at least 8 characters!");
            ps.setText("");
        } else if (!integer(nums.getText())) {
            JOptionPane.showMessageDialog(null, "Number must be an integer!");
            nums.setText("");
        } else if (duplicateCheck()) {
            System.out.println("Duplicate Exist");
        } else {
            try {
                dbConnector dbc = new dbConnector();
                String pass = passwordHasher.hashPassword(ps.getText());

                dbc.updateData("UPDATE tbl SET u_fname = '" + fn.getText() + "', u_lname = '" + ln.getText() + "', u_email = '" + em.getText() + "', u_username = '" + us.getText() +
                        "', Number = '" + nums.getText() + "', u_type = '" + type.getSelectedItem() + "', u_status ='" + stats.getSelectedItem() + "', u_image ='" + destination + "' WHERE u_id = '" + id.getText() + "'");
                if (destination.isEmpty()) {
                    File existingFile = new File(oldpath);
                    if (existingFile.exists()) {
                        existingFile.delete();
                    }
                } else {
                    if (!(oldpath.equals(path))) {
                        imageUpdater(oldpath, path);
                    }
                }
                close();
            } catch (SQLException | NoSuchAlgorithmException ex) {
                JOptionPane.showMessageDialog(null, "Error occurred while updating user: " + ex.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "No Action Selected!");
        close();
    }
    }//GEN-LAST:event_labelActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        image.setIcon(null);
        destination="";
        path="";
    }//GEN-LAST:event_removeActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userimages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();
                                               
            if(FileExistenceChecker(path) == 1){
                JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                destination = "";
                path="";
            }else{
                image.setIcon(ResizeImage(path, null, image));
                select.setEnabled(false);
                remove.setEnabled(true);
            }
            } catch (Exception ex) {
                        System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectActionPerformed

    
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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JTextField id;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton label;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField nums;
    public javax.swing.JPasswordField ps;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    private javax.swing.JLabel stat;
    public javax.swing.JComboBox<String> stats;
    public javax.swing.JComboBox<String> type;
    public javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
