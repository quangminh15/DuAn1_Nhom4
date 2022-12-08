/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom4.ui;

import com.nhom4.dao.TaiKhoanDAO;
import com.nhom4.entity.NhanVien;
import com.nhom4.entity.TaiKhoan;
import com.nhom4.utils.MsgBox;
import com.nhom4.utils.XImage;
import com.nhom4.utils.Auth;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hai
 */
public class TaiKhoanQL extends javax.swing.JPanel {
       DefaultTableModel model;
    /**
     * Creates new form TaiKhoanQL
     */
        int checklap = 0;
       ArrayList<TaiKhoan> listTK =new ArrayList<>(); 
    TaiKhoanDAO tkDAO = new TaiKhoanDAO();    
    int row =-1;
    int them =0;
 
    public TaiKhoanQL() {
        initComponents();
        this.setColumns();
        this.init();
        txtOFF();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtTenDN = new javax.swing.JTextField();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        btnLuu = new com.nhom4.ui.ButtonCustom();
        btnXoa = new com.nhom4.ui.ButtonCustom();
        btnHuy = new com.nhom4.ui.ButtonCustom();
        btnSua = new com.nhom4.ui.ButtonCustom();
        btnThem = new com.nhom4.ui.ButtonCustom();
        pnlmanv = new javax.swing.JPanel();
        pnlusername = new javax.swing.JPanel();
        pnlpass = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBang = new com.nhom4.ui.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTenDN.setBackground(new java.awt.Color(245, 245, 245));
        txtTenDN.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtTenDN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtTenDN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenDNFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenDNFocusLost(evt);
            }
        });
        jPanel2.add(txtTenDN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 380, 51));

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        rdoNhanVien.setText("Nhân viên");
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });
        jPanel2.add(rdoNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 170, -1));

        buttonGroup1.add(rdoQuanLy);
        rdoQuanLy.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        rdoQuanLy.setText("Quản lý");
        rdoQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoQuanLyActionPerformed(evt);
            }
        });
        jPanel2.add(rdoQuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(14, 65, 91));
        jLabel2.setText("Thong tin tai khoan");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(14, 65, 91));
        jLabel3.setText("Tên đăng nhập:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(14, 65, 91));
        jLabel4.setText("Vai trò:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(14, 65, 91));
        jLabel5.setText("Mật khẩu:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        txtMaNV.setBackground(new java.awt.Color(245, 245, 245));
        txtMaNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtMaNV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtMaNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNVFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaNVFocusLost(evt);
            }
        });
        jPanel2.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 380, 51));

        txtMatKhau.setBackground(new java.awt.Color(245, 245, 245));
        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });
        jPanel2.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 380, 51));

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/diskette.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel2.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 270, 50));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bin-with-lid.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 180, 50));

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/delete.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel2.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 270, 50));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/editing.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 170, 50));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/add2.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 180, 50));

        javax.swing.GroupLayout pnlmanvLayout = new javax.swing.GroupLayout(pnlmanv);
        pnlmanv.setLayout(pnlmanvLayout);
        pnlmanvLayout.setHorizontalGroup(
            pnlmanvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pnlmanvLayout.setVerticalGroup(
            pnlmanvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel2.add(pnlmanv, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 380, 2));

        javax.swing.GroupLayout pnlusernameLayout = new javax.swing.GroupLayout(pnlusername);
        pnlusername.setLayout(pnlusernameLayout);
        pnlusernameLayout.setHorizontalGroup(
            pnlusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pnlusernameLayout.setVerticalGroup(
            pnlusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel2.add(pnlusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 380, -1));

        javax.swing.GroupLayout pnlpassLayout = new javax.swing.GroupLayout(pnlpass);
        pnlpass.setLayout(pnlpassLayout);
        pnlpassLayout.setHorizontalGroup(
            pnlpassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pnlpassLayout.setVerticalGroup(
            pnlpassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel2.add(pnlpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 380, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(14, 65, 91));
        jLabel6.setText("Mã nhân viên:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 620, 590));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(947, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTimKiem.setForeground(new java.awt.Color(102, 102, 102));
        lblTimKiem.setText("Tìm kiếm theo tên");
        jPanel3.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, 30));

        txtTimKiem.setBorder(null);
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });
        jPanel3.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 690, 50));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/search (4).png"))); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel3.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 60, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 690, 3));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 980, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245)));

        btnFirst.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow (1).png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow.png"))); // NOI18N
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow (1).png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(14, 65, 91));
        jLabel7.setText("Danh sach tai khoan");

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(194, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addContainerGap(194, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addContainerGap(550, Short.MAX_VALUE)))
        );

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 620, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNhanVienActionPerformed

    private void rdoQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoQuanLyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoQuanLyActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
       
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this.first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        this.prev();
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        this.next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        this.TimKiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        if(txtTimKiem.getText().equals("")){
           lblTimKiem.setVisible(true);
       }
       else
           lblTimKiem.setVisible(false);
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if(them == 1 ){
                insert();
                return;
            }
            if(them == 2){
                update();
                return;
            }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        TaiKhoan tk = new TaiKhoan();
        this.setForm1(tk);
        this.row = -1;
        this.updateStatus();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
         them = 2;
            btnThem.setEnabled(false);
            btnXoa.setEnabled(false);
            btnLuu.setEnabled(true);
//            hide();
            txtON();
            txtMaNV.setEditable(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
         them = 1;
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnLuu.setEnabled(true);
            txtMaNV.setText("");
            txtTenDN.setText("");
            txtMatKhau.setText("");
            show();
            txtON();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtMaNVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNVFocusGained
        txtMaNV.setBackground(Color.WHITE);
        pnlmanv.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtMaNVFocusGained

    private void txtMaNVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNVFocusLost
        txtMaNV.setBackground(new Color(242, 242, 242));
        pnlmanv.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtMaNVFocusLost

    private void txtTenDNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDNFocusGained
        txtTenDN.setBackground(Color.WHITE);
        pnlusername.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtTenDNFocusGained

    private void txtTenDNFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDNFocusLost
        txtTenDN.setBackground(new Color(242, 242, 242));
        pnlusername.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtTenDNFocusLost

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        txtMatKhau.setBackground(Color.WHITE);
        pnlpass.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        txtMatKhau.setBackground(new Color(242, 242, 242));
        pnlpass.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        if (evt.getClickCount() == 1) {
            this.row = tblBang.getSelectedRow();
            this.edit();  
            setForm(row);
        }
    }//GEN-LAST:event_tblBangMouseClicked

    public void TimKiem() {
 DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0);
        try {
            String user = txtTimKiem.getText();
            List<TaiKhoan> list = tkDAO.selectByKeyword(user);
            for (TaiKhoan tk : list) {
                Object[] data = {
                    tk.getMaNV(),
                    tk.getUsername(),
                    tk.getPass(),
                    tk.getRole(),
                };
                model.addRow(data);
            }  
        } catch (Exception e) {
            MsgBox.alert(this, e.getMessage());
        }
        this.clearForm();
        this.row = -1;
        updateStatus();
    
    }
    
    public void init() { 
        this.row = -1;
        this.fillTable();      
        this.updateStatus();
        btnLuu.setEnabled(false);
        setFont(btnHuy);
        setFont(btnThem);
        setFont(btnSua);
        setFont(btnXoa);
    }
    public void setFont(JButton bt){
            bt.setFont(getFont().deriveFont(Font.BOLD, 18));
        }
    
    public void setColumns(){
        String[] row = new String[]{"Mã nhân viên", "Tên đăng nhập", "Mật khẩu", "Vai trò"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(row);
        tblBang.setModel(model);
        
    }
    
    public boolean check() {
        String patternUser = "^[a-zA-Z0-9_-]{6,15}$";
        String patternPass = "^[a-zA-Z0-9]{6,15}$";
        
        for (int i = 0; i < listTK.size(); i++) {
            if (listTK.get(i).getMaNV().equalsIgnoreCase(txtMaNV.getText())) {
                checklap = 1;
            }
        }
        if(txtMaNV.getText().equals("")){
            MsgBox.alert(this, "Không được để trống mã nhân viên");
            txtMaNV.requestFocus();
            return false;
        }
        else if (them == 1 && checklap == 1) {
            MsgBox.alert(this, "Mã nhân viên đã tồn tại. Vui lòng nhập mã mới");
            checklap = 0;
            return false;
        }      
        else if (txtTenDN.getText().equals("")) {
            MsgBox.alert(this, "Không được để trống tên đăng nhập");
            txtTenDN.requestFocus();
            return false;
        }
         else if(!txtTenDN.getText().matches(patternUser)|| txtTenDN.getText().length()<6 || txtTenDN.getText().length() > 15 ){
            MsgBox.alert(this, "Tên đăng nhập không chứa kí tự đặc biệt (@, #, %,..) và phải từ 6 đến 15 kí tự");
            txtTenDN.requestFocus();
            return false;
        }
       
        else if (txtMatKhau.getText().equals("")) {
            MsgBox.alert(this, "Không được để trống mật khẩu");
            txtMatKhau.requestFocus();
            return false;
        }else if(!txtMatKhau.getText().matches(patternPass)|| txtMatKhau.getText().length()<6 || txtMatKhau.getText().length() > 15 ){
            MsgBox.alert(this, "Mật khẩu không chứa kí tự đặc biệt (@, #, %,..) và phải từ 6 đến 15 kí tự");
            txtMatKhau.requestFocus();
            return false;
        }
        else if (!rdoNhanVien.isSelected() && !rdoQuanLy.isSelected()) {
            MsgBox.alert(this, "Bạn chưa chọn chức vụ");
            return false;
        }
        else if (them == 1 && Auth.isManager() && rdoQuanLy.isSelected()) {
            MsgBox.alert(this, "Không được chọn vai trò là quản lý");
            return false;
        }
        return true;
    }
    
    public void insert() {
        if (check()) {
            TaiKhoan tk = getForm();
            try {
                tkDAO.insert(tk);
                this.fillTable();
//                this.clearForm();               
                MsgBox.alert(this, "Thêm mới thành công");                
                updateStatus();                 
                them = 0;
                btnLuu.setEnabled(false);
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại");
                updateStatus();
                them = 0;
                btnLuu.setEnabled(false);
            }
        }
    }
    
    public void update() {
        if(check()){
        TaiKhoan tk = getForm(); 
            try {
                tkDAO.update(tk);
                this.fillTable();
                MsgBox.alert(this, "Cập nhật thành công");
                updateStatus();
                them = 0;
                btnLuu.setEnabled(false);
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại");
                updateStatus();
                them = 0;
                btnLuu.setEnabled(false);
            }
        }
    }
    
    public void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa nhân viên");
        } else {
            String manv = txtMaNV.getText();
            if (manv.equals(Auth.user.getMaNV())) {
                MsgBox.alert(this, "Bạn không được xóa chính bạn");
            } else if (MsgBox.confirm(this, "Bạn thực sự muốn xóa nhân viên này")) {
                try {
                    tkDAO.delete(manv);
                    this.clearForm();
                    this.fillTable();     
                    this.clearForm();
                    MsgBox.alert(this, "Xóa thành công");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa thất bại");
                }
            }
        }
    }
    
    public void first() {
        this.row = 0;
        tblBang.setRowSelectionInterval(row, row);
        this.edit();
        this.setForm(row);
    }
    
    public void prev() {
        if (this.row > 0) {          
            this.row--;
            tblBang.setRowSelectionInterval(row, row);
            this.edit();
            this.setForm(row);
        }
    }
    
    public void next() {
        if (this.row < tblBang.getRowCount() - 1) {
            
            this.row++;
            tblBang.setRowSelectionInterval(row, row);
            this.edit();
            this.setForm(row);
        }
    }
    
    public void last() {
        this.row = tblBang.getRowCount() - 1;
        tblBang.setRowSelectionInterval(row, row);
        this.edit();
        this.setForm(row);
    }
    
    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0);
        listTK.clear();
        try {
            List<TaiKhoan> list = tkDAO.selectAll(); // Đọc dữ liệu từ CSDL
            for (TaiKhoan tk : list) {
                Object[] data = {
                    tk.getMaNV(),
                    tk.getUsername(),
                    tk.getPass(),                   
                    tk.getRole()? "Quản lý" : "Nhân viên",
                };
                model.addRow(data);
                listTK.add(tk);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    public void setForm(int index){
                 txtMaNV.setText(tblBang.getValueAt(index, 0).toString());
                 txtTenDN.setText(tblBang.getValueAt(index, 1).toString());
                 txtMatKhau.setText(tblBang.getValueAt(index, 2).toString());
                 if(tblBang.getValueAt(index, 3).toString().equals("Nhân viên")){
                 rdoNhanVien.setSelected(true);
                 }else{
                 rdoQuanLy.setSelected(true);
                 }
    }
    
    public void setForm1(TaiKhoan tk) {
        txtMaNV.setText(tk.getMaNV());
        txtTenDN.setText(tk.getUsername());
        txtMatKhau.setText(tk.getPass());
        rdoQuanLy.setSelected(tk.getRole());
         rdoNhanVien.setSelected(!tk.getRole());
    }
    
  
    TaiKhoan getForm() {
        TaiKhoan tk = new TaiKhoan();
        tk.setMaNV(txtMaNV.getText());
        tk.setUsername(txtTenDN.getText());
        tk.setPass(String.valueOf(txtMatKhau.getText()));
        tk.setRole(rdoQuanLy.isSelected());
        return tk;
    }
    
    public void clearForm() {
        TaiKhoan tk = new TaiKhoan();
        this.setForm(0);
        this.row = -1;
        this.updateStatus();
        
    }
    
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblBang.getRowCount() - 1);
//        Trạng thái form
         btnThem.setEnabled(edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
// Trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPre.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
        txtOFF();
    }
    
    public void edit() {
        String manv = (String) tblBang.getValueAt(row,0);
        TaiKhoan tk = tkDAO.selectById(manv);
        int i = tblBang.getSelectedRow();
        this.setForm(i);
        this.updateStatus();
    }
    
     public void txtOFF(){
        txtMaNV.setEditable(false);
        txtTenDN.setEditable(false);
        txtMatKhau.setEditable(false);
//        rdoQuanLy.setSelected(true);
        rdoQuanLy.setEnabled(false);
        rdoNhanVien.setEnabled(false);
    }
    
    public void txtON(){
        txtMaNV.setEditable(true);
        txtTenDN.setEditable(true);
        txtMatKhau.setEditable(true);
    }
    
    public void hide(){
        
    }
    
    public void show(){
              rdoQuanLy.setEnabled(true);
        rdoNhanVien.setEnabled(true);  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private com.nhom4.ui.ButtonCustom btnHuy;
    private javax.swing.JButton btnLast;
    private com.nhom4.ui.ButtonCustom btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private com.nhom4.ui.ButtonCustom btnSua;
    private com.nhom4.ui.ButtonCustom btnThem;
    private javax.swing.JButton btnTimKiem;
    private com.nhom4.ui.ButtonCustom btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel pnlmanv;
    private javax.swing.JPanel pnlpass;
    private javax.swing.JPanel pnlusername;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoQuanLy;
    private com.nhom4.ui.Table tblBang;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenDN;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
