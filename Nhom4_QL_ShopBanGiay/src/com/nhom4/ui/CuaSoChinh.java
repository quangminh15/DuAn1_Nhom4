

package com.nhom4.ui;

import com.nhom4.dao.NhanVienDAO;
import com.nhom4.dao.TaiKhoanDAO;
import com.nhom4.entity.NhanVien;
import com.nhom4.entity.TaiKhoan;
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
       setBackground(new Color(0,0,0,0));

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
        lblAnh = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNCC = new javax.swing.JLabel();
        lblSP = new javax.swing.JLabel();
        lblKH = new javax.swing.JLabel();
        lblHD = new javax.swing.JLabel();
        lblKM = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        lblTK = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblSetting1 = new javax.swing.JLabel();
        lblSetting2 = new javax.swing.JLabel();
        pnlSetting = new javax.swing.JPanel();
        lblDangNhap = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
        lblDoiMatKhau = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        jPanel4 = new jPanelGradient();
        lblDongHo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
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

        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/profile (1).png"))); // NOI18N
        jPanel2.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        lblTen.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        lblTen.setForeground(new java.awt.Color(255, 255, 255));
        lblTen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTen.setText("Name");
        jPanel2.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 150, 210, -1));

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin.setText("Admin");
        jPanel2.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 170, 160, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bg2.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 200));

        lblNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNCC.setForeground(new java.awt.Color(255, 255, 255));
        lblNCC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/factory.png"))); // NOI18N
        lblNCC.setText("Nhà Cung Cấp");
        lblNCC.setToolTipText("");
        lblNCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNCCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNCCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNCCMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblNCCMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblNCCMouseReleased(evt);
            }
        });
        jPanel2.add(lblNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 140, 40));

        lblSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSP.setForeground(new java.awt.Color(255, 255, 255));
        lblSP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/sport-shoe.png"))); // NOI18N
        lblSP.setText("   SẢN PHẨM");
        lblSP.setToolTipText("");
        lblSP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSPMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSPMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblSPMouseReleased(evt);
            }
        });
        jPanel2.add(lblSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, 40));

        lblKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKH.setForeground(new java.awt.Color(255, 255, 255));
        lblKH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/customer.png"))); // NOI18N
        lblKH.setText("   KHÁCH HÀNG");
        lblKH.setToolTipText("");
        lblKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKHMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKHMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKHMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblKHMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblKHMouseReleased(evt);
            }
        });
        jPanel2.add(lblKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 140, 40));

        lblHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHD.setForeground(new java.awt.Color(255, 255, 255));
        lblHD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/invoice.png"))); // NOI18N
        lblHD.setText("   HÓA ĐƠN");
        lblHD.setToolTipText("");
        lblHD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHDMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHDMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblHDMouseReleased(evt);
            }
        });
        jPanel2.add(lblHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 140, 40));

        lblKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKM.setForeground(new java.awt.Color(255, 255, 255));
        lblKM.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/tag.png"))); // NOI18N
        lblKM.setText("KHUYẾN MÃI");
        lblKM.setToolTipText("");
        lblKM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblKMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKMMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblKMMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblKMMouseReleased(evt);
            }
        });
        jPanel2.add(lblKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 140, 40));

        lblExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 255, 255));
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/power (1).png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitMouseExited(evt);
            }
        });
        jPanel2.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 730, 40, 40));

        lblTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTK.setForeground(new java.awt.Color(255, 255, 255));
        lblTK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bar-chart.png"))); // NOI18N
        lblTK.setText("   THỐNG KÊ");
        lblTK.setToolTipText("");
        lblTK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTKMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblTKMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblTKMouseReleased(evt);
            }
        });
        jPanel2.add(lblTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 140, 30));

        lblNhanVien.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/identity-card.png"))); // NOI18N
        lblNhanVien.setText("Nhân Viên");
        lblNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jPanel2.add(lblNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 140, 40));

        lblSetting1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/cogwheel.png"))); // NOI18N
        lblSetting1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSetting1MouseClicked(evt);
            }
        });
        jPanel2.add(lblSetting1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, 40, 40));

        lblSetting2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSetting2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/cogwheel (1).png"))); // NOI18N
        lblSetting2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSetting2MouseClicked(evt);
            }
        });
        jPanel2.add(lblSetting2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, 40, 40));

        pnlSetting.setBackground(new java.awt.Color(255, 255, 255));

        lblDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(107, 107, 107));
        lblDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/logout3.png"))); // NOI18N
        lblDangNhap.setText("DANG NHAP");
        lblDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangNhapMouseClicked(evt);
            }
        });

        lblDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDangXuat.setForeground(new java.awt.Color(107, 107, 107));
        lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/logout3.png"))); // NOI18N
        lblDangXuat.setText("DANG XUAT ");

        lblDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDoiMatKhau.setForeground(new java.awt.Color(107, 107, 107));
        lblDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/logout3.png"))); // NOI18N
        lblDoiMatKhau.setText("DOI MAT KHAU");
        lblDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDoiMatKhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSettingLayout = new javax.swing.GroupLayout(pnlSetting);
        pnlSetting.setLayout(pnlSettingLayout);
        pnlSettingLayout.setHorizontalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(lblDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlSettingLayout.setVerticalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(pnlSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 200, 150));

        lblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lblTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/account.png"))); // NOI18N
        lblTaiKhoan.setText("Tai Khoan");
        lblTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblTaiKhoanMouseReleased(evt);
            }
        });
        jPanel2.add(lblTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 120, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 879));

        lblDongHo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDongHo.setText("00 : 00 : 00");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/home-icon-silhouette.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(955, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 0, 1320, 80));

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

        jPanel1.add(pnlCardPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 79, 1270, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        //opennhanvien();
        NhanVien1 nv = new NhanVien1();
        changePanel(nv);
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

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked

        Thoat();
    }//GEN-LAST:event_lblExitMouseClicked

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
        lblNhanVien.setForeground(new Color(73, 231, 195));
        lblNhanVien.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\identity-card3.png"));
    }//GEN-LAST:event_lblNhanVienMousePressed

    private void lblNhanVienMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNhanVienMouseReleased
        lblNhanVien.setForeground(new Color(235, 176, 30));
        lblNhanVien.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\identity-card2.png"));
    }//GEN-LAST:event_lblNhanVienMouseReleased

    private void lblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseClicked
        opendTaiKhoanQL();
        
    }//GEN-LAST:event_lblTaiKhoanMouseClicked

    private void lblExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseEntered
        lblExit.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\power.png"));
    }//GEN-LAST:event_lblExitMouseEntered

    private void lblExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseExited
        lblExit.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\power (1).png"));
    }//GEN-LAST:event_lblExitMouseExited

    private void lblDoiMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDoiMatKhauMouseClicked
        DoiMatKhau dmk = new DoiMatKhau(new javax.swing.JFrame(), true);
        dmk.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_lblDoiMatKhauMouseClicked

    private void lblDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangNhapMouseClicked
        DangNhap dialog = new DangNhap(new javax.swing.JFrame(), true);
        if (Auth.islogin()) {
            MsgBox.alert(this, "Ban Da Dnag Nhap");
        } else {
            dialog.setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_lblDangNhapMouseClicked
//
    private void lblNCCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMouseEntered
        lblNCC.setForeground(new Color(235, 176, 30));
        lblNCC.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\factory (1).png"));
    }//GEN-LAST:event_lblNCCMouseEntered

    private void lblNCCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMouseExited
        lblNCC.setForeground(Color.WHITE);
        lblNCC.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\factory.png"));
    }//GEN-LAST:event_lblNCCMouseExited

    private void lblNCCMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMousePressed
        lblNCC.setForeground(new Color(73, 231, 195));
        lblNCC.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\factory3.png"));    }//GEN-LAST:event_lblNCCMousePressed

    private void lblNCCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNCCMouseReleased
        lblNCC.setForeground(new Color(235, 176, 30));
        lblNCC.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\factory (1).png"));
    }//GEN-LAST:event_lblNCCMouseReleased
//
    private void lblSPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMouseEntered
        lblSP.setForeground(new Color(235, 176, 30));
        lblSP.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\sport-shoe (1).png"));
    }//GEN-LAST:event_lblSPMouseEntered

    private void lblSPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMouseExited
        lblSP.setForeground(Color.WHITE);
        lblSP.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\sport-shoe.png"));    }//GEN-LAST:event_lblSPMouseExited

    private void lblSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMousePressed
        lblSP.setForeground(new Color(73, 231, 195));
        lblSP.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\sport-shoe3.png"));    }//GEN-LAST:event_lblSPMousePressed

    private void lblSPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSPMouseReleased
        lblSP.setForeground(new Color(235, 176, 30));
        lblSP.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\sport-shoe (1).png"));    }//GEN-LAST:event_lblSPMouseReleased
//
    private void lblKHMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKHMouseEntered
        lblKH.setForeground(new Color(235, 176, 30));
        lblKH.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\customer (1).png"));
    }//GEN-LAST:event_lblKHMouseEntered

    private void lblKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKHMouseExited
        lblKH.setForeground(Color.WHITE);
        lblKH.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\customer.png"));    }//GEN-LAST:event_lblKHMouseExited

    private void lblKHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKHMousePressed
        lblKH.setForeground(new Color(73, 231, 195));
        lblKH.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\customer3.png"));    }//GEN-LAST:event_lblKHMousePressed

    private void lblKHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKHMouseReleased
        lblKH.setForeground(new Color(235, 176, 30));
        lblKH.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\customer (1).png"));    }//GEN-LAST:event_lblKHMouseReleased
//
    private void lblHDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHDMouseEntered
        lblHD.setForeground(new Color(235, 176, 30));
        lblHD.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\invoice (1).png"));    }//GEN-LAST:event_lblHDMouseEntered

    private void lblHDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHDMouseExited
        lblHD.setForeground(Color.WHITE);
        lblHD.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\invoice.png"));    }//GEN-LAST:event_lblHDMouseExited

    private void lblHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHDMousePressed
        lblHD.setForeground(new Color(73, 231, 195));
        lblHD.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\invoice3.png"));    }//GEN-LAST:event_lblHDMousePressed

    private void lblHDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHDMouseReleased
        lblHD.setForeground(new Color(235, 176, 30));
        lblHD.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\invoice (1).png"));    }//GEN-LAST:event_lblHDMouseReleased
//
    private void lblTKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTKMouseEntered
        lblTK.setForeground(new Color(235, 176, 30));
        lblTK.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\bar-chart (1).png"));    }//GEN-LAST:event_lblTKMouseEntered

    private void lblTKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTKMouseExited
        lblTK.setForeground(Color.WHITE);
        lblTK.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\bar-chart.png"));
    }//GEN-LAST:event_lblTKMouseExited

    private void lblTKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTKMousePressed
        lblTK.setForeground(new Color(73, 231, 195));
        lblTK.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\bar-chart3.png"));    }//GEN-LAST:event_lblTKMousePressed

    private void lblTKMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTKMouseReleased
        lblTK.setForeground(new Color(235, 176, 30));
        lblTK.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\bar-chart (1).png"));    }//GEN-LAST:event_lblTKMouseReleased
//
    private void lblKMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKMMouseEntered
        lblKM.setForeground(new Color(235, 176, 30));
        lblKM.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\tag (1).png"));
    }//GEN-LAST:event_lblKMMouseEntered

    private void lblKMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKMMouseExited
        lblKM.setForeground(Color.WHITE);
        lblKM.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\tag.png"));    }//GEN-LAST:event_lblKMMouseExited

    private void lblKMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKMMousePressed
        lblKM.setForeground(new Color(73, 231, 195));
        lblKM.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\tag3.png"));    }//GEN-LAST:event_lblKMMousePressed

    private void lblKMMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKMMouseReleased
        lblKM.setForeground(new Color(235, 176, 30));
        lblKM.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\tag (1).png"));    }//GEN-LAST:event_lblKMMouseReleased
//
    private void lblTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseEntered
        lblTaiKhoan.setForeground(new Color(235, 176, 30));
        lblTaiKhoan.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\account2.png"));    }//GEN-LAST:event_lblTaiKhoanMouseEntered

    private void lblTaiKhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseExited
        lblTaiKhoan.setForeground(Color.WHITE);
        lblTaiKhoan.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\account.png"));    }//GEN-LAST:event_lblTaiKhoanMouseExited

    private void lblTaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMousePressed
        lblTaiKhoan.setForeground(new Color(73, 231, 195));
        lblTaiKhoan.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\account3.png"));    }//GEN-LAST:event_lblTaiKhoanMousePressed

    private void lblTaiKhoanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTaiKhoanMouseReleased
        lblTaiKhoan.setForeground(new Color(235, 176, 30));
        lblTaiKhoan.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\account2.png"));    }//GEN-LAST:event_lblTaiKhoanMouseReleased
//

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
    NhanVienDAO nvDAO = new NhanVienDAO();
    TaiKhoanDAO tkDAO = new TaiKhoanDAO();

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
        fill();
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

    public void getFormNV(NhanVien nv) {
        try {
            lblTen.setText(nv.getTenNV());
            if (nv.getHinh() != null) {
                lblAnh.setIcon(XImage.read(nv.getHinh()));
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy");
        }
    }

    public void getFormTK(TaiKhoan tk) {
        try {
            if (Auth.islogin()) {
                if (Auth.isManager()) {
                    lblAdmin.setText("Quản lý");
                } else {
                    lblAdmin.setText("Nhân viên");
                }
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Không tìm thấy2");
        }

    }

    public void fill() {
        try {
            String maNv = Auth.isMaNV();

            NhanVien nv = nvDAO.selectById(maNv);
            this.getFormNV(nv);

            TaiKhoan tkk = tkDAO.selectById(maNv);
            this.getFormTK(tkk);
        } catch (Exception e) {
            MsgBox.alert(this, "Vui lòng đăng nhập để sử dụng chương trình");
        }
    }

    public void Thoat() {
        boolean thoat = MsgBox.confirm(this, "Bạn có thực sự muốn thoát không?");
        if (thoat == true) {
            System.exit(0);
        } else if (thoat == false) {
            return;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblBanner1;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDoiMatKhau;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblExit;
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
