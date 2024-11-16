/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project_akhir;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author USER
 */
public class create_event extends javax.swing.JFrame {
    
    Connection conn;
    /**
     * Creates new form create_event
     */
    public create_event() {
        initComponents();
        conn = koneksi.getConnection();
        
        btn_create_event.addActionListener(e -> saveDataEvent());
    }
    
    private void saveDataEvent(){
        try {
            String sql = "INSERT INTO event (gambar, judul, jadwal) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            String imagePath = tf_create_gambar_event.getText();
            if (imagePath != null) {
                File imageFile = new File(imagePath);
                long fileSize = imageFile.length();
                long maxSize = 10 * 1024 * 1024;
                
                if (fileSize > maxSize) {
                    JOptionPane.showMessageDialog(this, "File size is too large. Please select a smaller file.");
                    return;
                }
                
                FileInputStream fis = new FileInputStream(imageFile);
                byte[] imageData = new byte[(int) imageFile.length()];
                fis.read(imageData);
                fis.close();
                ps.setBytes(1, imageData);
            } else {
                ps.setNull(1, java.sql.Types.LONGVARBINARY);
            }
            
            ps.setString(2, tf_create_judul_event.getText());
            ps.setString(3, txtarea_create_jadwal_event.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Saved Successfully");
        } catch (SQLException e){
            System.out.println("Error Save Data :" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error Reading Image File: " + e.getMessage()); // Tangani file I/O exception
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
        jLabel9 = new javax.swing.JLabel();
        btn_cancel_create_event = new javax.swing.JButton();
        btn_create_event = new javax.swing.JButton();
        lbl_create_gambar_event = new javax.swing.JLabel();
        btn_create_gambar_event = new javax.swing.JButton();
        tf_create_gambar_event = new javax.swing.JTextField();
        lbl_warning_create_event = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_create_jadwal_event = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tf_create_judul_event = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setText("TAMBAH EVENT");

        btn_cancel_create_event.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancel_create_event.setText("Cancel");
        btn_cancel_create_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel_create_eventActionPerformed(evt);
            }
        });

        btn_create_event.setBackground(new java.awt.Color(0, 255, 0));
        btn_create_event.setText("Posting");
        btn_create_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_eventActionPerformed(evt);
            }
        });

        lbl_create_gambar_event.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_create_gambar_event.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        btn_create_gambar_event.setText("...");
        btn_create_gambar_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_gambar_eventActionPerformed(evt);
            }
        });

        tf_create_gambar_event.setEditable(false);

        lbl_warning_create_event.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl_warning_create_event.setForeground(new java.awt.Color(255, 0, 51));
        lbl_warning_create_event.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtarea_create_jadwal_event.setColumns(20);
        txtarea_create_jadwal_event.setRows(5);
        jScrollPane1.setViewportView(txtarea_create_jadwal_event);

        jLabel6.setText("Jadwal");

        jLabel7.setText("Judul");

        jLabel1.setText("Gambar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_warning_create_event, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1))
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(tf_create_gambar_event)
                                            .addGap(18, 18, 18)
                                            .addComponent(btn_create_gambar_event))
                                        .addComponent(lbl_create_gambar_event, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_create_judul_event, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btn_cancel_create_event)
                        .addGap(18, 18, 18)
                        .addComponent(btn_create_event)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_create_gambar_event, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_create_gambar_event)
                            .addComponent(tf_create_gambar_event, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_create_judul_event, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_warning_create_event, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel_create_event)
                    .addComponent(btn_create_event))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_create_gambar_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_gambar_eventActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "webp", "gif", "bmp", "tiff");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            tf_create_gambar_event.setText(path);

            try {
                byte[] img = Files.readAllBytes(selectedFile.toPath());
                ImageIcon imageIcon = new ImageIcon(img);

                int labelWidth =200;
                int labelHeight = 400;

                int imageWidth = imageIcon.getIconWidth();
                int imageHeight = imageIcon.getIconHeight();

                double scaleX = (double) labelWidth / (double) imageWidth;
                double scaleY = (double) labelHeight / (double) imageHeight;
                double scale = Math.min(scaleX, scaleY);

                Image scaledImage = imageIcon.getImage().getScaledInstance((int) (scale * imageWidth), (int) (scale * imageHeight), Image.SCALE_SMOOTH);

                lbl_create_gambar_event.setIcon(new ImageIcon(scaledImage));
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_create_gambar_eventActionPerformed

    private void btn_create_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_eventActionPerformed
        String gambar = tf_create_gambar_event.getText();
        String judul = tf_create_judul_event.getText();
        String artikel = txtarea_create_jadwal_event.getText();

        if (gambar.isEmpty() || judul.isEmpty() || artikel.isEmpty()) {
            lbl_warning_create_event.setText("Data cannot be empty");
            return;
        }
        
        this.setVisible(false);
        kebudayaan kb = new kebudayaan();
        kb.setVisible(true);
        kb.pack();
        kb.setLocationRelativeTo(null);
        kb.setDefaultCloseOperation(kebudayaan.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btn_create_eventActionPerformed

    private void btn_cancel_create_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel_create_eventActionPerformed
        this.setVisible(false);
        kebudayaan kb = new kebudayaan();
        kb.setVisible(true);
        kb.pack();
        kb.setLocationRelativeTo(null);
        kb.setDefaultCloseOperation(kebudayaan.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btn_cancel_create_eventActionPerformed

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
            java.util.logging.Logger.getLogger(create_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(create_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(create_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(create_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new create_event().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel_create_event;
    private javax.swing.JButton btn_create_event;
    private javax.swing.JButton btn_create_gambar_event;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_create_gambar_event;
    private javax.swing.JLabel lbl_warning_create_event;
    private javax.swing.JTextField tf_create_gambar_event;
    private javax.swing.JTextField tf_create_judul_event;
    private javax.swing.JTextArea txtarea_create_jadwal_event;
    // End of variables declaration//GEN-END:variables
}
