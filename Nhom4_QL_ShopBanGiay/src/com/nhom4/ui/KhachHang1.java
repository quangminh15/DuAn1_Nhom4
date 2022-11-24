/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom4.ui;

import com.nhom4.dao.KhachHangDAO;
import com.nhom4.dao.NhanVienDAO;
import com.nhom4.entity.KhachHang;
import com.nhom4.entity.NhanVien;
import com.nhom4.utils.MsgBox;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hai
 */
public class KhachHang1 extends javax.swing.JPanel {

    /**
     * Creates new form KhachHang
     */
    public KhachHang1() {
        initComponents();
        init();
//        fillTable();
    }
 
    KhachHangDAO dao = new KhachHangDAO();
    int row = -1;
    int them = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txttimKiem = new javax.swing.JTextField();
        btntimKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtmaKhachHang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txttenKhachHang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsoDienThoai = new javax.swing.JTextField();
        txtdiaChi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkhachHang = new javax.swing.JTable();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 24))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(947, 100));

        txttimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimKiemActionPerformed(evt);
            }
        });

        btntimKiem.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btntimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/search (4).png"))); // NOI18N
        btntimKiem.setText("Tìm kiếm");
        btntimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txttimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btntimKiem)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txttimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimKiem))
                .addGap(0, 26, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("Số Điện Thoại:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setText("Địa Chỉ:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/add-group.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/trash (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/save-file.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/cancel.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(42, 42, 42)
                .addComponent(btnSua)
                .addGap(51, 51, 51)
                .addComponent(btnXoa)
                .addGap(54, 54, 54)
                .addComponent(btnLuu)
                .addGap(51, 51, 51)
                .addComponent(btnHuy)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(53, 53, 53)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(txttenKhachHang)
                            .addComponent(txtsoDienThoai)
                            .addComponent(txtdiaChi))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtsoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288))
        );

        tblkhachHang.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        tblkhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Số điện thoại", "Địa chỉ"
            }
        ));
        tblkhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblkhachHang);

        btnLast.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow (1).png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow.png"))); // NOI18N
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow (1).png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(953, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txttimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
          them = 1;
            btnSua.setEnabled(false);
            btnXoa.setEnabled(false);
            btnLuu.setEnabled(true);
            txtmaKhachHang.setText("");
            txttenKhachHang.setText("");
             txtsoDienThoai.setText("");
              txtdiaChi.setText("");
            txtON();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        them = 2;
            btnThem.setEnabled(false);
            btnXoa.setEnabled(false);
            btnLuu.setEnabled(true);
            fillTable();
            txtON();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
         delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
          if(check()==true){
            if(them == 1 ){
                insert();
                return;
            }
            if(them == 2){
                update();
                return;
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
         updateStatus();
        clearForm();
        btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
      first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
       prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
         next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
         last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblkhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachHangMouseClicked
         if (evt.getClickCount() == 1) {
            this.row = tblkhachHang.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblkhachHangMouseClicked

    private void btntimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimKiemActionPerformed
        this.TimKiem();
    }//GEN-LAST:event_btntimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btntimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblkhachHang;
    private javax.swing.JTextField txtdiaChi;
    private javax.swing.JTextField txtmaKhachHang;
    private javax.swing.JTextField txtsoDienThoai;
    private javax.swing.JTextField txttenKhachHang;
    private javax.swing.JTextField txttimKiem;
    // End of variables declaration//GEN-END:variables

    private void init() {
       this.row = -1;
        fillTable();
        this.updateStatus();
        btnLuu.setEnabled(false);
    }
     public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblkhachHang.getModel();
        model.setRowCount(0);
        try {
            List<KhachHang> list = dao.selectAll(); // Đọc dữ liệu từ CSDL
            for (KhachHang kh : list) {
                Object[] data = {
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getSDT(),
                    kh.getDiaChi(),
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu!");
        }
    }
    
    public void insert() {
        
            KhachHang kh = getForm();
            try {
                dao.insert(kh);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Thêm mới thành công");
                 updateStatus();
                them = 0;
                btnLuu.setEnabled(true);
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại");
                  updateStatus();
                them = 0;
                 btnLuu.setEnabled(true);
            }
        
    }
    
    public void update() {
        KhachHang kh = getForm();
        
            try {
                dao.update(kh);
                this.fillTable();
                MsgBox.alert(this, "Cập nhật thành công");
                     them = 0;
                btnLuu.setEnabled(true);
               
            } catch (Exception e) {
                MsgBox.alert(this, "Cập nhật thất bại");
                updateStatus();
                     them = 0;
            }
        
    }
    
    public void delete() {
            String kh = txtmaKhachHang.getText();
            if (MsgBox.confirm(this, "Bạn thực sự muốn xóa khách hàng này")) {
                try {
                    dao.delete(kh);
                    this.fillTable();
                    this.clearForm();
                    MsgBox.alert(this, "Xóa thành công");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa thất bại");
                }
            }
    }
    
    public void clearForm() {
        KhachHang kh = new KhachHang();
        this.setForm(kh);
        this.row = -1;
        this.updateStatus();
    }
    
    public void setForm(KhachHang kh) {
        txtmaKhachHang.setText(kh.getMaKH());
        txttenKhachHang.setText(kh.getTenKH());
        txtsoDienThoai.setText(kh.getSDT());
        txtdiaChi.setText(kh.getDiaChi());
    }
    
    KhachHang getForm() {
        KhachHang kh = new KhachHang();
        kh.setMaKH(txtmaKhachHang.getText());
        kh.setTenKH(txttenKhachHang.getText());
        kh.setSDT(txtsoDienThoai.getText());
        kh.setDiaChi(txtdiaChi.getText());
        return kh;
    }
    
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblkhachHang.getRowCount() - 1);
//        Trạng thái form
        btnThem.setEnabled(edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
// Trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
       txtOFF();
    }
    
    public void edit() {
        String makh = (String) tblkhachHang.getValueAt(this.row, 0);
        KhachHang kh = dao.selectById(makh);
        this.setForm(kh);
        this.updateStatus();
    }
    
    public void first() {
        this.row = 0;
        tblkhachHang.setRowSelectionInterval(row, row);
        this.edit();
    }
    
    public void prev() {
        if (this.row > 0) {
            this.row--;
            tblkhachHang.setRowSelectionInterval(row, row);
            this.edit();
        }
    }
    
    public void next() {
        if (this.row < tblkhachHang.getRowCount() - 1) {
            this.row++;
            tblkhachHang.setRowSelectionInterval(row, row);
            this.edit();
        }
    }
    
    public void last() {
        this.row = tblkhachHang.getRowCount() - 1;
        tblkhachHang.setRowSelectionInterval(row, row);
        this.edit();
    }
    public void txtOFF(){
        txtmaKhachHang.setEditable(false);
        txttenKhachHang.setEditable(false);
        txtsoDienThoai.setEditable(false);
        txtdiaChi.setEditable(false);
    }
    
    public void txtON(){
         txtmaKhachHang.setEditable(true);
        txttenKhachHang.setEditable(true);
        txtsoDienThoai.setEditable(true);
        txtdiaChi.setEditable(true);
    }
    
    public boolean check(){
      if (txtmaKhachHang.getText().equals("") || txtmaKhachHang.getText().length() < 5 || txtmaKhachHang.getText().length() > 6) {
            MsgBox.alert(this, "Vui lòng nhập mã khách hàng từ 5---->6 kí tự");
            txtmaKhachHang.requestFocus();
            return false;
        } else if (txttenKhachHang.getText().length() == 0) {
            MsgBox.alert(this, "Tên khách hàng không được bỏ trống!!!");
            txttenKhachHang.requestFocus();
            return false;
        } else if (txtsoDienThoai.getText().equals("") || txtsoDienThoai.getText().length() < 9 || txtsoDienThoai.getText().length() > 10) {
            MsgBox.alert(this, "Vui lòng nhập số điện thoại từ 9---->10 kí tự");
            txtsoDienThoai.requestFocus();
            return false;
        } else if (txtdiaChi.getText().length() == 0) {
            MsgBox.alert(this, "Địa chỉ không được bỏ trống!!!");
            txtdiaChi.requestFocus();
            return false;
        }
        return true;
    }
    public void TimKiem() {
 DefaultTableModel model = (DefaultTableModel) tblkhachHang.getModel();
        model.setRowCount(0);
        try {
            String khh = txttimKiem.getText();
            List<KhachHang> list = dao.selectByKeyword(khh);
            for (KhachHang kh : list) {
                Object[] data = {
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getSDT(),
                    kh.getDiaChi(),
                    
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
}
