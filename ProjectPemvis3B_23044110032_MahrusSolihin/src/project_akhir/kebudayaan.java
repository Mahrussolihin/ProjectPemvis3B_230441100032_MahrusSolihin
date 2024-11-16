/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project_akhir;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import javax.swing.ImageIcon;
/**
 *
 * @author USER
 */
public class kebudayaan extends javax.swing.JFrame {
    private int selectedId;
    Connection conn;
    /**
     * Creates new form kebudayaan
     */
    public kebudayaan() {
        initComponents();
        conn = koneksi.getConnection();
        
        loadDataKebudayaan();
        loadDataEvent();
    }

    private void loadDataKebudayaan() {
        try {
            String sql = "SELECT * FROM keragaman";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                selectedId = rs.getInt("id");
                byte[] imageData = rs.getBytes("gambar");
                if (imageData != null){
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    Image scaledImage = imageIcon.getImage().getScaledInstance(lbl_gambar_budaya.getWidth(), lbl_gambar_budaya.getHeight(), Image.SCALE_SMOOTH);
                    lbl_gambar_budaya.setIcon(new ImageIcon(scaledImage));
                } else {
                    lbl_gambar_budaya.setIcon(null);
                }
                String artikel = rs.getString("artikel");
                txtarea_budaya.setText(artikel);
            }
        } catch (SQLException e){
            System.out.println("Error Load Data :" + e.getMessage());
        }
    }
    
    private void loadDataEvent() {
        try {
            String sql = "SELECT * FROM event ORDER BY id DESC LIMIT 3";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                byte[] imageData1 = rs.getBytes("gambar");
                if (imageData1 != null) {
                    ImageIcon imageIcon1 = new ImageIcon(imageData1);
                    Image scaledImage1 = imageIcon1.getImage().getScaledInstance(lbl_event1.getWidth(), lbl_event1.getHeight(), Image.SCALE_SMOOTH);
                    lbl_event1.setIcon(new ImageIcon(scaledImage1));
                } else {
                    lbl_event1.setIcon(null);
                }
                String jadwal1 = rs.getString("jadwal");
                txtarea_event1.setText(jadwal1);
            }

            if (rs.next()) {
                byte[] imageData2 = rs.getBytes("gambar");
                if (imageData2 != null) {
                    ImageIcon imageIcon2 = new ImageIcon(imageData2);
                    Image scaledImage2 = imageIcon2.getImage().getScaledInstance(lbl_event2.getWidth(), lbl_event2.getHeight(), Image.SCALE_SMOOTH);
                    lbl_event2.setIcon(new ImageIcon(scaledImage2));
                } else {
                    lbl_event2.setIcon(null);
                }
                String jadwal2 = rs.getString("jadwal");
                txtarea_event2.setText(jadwal2);
            }

            if (rs.next()) {
                byte[] imageData3 = rs.getBytes("gambar");
                if (imageData3 != null) {
                    ImageIcon imageIcon3 = new ImageIcon(imageData3);
                    Image scaledImage3 = imageIcon3.getImage().getScaledInstance(lbl_event3.getWidth(), lbl_event3.getHeight(), Image.SCALE_SMOOTH);
                    lbl_event3.setIcon(new ImageIcon(scaledImage3));
                } else {
                    lbl_event3.setIcon(null);
                }
                String jadwal3 = rs.getString("jadwal");
                txtarea_event3.setText(jadwal3);
            }
        } catch (SQLException e){
            System.out.println("Error Load Data :" + e.getMessage());
        }
    }
    
    private void SeacrchDataKebudayaan() {
        String cari = tf_pencarian_budaya.getText();
        try {
            String sql = "SELECT * FROM keragaman WHERE judul LIKE '%"+cari+"%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                selectedId = rs.getInt("id");
                byte[] imageData = rs.getBytes("gambar");
                if (imageData != null){
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    Image scaledImage = imageIcon.getImage().getScaledInstance(lbl_gambar_budaya.getWidth(), lbl_gambar_budaya.getHeight(), Image.SCALE_SMOOTH);
                    lbl_gambar_budaya.setIcon(new ImageIcon(scaledImage));
                } else {
                    lbl_gambar_budaya.setIcon(null);
                }
                String artikel = rs.getString("artikel");
                txtarea_budaya.setText(artikel);
            }
        } catch (SQLException e){
            System.out.println("Error Load Data :" + e.getMessage());
        }
    }
    
    private void SeacrchDataEvent() {
        String cari = tf_pencarian_event.getText();
        try {
            String sql = "SELECT * FROM event WHERE judul LIKE '%"+cari+"%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                selectedId = rs.getInt("id");
                byte[] imageData = rs.getBytes("gambar");
                if (imageData != null){
                    ImageIcon imageIcon = new ImageIcon(imageData);
                    Image scaledImage = imageIcon.getImage().getScaledInstance(lbl_event1.getWidth(), lbl_event1.getHeight(), Image.SCALE_SMOOTH);
                    lbl_event1.setIcon(new ImageIcon(scaledImage));
                } else {
                    lbl_event1.setIcon(null);
                }
                String jadwal = rs.getString("jadwal");
                txtarea_event1.setText(jadwal);
            }
        } catch (SQLException e){
            System.out.println("Error Load Data :" + e.getMessage());
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btn_logout_budaya = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_gambar_budaya = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_budaya = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        btn_selengkapnya = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_cari_budaya = new javax.swing.JButton();
        tf_pencarian_budaya = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btn_logout_event = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_event1 = new javax.swing.JLabel();
        lbl_event2 = new javax.swing.JLabel();
        lbl_event3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtarea_event1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtarea_event2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_event3 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        btn_hapus_event = new javax.swing.JButton();
        btn_update_event = new javax.swing.JButton();
        btn_create_event = new javax.swing.JButton();
        btn_cari_event = new javax.swing.JButton();
        tf_pencarian_event = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 510));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(600, 509));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        btn_logout_budaya.setBackground(new java.awt.Color(255, 0, 0));
        btn_logout_budaya.setText("Logout");
        btn_logout_budaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout_budayaActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        lbl_gambar_budaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_gambar_budaya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wayang.jpg"))); // NOI18N
        lbl_gambar_budaya.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(lbl_gambar_budaya);

        txtarea_budaya.setEditable(false);
        txtarea_budaya.setBackground(new java.awt.Color(255, 255, 255));
        txtarea_budaya.setColumns(20);
        txtarea_budaya.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtarea_budaya.setRows(5);
        txtarea_budaya.setText("wayang kulit");
        jScrollPane1.setViewportView(txtarea_budaya);

        jPanel4.add(jScrollPane1);

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));
        jPanel5.setLayout(new java.awt.GridLayout(1, 3));

        btn_selengkapnya.setBackground(new java.awt.Color(0, 255, 0));
        btn_selengkapnya.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_selengkapnya.setText("Selengkapnya");
        btn_selengkapnya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selengkapnyaActionPerformed(evt);
            }
        });
        jPanel5.add(btn_selengkapnya);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setText("KEBUDAYAAN INDONESIA");

        btn_cari_budaya.setText("Cari");
        btn_cari_budaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_budayaActionPerformed(evt);
            }
        });

        tf_pencarian_budaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pencarian_budayaActionPerformed(evt);
            }
        });
        tf_pencarian_budaya.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pencarian_budayaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_cari_budaya, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_pencarian_budaya, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout_budaya)
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel3)
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_logout_budaya)
                    .addComponent(btn_cari_budaya)
                    .addComponent(tf_pencarian_budaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Budaya", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        btn_logout_event.setBackground(new java.awt.Color(255, 0, 0));
        btn_logout_event.setText("Logout");
        btn_logout_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout_eventActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setText("EVENT KEBUDAYAAN");

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));
        jPanel6.setLayout(new java.awt.GridLayout(2, 3));

        lbl_event1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Selamatan-Buka-Giling-Wayang-Kul.jpg"))); // NOI18N
        lbl_event1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_event1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_event1MouseClicked(evt);
            }
        });
        jPanel6.add(lbl_event1);

        lbl_event2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/festival-ogoh-ogoh-bali.png"))); // NOI18N
        lbl_event2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_event2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_event2MouseClicked(evt);
            }
        });
        jPanel6.add(lbl_event2);

        lbl_event3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Lompat-Batu-Nias.jpg"))); // NOI18N
        lbl_event3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_event3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_event3MouseClicked(evt);
            }
        });
        jPanel6.add(lbl_event3);

        txtarea_event1.setEditable(false);
        txtarea_event1.setBackground(new java.awt.Color(255, 255, 255));
        txtarea_event1.setColumns(20);
        txtarea_event1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtarea_event1.setRows(5);
        txtarea_event1.setText("selamatan");
        txtarea_event1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtarea_event1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(txtarea_event1);

        jPanel6.add(jScrollPane4);

        txtarea_event2.setEditable(false);
        txtarea_event2.setBackground(new java.awt.Color(255, 255, 255));
        txtarea_event2.setColumns(20);
        txtarea_event2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtarea_event2.setRows(5);
        txtarea_event2.setText("ogoh-ogoh");
        txtarea_event2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtarea_event2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(txtarea_event2);

        jPanel6.add(jScrollPane3);

        txtarea_event3.setEditable(false);
        txtarea_event3.setBackground(new java.awt.Color(255, 255, 255));
        txtarea_event3.setColumns(20);
        txtarea_event3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtarea_event3.setRows(5);
        txtarea_event3.setText("lompat batu nias");
        txtarea_event3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtarea_event3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txtarea_event3);

        jPanel6.add(jScrollPane2);

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));
        jPanel7.setLayout(new java.awt.GridLayout(1, 3));

        btn_hapus_event.setBackground(new java.awt.Color(255, 0, 0));
        btn_hapus_event.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_hapus_event.setText("Hapus");
        btn_hapus_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_eventActionPerformed(evt);
            }
        });
        jPanel7.add(btn_hapus_event);

        btn_update_event.setBackground(new java.awt.Color(255, 255, 0));
        btn_update_event.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_update_event.setText("Edit");
        btn_update_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_eventActionPerformed(evt);
            }
        });
        jPanel7.add(btn_update_event);

        btn_create_event.setBackground(new java.awt.Color(0, 255, 0));
        btn_create_event.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btn_create_event.setText("Tambah");
        btn_create_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_eventActionPerformed(evt);
            }
        });
        jPanel7.add(btn_create_event);

        btn_cari_event.setText("Cari");
        btn_cari_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cari_eventActionPerformed(evt);
            }
        });

        tf_pencarian_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pencarian_eventActionPerformed(evt);
            }
        });
        tf_pencarian_event.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pencarian_eventKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btn_cari_event, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_pencarian_event, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout_event)
                .addGap(25, 25, 25))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_cari_event)
                        .addComponent(tf_pencarian_event, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_logout_event))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(49, 49, 49)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Event", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 606, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selengkapnyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selengkapnyaActionPerformed
        this.setVisible(false);
        detail_budaya db = new detail_budaya(selectedId);
        db.setVisible(true);
        db.pack();
        db.setLocationRelativeTo(null);
        db.setDefaultCloseOperation(detail_budaya.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btn_selengkapnyaActionPerformed

    private void btn_logout_budayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout_budayaActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION); 
        if (confirm == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            login lg = new login();
            lg.setVisible(true);
            lg.pack();
            lg.setLocationRelativeTo(null);
            lg.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_btn_logout_budayaActionPerformed

    private void btn_cari_budayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_budayaActionPerformed
        SeacrchDataKebudayaan();
    }//GEN-LAST:event_btn_cari_budayaActionPerformed

    private void tf_pencarian_budayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pencarian_budayaActionPerformed
        SeacrchDataKebudayaan();
    }//GEN-LAST:event_tf_pencarian_budayaActionPerformed

    private void tf_pencarian_budayaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pencarian_budayaKeyReleased
        SeacrchDataKebudayaan();
    }//GEN-LAST:event_tf_pencarian_budayaKeyReleased

    private void tf_pencarian_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pencarian_eventActionPerformed
        SeacrchDataEvent();
    }//GEN-LAST:event_tf_pencarian_eventActionPerformed

    private void btn_cari_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cari_eventActionPerformed
        SeacrchDataEvent();
    }//GEN-LAST:event_btn_cari_eventActionPerformed

    private void tf_pencarian_eventKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pencarian_eventKeyReleased
        SeacrchDataEvent();
    }//GEN-LAST:event_tf_pencarian_eventKeyReleased

    private void btn_logout_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout_eventActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout Confirmation", JOptionPane.YES_NO_OPTION); 
        if (confirm == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            login lg = new login();
            lg.setVisible(true);
            lg.pack();
            lg.setLocationRelativeTo(null);
            lg.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_btn_logout_eventActionPerformed

    private void btn_create_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_eventActionPerformed
        this.setVisible(false);
        create_event ce = new create_event();
        ce.setVisible(true);
        ce.pack();
        ce.setLocationRelativeTo(null);
        ce.setDefaultCloseOperation(create_event.EXIT_ON_CLOSE);
    }//GEN-LAST:event_btn_create_eventActionPerformed

    private void btn_update_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_eventActionPerformed
        if (selectedId > 0) {
            this.setVisible(false);
            update_event ue = new update_event(selectedId);
            ue.setVisible(true);
            ue.pack();
            ue.setLocationRelativeTo(null);
            ue.setDefaultCloseOperation(update_event.EXIT_ON_CLOSE);
        } else {
            JOptionPane.showMessageDialog(this, "Silakan pilih event terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_update_eventActionPerformed

    private void btn_hapus_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_eventActionPerformed
        if (selectedId > 0){
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the data?", "Delete Confimation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION){
                try {
                    String sql = "DELETE FROM event WHERE id = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, selectedId);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Data Deleted Successfully");
                    this.setVisible(false);
                
                    kebudayaan kb = new kebudayaan();
                    kb.setVisible(true);
                    kb.pack();
                    kb.setLocationRelativeTo(null);
                    kb.setDefaultCloseOperation(kebudayaan.EXIT_ON_CLOSE);
                } catch(SQLException e){
                    System.out.println("Error Delete Data:" + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btn_hapus_eventActionPerformed

    private void lbl_event1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_event1MouseClicked
        selectedId = getEventIdForLabel(1);
    }//GEN-LAST:event_lbl_event1MouseClicked

    private void lbl_event2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_event2MouseClicked
        selectedId = getEventIdForLabel(2);
    }//GEN-LAST:event_lbl_event2MouseClicked

    private void lbl_event3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_event3MouseClicked
        selectedId = getEventIdForLabel(3);
    }//GEN-LAST:event_lbl_event3MouseClicked

    private void txtarea_event1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtarea_event1MouseClicked
        selectedId = getEventIdForLabel(1);
    }//GEN-LAST:event_txtarea_event1MouseClicked

    private void txtarea_event2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtarea_event2MouseClicked
        selectedId = getEventIdForLabel(2);
    }//GEN-LAST:event_txtarea_event2MouseClicked

    private void txtarea_event3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtarea_event3MouseClicked
        selectedId = getEventIdForLabel(3);
    }//GEN-LAST:event_txtarea_event3MouseClicked
    
    private int getEventIdForLabel(int labelNumber) {
        int eventId = 0;
        try {
            String sql = "SELECT id FROM event ORDER BY id DESC LIMIT 3";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            for (int i = 1; i <= labelNumber; i++) {
                if (rs.next()) {
                    eventId = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Get Event ID: " + e.getMessage());
        }
        return eventId;
    }
    
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
            java.util.logging.Logger.getLogger(kebudayaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kebudayaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kebudayaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kebudayaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kebudayaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari_budaya;
    private javax.swing.JButton btn_cari_event;
    private javax.swing.JButton btn_create_event;
    private javax.swing.JButton btn_hapus_event;
    private javax.swing.JButton btn_logout_budaya;
    private javax.swing.JButton btn_logout_event;
    private javax.swing.JButton btn_selengkapnya;
    private javax.swing.JButton btn_update_event;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_event1;
    private javax.swing.JLabel lbl_event2;
    private javax.swing.JLabel lbl_event3;
    private javax.swing.JLabel lbl_gambar_budaya;
    private javax.swing.JTextField tf_pencarian_budaya;
    private javax.swing.JTextField tf_pencarian_event;
    private javax.swing.JTextArea txtarea_budaya;
    private javax.swing.JTextArea txtarea_event1;
    private javax.swing.JTextArea txtarea_event2;
    private javax.swing.JTextArea txtarea_event3;
    // End of variables declaration//GEN-END:variables
}
