/*
 
 */
package com.nhom4.ui;

import com.nhom4.dao.HoaDonChiTietDAO;
import com.nhom4.dao.HoaDonDAO;
import com.nhom4.dao.KhachHangDAO;
import com.nhom4.dao.KhuyenMaiDAO;
import com.nhom4.dao.NhaCungCapDAO;
import com.nhom4.dao.NhanVienDAO;
import com.nhom4.dao.SanPhamDAO;
import com.nhom4.entity.HoaDon;
import com.nhom4.entity.KhachHang;
import com.nhom4.entity.KhuyenMai;
import com.nhom4.entity.NhaCungCap;
import com.nhom4.entity.NhanVien;
import com.nhom4.entity.SanPham;
import com.nhom4.utils.MsgBox;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class LichSuXoa extends javax.swing.JFrame {

    public LichSuXoa() {
        initComponents();
        init();
    }
    SimpleDateFormat formats = new SimpleDateFormat("dd-MM-yyyy");
    NhaCungCapDAO nccDAO = new NhaCungCapDAO();
    KhachHangDAO khDAO = new KhachHangDAO();
    NhanVienDAO nvDAO = new NhanVienDAO();
    SanPhamDAO spDAO = new SanPhamDAO();
    HoaDonDAO hdDAO = new HoaDonDAO();
    HoaDonChiTietDAO hdctDAO = new HoaDonChiTietDAO();
    KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    
    public void changePan(int i){
        jTabbedPane1.setSelectedIndex(i);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlNCC = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNcc = new javax.swing.JTable();
        btnKhoiPhucNCC = new javax.swing.JButton();
        btnXoaNCC = new javax.swing.JButton();
        pnlKhachHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnKhoiPhucKH = new javax.swing.JButton();
        btnXoaKH = new javax.swing.JButton();
        pnlNhanVien = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnKhoiPhucNV = new javax.swing.JButton();
        btnXoaNV = new javax.swing.JButton();
        pnlSanPham = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnKhoiPhucSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        pnlKhuyenmai = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        btnKhoiPhucKM = new javax.swing.JButton();
        btnXoaKM = new javax.swing.JButton();
        pnlHoaDon = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnKhoiPhucHD = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblNcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Ma Nha Cung Cap", "Ten Nha Cung Cap"
            }
        ));
        jScrollPane3.setViewportView(tblNcc);

        btnKhoiPhucNCC.setText("Khôi phục");
        btnKhoiPhucNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucNCCActionPerformed(evt);
            }
        });

        btnXoaNCC.setText("Xóa");
        btnXoaNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNCCLayout = new javax.swing.GroupLayout(pnlNCC);
        pnlNCC.setLayout(pnlNCCLayout);
        pnlNCCLayout.setHorizontalGroup(
            pnlNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNCCLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKhoiPhucNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnXoaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        pnlNCCLayout.setVerticalGroup(
            pnlNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNCCLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(pnlNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNCCLayout.createSequentialGroup()
                        .addComponent(btnKhoiPhucNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaNCC))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhà cung cấp", pnlNCC);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaKH", "TenKH", "SDT", "DiaChi"
            }
        ));
        jScrollPane2.setViewportView(tblKhachHang);

        btnKhoiPhucKH.setText("Khôi phục");
        btnKhoiPhucKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucKHActionPerformed(evt);
            }
        });

        btnXoaKH.setText("Xóa");
        btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKhoiPhucKH, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnXoaKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKhachHangLayout.createSequentialGroup()
                        .addComponent(btnKhoiPhucKH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaKH))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách hàng", pnlKhachHang);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaNV", "TenNV", "GioiTinh", "SDT", "Email", "Hinh", "DiaChi"
            }
        ));
        jScrollPane1.setViewportView(tblNhanVien);

        btnKhoiPhucNV.setText("Khôi phục");
        btnKhoiPhucNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucNVActionPerformed(evt);
            }
        });

        btnXoaNV.setText("Xóa");
        btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKhoiPhucNV, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnXoaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhanVienLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addComponent(btnKhoiPhucNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaNV))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhân viên", pnlNhanVien);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaSP", "TenSP", "SoLuong", "MaNCC", "Anh", "GhiChu"
            }
        ));
        jScrollPane4.setViewportView(tblSanPham);

        btnKhoiPhucSP.setText("Khôi phục");
        btnKhoiPhucSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSanPhamLayout = new javax.swing.GroupLayout(pnlSanPham);
        pnlSanPham.setLayout(pnlSanPhamLayout);
        pnlSanPhamLayout.setHorizontalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanPhamLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKhoiPhucSP, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnXoaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        pnlSanPhamLayout.setVerticalGroup(
            pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSanPhamLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(pnlSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSanPhamLayout.createSequentialGroup()
                        .addComponent(btnKhoiPhucSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaSP))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm", pnlSanPham);

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaKM", "TenKM", "GiamGia", "NgayBD", "NgayKT", "GhiChu"
            }
        ));
        jScrollPane5.setViewportView(tblKhuyenMai);

        btnKhoiPhucKM.setText("Khôi phục");
        btnKhoiPhucKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucKMActionPerformed(evt);
            }
        });

        btnXoaKM.setText("Xóa");
        btnXoaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKhuyenmaiLayout = new javax.swing.GroupLayout(pnlKhuyenmai);
        pnlKhuyenmai.setLayout(pnlKhuyenmaiLayout);
        pnlKhuyenmaiLayout.setHorizontalGroup(
            pnlKhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhuyenmaiLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlKhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKhoiPhucKM, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnXoaKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        pnlKhuyenmaiLayout.setVerticalGroup(
            pnlKhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhuyenmaiLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(pnlKhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKhuyenmaiLayout.createSequentialGroup()
                        .addComponent(btnKhoiPhucKM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaKM))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khuyến mãi", pnlKhuyenmai);

        pnlHoaDon.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "MaNV", "MaKM", "NgayBan", "MaKH", "ThanhTien", "TrangThai"
            }
        ));
        jScrollPane6.setViewportView(tblHoaDon);

        btnKhoiPhucHD.setText("Khôi phục");
        btnKhoiPhucHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucHDActionPerformed(evt);
            }
        });

        btnXoaHD.setText("Xóa");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKhoiPhucHD, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnXoaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(btnKhoiPhucHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaHD)
                .addGap(383, 383, 383))
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa đơn", pnlHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("LỊCH SỬ XÓA");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/power.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhoiPhucNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucNCCActionPerformed
        restoreNCC();
    }//GEN-LAST:event_btnKhoiPhucNCCActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnXoaNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNCCActionPerformed
        deleteNCC();
    }//GEN-LAST:event_btnXoaNCCActionPerformed

    private void btnKhoiPhucKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucKHActionPerformed
        restoreKH();
    }//GEN-LAST:event_btnKhoiPhucKHActionPerformed

    private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKHActionPerformed
        deleteKH();
    }//GEN-LAST:event_btnXoaKHActionPerformed

    private void btnKhoiPhucNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucNVActionPerformed
        restoreNV();
    }//GEN-LAST:event_btnKhoiPhucNVActionPerformed

    private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNVActionPerformed
        deleteNV();
    }//GEN-LAST:event_btnXoaNVActionPerformed

    private void btnKhoiPhucSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucSPActionPerformed
        restoreSP();
    }//GEN-LAST:event_btnKhoiPhucSPActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        deleteSP();
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnKhoiPhucHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucHDActionPerformed
        restoreHD();
    }//GEN-LAST:event_btnKhoiPhucHDActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        deleteHD();
    }//GEN-LAST:event_btnXoaHDActionPerformed

    private void btnKhoiPhucKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucKMActionPerformed
        restoreKM();
    }//GEN-LAST:event_btnKhoiPhucKMActionPerformed

    private void btnXoaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKMActionPerformed
        deleteKM();
    }//GEN-LAST:event_btnXoaKMActionPerformed

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
            java.util.logging.Logger.getLogger(LichSuXoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LichSuXoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LichSuXoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LichSuXoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LichSuXoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhoiPhucHD;
    private javax.swing.JButton btnKhoiPhucKH;
    private javax.swing.JButton btnKhoiPhucKM;
    private javax.swing.JButton btnKhoiPhucNCC;
    private javax.swing.JButton btnKhoiPhucNV;
    private javax.swing.JButton btnKhoiPhucSP;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JButton btnXoaKH;
    private javax.swing.JButton btnXoaKM;
    private javax.swing.JButton btnXoaNCC;
    private javax.swing.JButton btnXoaNV;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlKhuyenmai;
    private javax.swing.JPanel pnlNCC;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlSanPham;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblNcc;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTable tblSanPham;
    // End of variables declaration//GEN-END:variables

    public void init() {
        fillTblNCC();
        fillTblKH();
        fillTblNV();
        fillTblSP();
        fillTblHD();
        fillTblKM();
    }

    //NHA CUNg CAP//
    public void fillTblNCC() {
        DefaultTableModel model = (DefaultTableModel) tblNcc.getModel();
        model.setRowCount(0);
        //listNCC.clear();
        try {
            List<NhaCungCap> list = nccDAO.selectAn();
            for (NhaCungCap nv : list) {
                Object[] data = {
                    nv.getMaNCC(),
                    nv.getTenNCC()
                        
                };
                //listNCC.add(nv);
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    public void restoreNCC() {

        int i = tblNcc.getSelectedRow();
        String key = tblNcc.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn khoi phuc nhà cung cấp này")) {
            try {
                nccDAO.restore(key);
                this.fillTblNCC();
                MsgBox.alert(this, "khoi phuc thành công");             
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    public void deleteNCC() {
        int i = tblNcc.getSelectedRow();
        String key = tblNcc.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhà cung cấp này")) {
            try {
                nccDAO.delete(key);
                fillTblNCC();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    //Khách hàng//
    public void fillTblKH() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        //listNCC.clear();
        try {
            List<KhachHang> list = khDAO.selectAn();
            for (KhachHang kh : list) {
                Object[] data = {
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getSDT(),
                    kh.getDiaChi()
                        
                };
                //listNCC.add(nv);
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    
    public void restoreKH() {

        int i = tblKhachHang.getSelectedRow();
        String key = tblKhachHang.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn khôi phục khách hàng này")) {
            try {
                khDAO.restore(key);
                this.fillTblKH();
                MsgBox.alert(this, "Khôi phục thành công");             
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    public void deleteKH() {
        int i = tblKhachHang.getSelectedRow();
        String key = tblKhachHang.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa khách hàng này")) {
            try {
                khDAO.delete(key);
                fillTblKH();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    //NHÂN VIÊN//
    public void fillTblNV() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        //listNCC.clear();
        try {
            List<NhanVien> list = nvDAO.selectAn();
            for (NhanVien nv : list) {
                Object[] data = {
                    nv.getMaNV(),
                    nv.getTenNV(),
                    nv.getGioiTinh(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getHinh(),
                    nv.getDiaChi()
                        
                };
                //listNCC.add(nv);
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    
    public void restoreNV() {

        int i = tblNhanVien.getSelectedRow();
        String key = tblNhanVien.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn khôi phục nhân viên này")) {
            try {
                nvDAO.restore(key);
                this.fillTblNV();
                MsgBox.alert(this, "Khôi phục thành công");             
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    public void deleteNV() {
        int i = tblNhanVien.getSelectedRow();
        String key = tblNhanVien.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên này")) {
            try {
                nvDAO.delete(key);
                fillTblNV();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    //SẢN PHẨM//
    public void fillTblSP() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        //listNCC.clear();
        try {
            List<SanPham> list = spDAO.selectAn();
            for (SanPham sp : list) {
                Object[] data = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    sp.getMaNCC(),
                    sp.getAnh(),
                    sp.getGhiChu()
                        
                };
                //listNCC.add(nv);
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    
    public void restoreSP() {

        int i = tblSanPham.getSelectedRow();
        String key = tblSanPham.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn khôi phục sản phẩm này")) {
            try {
                spDAO.restore(key);
                this.fillTblSP();
                MsgBox.alert(this, "Khôi phục thành công");             
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    public void deleteSP() {
        int i = tblSanPham.getSelectedRow();
        String key = tblSanPham.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa sản phẩm này")) {
            try {
                spDAO.delete(key);
                fillTblSP();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    //HÓA ĐƠN//
    public void fillTblHD() {
        DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        //listNCC.clear();
        try {
            List<HoaDon> list = hdDAO.selectAn();
            for (HoaDon sp : list) {
                Object[] data = {
                    sp.getMaHD(),
                    sp.getMaNV(),
                    sp.getMaKH(),
                    sp.getNgayBan(),
                    sp.getMaKH(),
                    sp.getThanhTien(),
                    sp.isTrangThai()
                        
                };
                //listNCC.add(nv);
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    
    public void restoreHD() {

        int i = tblHoaDon.getSelectedRow();
        String key = tblHoaDon.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn khôi phục hóa đơn này")) {
            try {
                hdDAO.restore(key);
                this.fillTblHD();
                MsgBox.alert(this, "Khôi phục thành công");             
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    public void deleteHD() {
        int i = tblHoaDon.getSelectedRow();
        String key = tblHoaDon.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa hóa đơn này")) {
            try {
                hdctDAO.deletebByMaHD(key);
                hdDAO.delete(key);
                fillTblHD();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    //KHUYẾN MÃI//
    public void fillTblKM() {
        DefaultTableModel model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);
        //listNCC.clear();
        try {
            List<KhuyenMai> list = kmDAO.selectAn();
            for (KhuyenMai km : list) {
                Object[] data = {
                    km.getMaKM(),
                    km.getTenKM(),
                    km.getGiamGia(),
                    formats.format(km.getNgayBD()),
                    formats.format(km.getNgayKT()),
                    km.getGhiChu()
                        
                };
                //listNCC.add(nv);
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    
    public void restoreKM() {

        int i = tblKhuyenMai.getSelectedRow();
        String key = tblKhuyenMai.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn khôi phục chương trình khuyến mãi này")) {
            try {
                kmDAO.restore(key);
                this.fillTblKM();
                MsgBox.alert(this, "Khôi phục thành công");             
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
    
    public void deleteKM() {
        int i = tblKhuyenMai.getSelectedRow();
        String key = tblKhuyenMai.getValueAt(i, 0).toString();
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa chương trình khuyến mãi này")) {
            try {
                kmDAO.delete(key);
                fillTblKM();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }
}
