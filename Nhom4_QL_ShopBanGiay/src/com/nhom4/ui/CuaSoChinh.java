/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nhom4.ui;

import com.nhom4.utils.XImage;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ACER
 */
public class CuaSoChinh extends javax.swing.JFrame {

    /**
     * Creates new form CuaSoChinh
     */
    public CuaSoChinh() {
        initComponents();
        init();
        
    }

    class jPanelGradient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(58, 136, 145);
            Color color2 = new Color(71, 78, 104);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new jPanelGradient();
        jLabel1 = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblNCC = new javax.swing.JLabel();
        lblSP = new javax.swing.JLabel();
        lblKH = new javax.swing.JLabel();
        lblHD = new javax.swing.JLabel();
        lblTK = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jPanel4 = new jPanelGradient();
        pnlCardPane = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/profile (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        lblTen.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblTen.setForeground(new java.awt.Color(255, 255, 255));
        lblTen.setText("Name");
        jPanel2.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setText("Admin");
        jPanel2.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bg2.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 210));

        lblNhanVien.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/identity-card.png"))); // NOI18N
        lblNhanVien.setText("   NHÂN VIÊN");
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
        });
        jPanel2.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 260, 60));

        lblNCC.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblNCC.setForeground(new java.awt.Color(255, 255, 255));
        lblNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/factory.png"))); // NOI18N
        lblNCC.setText("   NHÀ CUNG CẤP");
        lblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNCCMouseClicked(evt);
            }
        });
        jPanel2.add(lblNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 260, 60));

        lblSP.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblSP.setForeground(new java.awt.Color(255, 255, 255));
        lblSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/product.png"))); // NOI18N
        lblSP.setText("   SẢN PHẨM");
        lblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSPMouseClicked(evt);
            }
        });
        jPanel2.add(lblSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 260, 60));

        lblKH.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblKH.setForeground(new java.awt.Color(255, 255, 255));
        lblKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/target.png"))); // NOI18N
        lblKH.setText("   KHÁCH HÀNG");
        lblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKHMouseClicked(evt);
            }
        });
        jPanel2.add(lblKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 260, 60));

        lblHD.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblHD.setForeground(new java.awt.Color(255, 255, 255));
        lblHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/invoice.png"))); // NOI18N
        lblHD.setText("   HÓA ĐƠN");
        lblHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHDMouseClicked(evt);
            }
        });
        jPanel2.add(lblHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 260, 60));

        lblTK.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lblTK.setForeground(new java.awt.Color(255, 255, 255));
        lblTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/statistics.png"))); // NOI18N
        lblTK.setText("   THỐNG KÊ");
        lblTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTKMouseClicked(evt);
            }
        });
        jPanel2.add(lblTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 260, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/account.png"))); // NOI18N
        jLabel3.setText("Tai Khoan");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 260, 70));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/power.png"))); // NOI18N
        jLabel10.setText("Thoat");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 260, 70));

        lblDongHo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDongHo.setText("00 : 00 : 00");
        jPanel2.add(lblDongHo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 270, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 879));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 0, 1290, 60));

        pnlCardPane.setLayout(new java.awt.CardLayout());

        pnlHome.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pnlCardPane.add(pnlHome, "card2");

        jPanel1.add(pnlCardPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 64, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void changePanel(JPanel pn){
        pnlCardPane.removeAll();
        pnlCardPane.add(pn);
        pnlCardPane.repaint();
        pnlCardPane.revalidate();
    }
    
    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        NhanVien1 nv = new NhanVien1();
        changePanel(nv);
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void lblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMouseClicked
        SanPham1 sp = new SanPham1();
        changePanel(sp);
    }//GEN-LAST:event_lblSPMouseClicked

    private void lblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKHMouseClicked
        KhachHang1 kh = new KhachHang1();
        changePanel(kh);
    }//GEN-LAST:event_lblKHMouseClicked

    private void lblHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHDMouseClicked
       HoaDon1 hd = new HoaDon1();
        changePanel(hd);
    }//GEN-LAST:event_lblHDMouseClicked

    private void lblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMouseClicked
        NhaCungCap1 nc = new NhaCungCap1();
        changePanel(nc);
    }//GEN-LAST:event_lblNCCMouseClicked

    private void lblTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTKMouseClicked
        ThongKe tK = new ThongKe();
        changePanel(tK);
    }//GEN-LAST:event_lblTKMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        TaiKhoanQL tkql = new TaiKhoanQL();
        changePanel(tkql);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuaSoChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CuaSoChinh().setVisible(true);
            }
        });
    }

    private void init() {
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
//        new ChaoJDialog(this, true).setVisible(true);
//        new DangNhap(this, true).setVisible(true);
//        new DoiMatKhau(this, true).setVisible(true);
        
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("hh:mm;ss a");
                String text = formater.format(now);
                lblDongHo.setText(text);
            }
        }).start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblHD;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblNCC;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblTK;
    private javax.swing.JLabel lblTen;
    private javax.swing.JPanel pnlCardPane;
    private javax.swing.JPanel pnlHome;
    // End of variables declaration//GEN-END:variables
}

