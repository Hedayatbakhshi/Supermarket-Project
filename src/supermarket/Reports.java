/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author android1
 */
public class Reports extends javax.swing.JFrame {

    /**
     * Creates new form PurchasesReport
     */
    public Reports() {
        initComponents();
        setResizable(false);
        loadPurchasesReport();

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Object selectedObj = jComboBox2.getSelectedItem();
                if (selectedObj == null) {
                    return; // This prevents NullPointerException
                }
                String selected = selectedObj.toString();
                switch (selected) {
                    case "Purchases":
                        loadPurchasesReport();
                        break;
                    case "Customers":
                        loadCustomersReport();
                        break;
                    case "Products":
                        loadProductsReport();
                        break;
                }
            }
        });
    }

    private void exportTableToCSV(javax.swing.JTable table, String fileName) {
        try (java.io.FileWriter fw = new java.io.FileWriter(fileName)) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            // Write header
            for (int i = 0; i < model.getColumnCount(); i++) {
                fw.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    fw.write(",");
                }
            }
            fw.write("\n");
            // Write data
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    fw.write(value != null ? value.toString() : "");
                    if (col < model.getColumnCount() - 1) {
                        fw.write(",");
                    }
                }
                fw.write("\n");
            }
            fw.flush();
            javax.swing.JOptionPane.showMessageDialog(this, "CSV exported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Export failed: " + e.getMessage());
        }
    }

    private void exportTableToExcel(javax.swing.JTable table, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Write header
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }

        // Write data rows
        for (int rowIdx = 0; rowIdx < model.getRowCount(); rowIdx++) {
            Row row = sheet.createRow(rowIdx + 1);
            for (int colIdx = 0; colIdx < model.getColumnCount(); colIdx++) {
                Cell cell = row.createCell(colIdx);
                Object value = model.getValueAt(rowIdx, colIdx);
                cell.setCellValue(value != null ? value.toString() : "");
            }
        }

        try (FileOutputStream out = new FileOutputStream(fileName)) {
            workbook.write(out);
            workbook.close();
            javax.swing.JOptionPane.showMessageDialog(this, "Exported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Export failed: " + e.getMessage());
        }
    }

    private void loadPurchasesReport() {
        // Define columns for your JTable
        String[] columns = {"Customer ID", "Customer", "Product", "Quantity", "Total Cost", "Purchase Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        DAL d = new DAL();
        Object[][] data = d.select(
                "SELECT u.user_id, u.username, p.product_name, s.quantity, s.total_cost, s.purchase_date "
                + "FROM purchases s "
                + "JOIN users u ON s.user_id = u.user_id "
                + "JOIN products p ON s.product_id = p.product_id "
                + "ORDER BY s.purchase_date DESC"
        );

        for (Object[] row : data) {
            model.addRow(row);
        }

        jTable1.setModel(model);
    }

    private void loadCustomersReport() {
        String[] columns = {"Customer ID", "Username", "Email", "Gender", "Contact Number", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        DAL d = new DAL();
        Object[][] data = d.select(
                "SELECT user_id, username, email, gender, contact_number, balance FROM users"
        );
        for (Object[] row : data) {
            model.addRow(row);
        }
        jTable1.setModel(model);
    }

    private void loadProductsReport() {
        String[] columns = {"Product ID", "Product Name", "Unit Price", "Category", "Product Date", "Expire Date", "Unit"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        DAL d = new DAL();
        Object[][] data = d.select(
                "SELECT product_id, product_name, unit_price, category, product_date, expire_date, unit FROM products"
        );
        for (Object[] row : data) {
            model.addRow(row);
        }
        jTable1.setModel(model);
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        home_report = new javax.swing.JLabel();
        ComboBoxsave = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        savebtnFile = new javax.swing.JButton();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1440, 480));

        jLabel1.setFont(new java.awt.Font("JetBrainsMono NF ExtraBold", 0, 48)); // NOI18N
        jLabel1.setText("Reports");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 210, 120));

        home_report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-reports-100.png"))); // NOI18N
        home_report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_reportMouseClicked(evt);
            }
        });
        jPanel1.add(home_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, 140));

        ComboBoxsave.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        ComboBoxsave.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excel", "CSV" }));
        ComboBoxsave.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(ComboBoxsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 230, -1));

        jLabel11.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel11.setText("Filter By:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel16.setFont(new java.awt.Font("JetBrains Mono", 1, 20)); // NOI18N
        jLabel16.setText("Save file to:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, 30));

        jComboBox2.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Purchases", "Customers", "Products" }));
        jComboBox2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 230, -1));

        savebtnFile.setFont(new java.awt.Font("JetBrains Mono", 0, 20)); // NOI18N
        savebtnFile.setText("Save");
        savebtnFile.setBorder(new javax.swing.border.MatteBorder(null));
        savebtnFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savebtnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnFileActionPerformed(evt);
            }
        });
        jPanel1.add(savebtnFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 110, 40));

        back.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-back-48 (1).png"))); // NOI18N
        back.setText("Back");
        back.setBorder(new javax.swing.border.MatteBorder(null));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 120, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void home_reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_reportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_home_reportMouseClicked

    private void savebtnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnFileActionPerformed
        // Create a new file chooser
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Save Report");

        // Set up file filters based on the selected type
        if (ComboBoxsave.getSelectedItem().equals("Excel")) {
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx"));
        } else if (ComboBoxsave.getSelectedItem().equals("CSV")) {
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV Files (*.csv)", "csv"));
        }

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            String path = fileToSave.getAbsolutePath();

            // Add file extension if not present
            String selectedType = ComboBoxsave.getSelectedItem().toString();
            if (selectedType.equals("Excel")) {
                if (!path.toLowerCase().endsWith(".xlsx")) {
                    path += ".xlsx";
                }
                exportTableToExcel(jTable1, path);
            } else if (selectedType.equals("CSV")) {
                if (!path.toLowerCase().endsWith(".csv")) {
                    path += ".csv";
                }
                exportTableToCSV(jTable1, path);
            }
        }
    }//GEN-LAST:event_savebtnFileActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        Helper.Tools.setCenter(this);
    }//GEN-LAST:event_formWindowOpened

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:

        new Dashboard().setVisible(true);
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
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxsave;
    private javax.swing.JLabel back;
    private javax.swing.JLabel home_report;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton savebtnFile;
    // End of variables declaration//GEN-END:variables
}
