/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nhom4.ui;

import com.nhom4.utils.Auth;
import com.nhom4.utils.MsgBox;
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
import com.nhom4.ui.DangNhap;
import javax.swing.ImageIcon;

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
//        setBackground(new Color(0,0,0,0));

    }
    private int img = 0;

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
        lblNCC = new javax.swing.JLabel();
        lblSP = new javax.swing.JLabel();
        lblKH = new javax.swing.JLabel();
        lblHD = new javax.swing.JLabel();
        lblKM = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTK = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblSetting1 = new javax.swing.JLabel();
        lblSetting2 = new javax.swing.JLabel();
        pnlSetting = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new jPanelGradient();
        lblDongHo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        pnlCardPane = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        lblBanner1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NHÓM 4");
        setUndecorated(true);
        setOpacity(0.0F);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/profile (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        lblTen.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        lblTen.setForeground(new java.awt.Color(255, 255, 255));
        lblTen.setText("Name");
        jPanel2.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setText("Admin");
        jPanel2.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bg2.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 200));

        lblNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNCC.setForeground(new java.awt.Color(255, 255, 255));
        lblNCC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/factory.png"))); // NOI18N
        lblNCC.setText("Nhà Cung Cấp");
        lblNCC.setToolTipText("");
        lblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNCCMouseClicked(evt);
            }
        });
        jPanel2.add(lblNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 140, 40));

        lblSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSP.setForeground(new java.awt.Color(255, 255, 255));
        lblSP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/sport-shoe.png"))); // NOI18N
        lblSP.setText("   SẢN PHẨM");
        lblSP.setToolTipText("");
        lblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSPMouseClicked(evt);
            }
        });
        jPanel2.add(lblSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 140, 40));

        lblKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKH.setForeground(new java.awt.Color(255, 255, 255));
        lblKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/customer.png"))); // NOI18N
        lblKH.setText("   KHÁCH HÀNG");
        lblKH.setToolTipText("");
        lblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKHMouseClicked(evt);
            }
        });
        jPanel2.add(lblKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 140, 40));

        lblHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHD.setForeground(new java.awt.Color(255, 255, 255));
        lblHD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/invoice.png"))); // NOI18N
        lblHD.setText("   HÓA ĐƠN");
        lblHD.setToolTipText("");
        lblHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHDMouseClicked(evt);
            }
        });
        jPanel2.add(lblHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 140, 40));

        lblKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKM.setForeground(new java.awt.Color(255, 255, 255));
        lblKM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/tag.png"))); // NOI18N
        lblKM.setText("KHUYẾN MÃI");
        lblKM.setToolTipText("");
        lblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKMMouseClicked(evt);
            }
        });
        jPanel2.add(lblKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 140, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/power.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 730, 40, 40));

        lblTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTK.setForeground(new java.awt.Color(255, 255, 255));
        lblTK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bar-chart.png"))); // NOI18N
        lblTK.setText("   THỐNG KÊ");
        lblTK.setToolTipText("");
        lblTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTKMouseClicked(evt);
            }
        });
        jPanel2.add(lblTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 140, 30));

        lblNhanVien.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/identity-card.png"))); // NOI18N
        lblNhanVien.setText("Nhân Viên");
        lblNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNhanVienMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblNhanVienMouseReleased(evt);
            }
        });
        jPanel2.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 140, 40));

        lblSetting1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/cogwheel.png"))); // NOI18N
        lblSetting1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSetting1MouseClicked(evt);
            }
        });
        jPanel2.add(lblSetting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 730, 40, 40));

        lblSetting2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetting2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/cogwheel.png"))); // NOI18N
        lblSetting2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSetting2MouseClicked(evt);
            }
        });
        jPanel2.add(lblSetting2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 730, 40, 40));

        pnlSetting.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(107, 107, 107));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/logout3.png"))); // NOI18N
        jLabel4.setText("QUAN LY TAI KHOAN");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(107, 107, 107));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/logout3.png"))); // NOI18N
        jLabel8.setText("DOI MAT KHAU");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(107, 107, 107));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/logout3.png"))); // NOI18N
        jLabel9.setText("DANG XUAT SEVER EARTH");

        javax.swing.GroupLayout pnlSettingLayout = new javax.swing.GroupLayout(pnlSetting);
        pnlSetting.setLayout(pnlSettingLayout);
        pnlSettingLayout.setHorizontalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlSettingLayout.setVerticalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(pnlSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 200, 140));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 879));

        lblDongHo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDongHo.setText("00 : 00 : 00");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/home-icon-silhouette.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        lblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/account.png"))); // NOI18N
        lblTaiKhoan.setText("Tai Khoan");
        lblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(671, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 0, 1290, 80));

        pnlCardPane.setLayout(new java.awt.CardLayout());

        pnlHome.setBackground(new java.awt.Color(255, 255, 255));
        pnlHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlHome.setPreferredSize(new java.awt.Dimension(1280, 669));
        pnlHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBanner1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/a1.png"))); // NOI18N
        pnlHome.add(lblBanner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bn2.png"))); // NOI18N
        pnlHome.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, -1, 469));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bn3.png"))); // NOI18N
        pnlHome.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, -1, -1));

        pnlCardPane.add(pnlHome, "card2");

        jPanel1.add(pnlCardPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 79, 1290, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1518, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void changePanel(JPanel pn) {
        pnlCardPane.removeAll();
        pnlCardPane.add(pn);
        pnlCardPane.repaint();
        pnlCardPane.revalidate();
    }

    private void lblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMouseClicked
        openSanPham();
    }//GEN-LAST:event_lblSPMouseClicked

    private void lblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKHMouseClicked
        openKhachHang();
    }//GEN-LAST:event_lblKHMouseClicked

    private void lblHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHDMouseClicked
        openHoaDon();
    }//GEN-LAST:event_lblHDMouseClicked

    private void lblNCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMouseClicked
        openNCC();
    }//GEN-LAST:event_lblNCCMouseClicked

    private void lblKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKMMouseClicked
        openKhuyenMai();
    }//GEN-LAST:event_lblKMMouseClicked

    private void lblTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTKMouseClicked
        openThongKe();
    }//GEN-LAST:event_lblTKMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        changePanel(pnlHome);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void lblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseClicked
        opennhanvien();
    }//GEN-LAST:event_lblNhanVienMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            Float f = Float.valueOf(val);
            this.setOpacity(f);

            try {
                Thread.sleep(50);
                //i=0;
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Thoat();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void lblSetting1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSetting1MouseClicked
        pnlSetting.setVisible(true);
        lblSetting2.setVisible(true);
        lblSetting2.setEnabled(true);
        lblSetting1.setVisible(false);
        lblSetting1.setEnabled(false);
    }//GEN-LAST:event_lblSetting1MouseClicked

    private void lblSetting2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSetting2MouseClicked
        pnlSetting.setVisible(false);
        lblSetting2.setVisible(false);
        lblSetting2.setEnabled(false);
        lblSetting1.setVisible(true);
        lblSetting1.setEnabled(true);
    }//GEN-LAST:event_lblSetting2MouseClicked

    private void lblNhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseEntered
        lblNhanVien.setForeground(new Color(235, 176, 30));
        lblNhanVien.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\identity-card2.png"));
    }//GEN-LAST:event_lblNhanVienMouseEntered

    private void lblNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseExited
        lblNhanVien.setForeground(Color.WHITE);
        lblNhanVien.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\identity-card.png"));
    }//GEN-LAST:event_lblNhanVienMouseExited

    private void lblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMousePressed
        lblNhanVien.setForeground(Color.black);
        lblNhanVien.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\identity-card2.png"));
    }//GEN-LAST:event_lblNhanVienMousePressed

    private void lblNhanVienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseReleased
        lblNhanVien.setForeground(Color.WHITE);
        lblNhanVien.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\identity-card2.png"));
    }//GEN-LAST:event_lblNhanVienMouseReleased

    private void lblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseClicked
        opendTaiKhoanQL();
    }//GEN-LAST:event_lblTaiKhoanMouseClicked

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
        pnlSetting.setVisible(false);
        pnlSetting.setEnabled(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(XImage.getAppIcon());
//        new ChaoJDialog(this, true).setVisible(true);
        new DangNhap(this, true).setVisible(true);

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat("hh:mm;ss a");
                String text = formater.format(now);
                lblDongHo.setText(text);
            }
        }).start();
        bner();

    }

    public void bner() {
        new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                img++;
                lblBanner1.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\a" + img + ".png"));
                if (img == 3) {
                    img = 0;
                }

            }
        }).start();

    }

    public void opendTaiKhoanQL() {
        if (Auth.islogin()) {
            if (!Auth.isManager()) {
                TaiKhoanCaNhan tkcn = new TaiKhoanCaNhan();
                changePanel(tkcn);
            } else {
                TaiKhoanQL tkql = new TaiKhoanQL();
                changePanel(tkql);
            }
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void opennhanvien() {
        if (Auth.islogin()) {
            if (!Auth.isManager()) {
                MsgBox.alert(this, "Ban khong co quyen xem nhan vien");
            } else {
                NhanVien1 nv = new NhanVien1();
                changePanel(nv);
            }
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void openNCC() {
        if (Auth.islogin()) {
            NhaCungCap1 nc = new NhaCungCap1();
            changePanel(nc);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void openHoaDon() {
        if (Auth.islogin()) {
            HoaDon1 hd = new HoaDon1();
            changePanel(hd);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void openKhuyenMai() {
        if (Auth.islogin()) {
            KhuyenMai1 km = new KhuyenMai1();
            changePanel(km);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void openSanPham() {
        if (Auth.islogin()) {
            SanPham1 sp = new SanPham1();
            changePanel(sp);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void openKhachHang() {
        if (Auth.islogin()) {
            KhachHang1 kh = new KhachHang1();
            changePanel(kh);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void openThongKe() {
        if (Auth.islogin()) {
            ThongKe tK = new ThongKe();
            changePanel(tK);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }
    
    public void Thoat(){
        boolean thoat = MsgBox.confirm(this, "Bạn có thực sự muốn thoát không?");
        if(thoat == true){
            System.exit(0);
        } else if(thoat == false){
            return;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblBanner1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblHD;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblKM;
    private javax.swing.JLabel lblNCC;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblSP;
    private javax.swing.JLabel lblSetting1;
    private javax.swing.JLabel lblSetting2;
    private javax.swing.JLabel lblTK;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblTen;
    private javax.swing.JPanel pnlCardPane;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlSetting;
    // End of variables declaration//GEN-END:variables
}
