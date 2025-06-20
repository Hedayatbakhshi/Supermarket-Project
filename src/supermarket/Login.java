/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import org.mindrot.jbcrypt.BCrypt;


/**
 * @author android1
 */
public class Login extends javax.swing.JFrame {

    private DAL dal = new DAL();

    int loginAttempt = 1;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        setResizable(false);

        //--------------------delete whole password from passwordField in login--------------------
        txtPassword.getInputMap().put(KeyStroke.getKeyStroke("ctrl BACK_SPACE"), "delete-previous-word");
        txtPassword.getActionMap().put("delete-previous-word", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int caretPos = txtPassword.getCaretPosition();
                    String text = new String(txtPassword.getPassword());

                    if (caretPos == 0) {
                        return;
                    }

                    int deleteFrom = caretPos - 1;
                    while (deleteFrom > 0 && Character.isWhitespace(text.charAt(deleteFrom))) {
                        deleteFrom--;
                    }
                    while (deleteFrom > 0 && !Character.isWhitespace(text.charAt(deleteFrom - 1))) {
                        deleteFrom--;
                    }

                    StringBuilder sb = new StringBuilder(text);
                    sb.delete(deleteFrom, caretPos);
                    txtPassword.setText(sb.toString());
                    txtPassword.setCaretPosition(deleteFrom);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        );
    }

    // ---------------------- HELPER FUNCTION --------------------------
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    // ---------------------- LOGIN FUNCTION --------------------------
    private void login() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            lbl_Password_Wrong.setText("Please enter both Username and Password.");
            return;
        }

        String sql = "SELECT password FROM users WHERE username = ?";

        try (PreparedStatement pstm = dal.getConnection().prepareStatement(sql)) {
            pstm.setString(1, username);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password");
                    if (BCrypt.checkpw(password, storedHash)) {
                        // Password matches, login success
                        this.setVisible(false);
                        new Dashboard(username).setVisible(true);
                        return;
                    }
                }
                // If we reach here: either wrong password or username not found
                lbl_Password_Wrong.setText("Your Username or Password is incorrect!");
                loginAttempt++;
                if (loginAttempt > 3) {
                    Helper.Tools.show("Too many failed attempts. Exiting...");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //-----------------------------------------------Reset password--------------------------------------------------------------------
//    private void openResetPasswordDialog() {
//        JTextField usernameField = new JTextField();
//        JPasswordField newPasswordField = new JPasswordField();
//        JPasswordField confirmPasswordField = new JPasswordField();
//
//        Object[] message = {
//                "Username:", usernameField,
//                "New Password:", newPasswordField,
//                "Confirm Password:", confirmPasswordField
//        };
//
//        int option = JOptionPane.showConfirmDialog(this, message, "Reset Password", JOptionPane.OK_CANCEL_OPTION);
//
//        if (option == JOptionPane.OK_OPTION) {
//            String username = usernameField.getText().trim();
//            String newPassword = new String(newPasswordField.getPassword());
//            String confirmPassword = new String(confirmPasswordField.getPassword());
//
//            if (!newPassword.equals(confirmPassword)) {
//                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            if (username.isEmpty() || newPassword.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            resetPassword(username, newPassword);
//        }
//    }
    //-----------------------------------------Helper reset Password-------------------------------------------------------------
    private void resetPassword(String username, String newPassword) {
        // Generate a bcrypt hash of the new password
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        try {
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            try (PreparedStatement pstm = dal.getConnection().prepareStatement(sql)) {
                pstm.setString(1, hashedPassword);
                pstm.setString(2, username);

                int rowsUpdated = pstm.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Password updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Username not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkbox_showpassword = new javax.swing.JCheckBox();
        btnExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_Password_Wrong = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wired-outline-21-avatar-morph-group (1).gif"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 120, 100));

        jLabel7.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        txtUsername.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        txtUsername.setOpaque(true);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 300, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wired-gradient-268-avatar-man-hover-nodding.gif"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 70, 90));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wired-outline-946-equity-security-hover-locked.gif"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 70, 80));

        txtPassword.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 300, 50));

        jLabel8.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Show Password:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 170, -1));

        checkbox_showpassword.setFont(new java.awt.Font("Monda", 0, 24)); // NOI18N
        checkbox_showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_showpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(checkbox_showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 30, 50));

        btnExit.setBackground(new java.awt.Color(255, 102, 153));
        btnExit.setFont(new java.awt.Font("JetBrains Mono", 1, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Reset");
        btnExit.setBorder(new javax.swing.border.MatteBorder(null));
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 530, 170, 40));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Don't have an account? Sign up");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, 360, 50));

        lbl_Password_Wrong.setFont(new java.awt.Font("JetBrains Mono", 1, 16)); // NOI18N
        lbl_Password_Wrong.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_Password_Wrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 420, 40));

        btnLogin.setBackground(new java.awt.Color(0, 123, 255));
        btnLogin.setFont(new java.awt.Font("JetBrains Mono", 1, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(new javax.swing.border.MatteBorder(null));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginKeyPressed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, 170, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Helper.Tools.setCenter(this);
    }//GEN-LAST:event_formWindowOpened

    private void checkbox_showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_showpasswordActionPerformed
        // TODO add your handling code here:

        if (checkbox_showpassword.isSelected()) {
            // Show password
            txtPassword.setEchoChar((char) 0);
        } else {
            // Hide password
            txtPassword.setEchoChar('\u2022'); // default bullet char, or use '*'
        }
    }//GEN-LAST:event_checkbox_showpasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        new UserAdd().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        txtUsername.setText("");
        txtPassword.setText("");
        lbl_Password_Wrong.setText("");
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    // ---------------------- MAIN --------------------------
    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Log any Look and Feel setup issues without crashing
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.WARNING, "Failed to set Nimbus look and feel", e);
        }

        // Launch the Login form
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox checkbox_showpassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Password_Wrong;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
