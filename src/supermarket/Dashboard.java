/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket;

/**
 * @author android1
 */
public class Dashboard extends javax.swing.JFrame {

    private String loggedInUser;

    /**
     * Creates new form Home
     */
    public Dashboard(String username) {
        this.loggedInUser = username;
        initComponents();

        
    }

    public Dashboard() {
        initComponents();
        
        setResizable(false);
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
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Home_customers = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Home_inventory = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        home_report = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(38, 117, 191));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-customer-96.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 110, 120));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-home-144.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 140, 130));

        jLabel8.setFont(new java.awt.Font("JetBrains Mono", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Users");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 80, 40));

        jLabel10.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-users-96.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 110, 120));

        jLabel11.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Customers");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 120, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Home_customers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-customer-96.png"))); // NOI18N
        Home_customers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home_customersMouseClicked(evt);
            }
        });
        jPanel4.add(Home_customers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 140));

        jLabel14.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel14.setText("Report");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 80, 40));

        Home_inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-in-inventory-100.png"))); // NOI18N
        Home_inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Home_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Home_inventoryMouseClicked(evt);
            }
        });
        jPanel4.add(Home_inventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 110, 140));

        jLabel17.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel17.setText("Customers");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 130, 40));

        jLabel4.setFont(new java.awt.Font("JetBrains Mono", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Back to Login");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 640, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("JetBrains Mono", 1, 30)); // NOI18N
        jLabel12.setText("Supermarket Management System");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 570, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-supermarket-100.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 100, 140));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 200));

        jLabel15.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel15.setText("Inventory");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 120, 40));

        home_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-reports-100.png"))); // NOI18N
        home_report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_reportMouseClicked(evt);
            }
        });
        jPanel4.add(home_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 110, 140));

        back.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-back-48 (1).png"))); // NOI18N
        back.setText("Back to login");
        back.setBorder(new javax.swing.border.MatteBorder(null));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel4.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 630, 200, 60));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 880, 710));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Supermarket 710 height 470 width.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 470, 730));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        Helper.Tools.setCenter(this);

    }//GEN-LAST:event_formWindowOpened

    private void Home_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home_customersMouseClicked
        // TODO add your handling code here:

        new CustomerInformation().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Home_customersMouseClicked

    private void Home_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Home_inventoryMouseClicked
        // TODO add your handling code here:
        new SupermarketInventorySystem(loggedInUser).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Home_inventoryMouseClicked

    private void home_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_reportMouseClicked
        new Reports().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_home_reportMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        
        new Login().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_backMouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Home_customers;
    private javax.swing.JLabel Home_inventory;
    private javax.swing.JLabel back;
    private javax.swing.JLabel home_report;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
