/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom4.ui;

import com.nhom4.dao.ChiTietSanPhamDAO;
import com.nhom4.dao.SanPhamDAO;
import com.nhom4.entity.ChiTietSanPham;
import com.nhom4.entity.SanPham;
import com.nhom4.utils.MsgBox;
import com.nhom4.utils.XImage;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hai
 */
public class SanPham1 extends javax.swing.JPanel {

    SanPhamDAO spDao = new SanPhamDAO();
    ChiTietSanPhamDAO ctspDAO = new ChiTietSanPhamDAO();
    JFileChooser fileChooser = new JFileChooser(".//src//com//nhom4//icon//");
    /**
     * Creates new form SanPham
     */
    int row = -1;
    int them = 0;

    public SanPham1() {
        initComponents();
        initTable();
        fillTable();
        this.row = -1;
        this.updateStatus();
        btnLuu.setEnabled(false);
        btnThem.setEnabled(true);
        this.updateStatus2();
        btnSave.setEnabled(false);
        btnReset.setEnabled(true);
        initTable2();
        fillTable2();

    }

    private void initTable() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        String[] cols = new String[]{"Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Mã NCC", "Ảnh", "Ghi Chú"};
        model.setColumnIdentifiers(cols);
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        try {
            List<SanPham> list = spDao.selectAll(); // Đọc dữ liệu từ CSDL
            for (SanPham sp : list) {
                Object[] data = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    sp.getMaNCC(),
                    sp.getAnh(),
                    sp.getGhiChu()
                };
                model.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    public void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblSanPham.getRowCount() - 1);
//        Trạng thái form
        btnThem.setEnabled(edit);
        btnUpdate.setEnabled(edit);
        btnXoa.setEnabled(edit);
// Trạng thái điều hướng
        btnFirst.setEnabled(edit && !first);
        btnPre.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
        txtOFF();
    }

    public void setForm(SanPham sp) {
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
        txtMaNCC.setText(sp.getMaNCC());
        txtGhiChu.setText(sp.getGhiChu());
        lblAnh.setToolTipText(sp.getAnh());
        if (sp.getAnh() != null) {
            lblAnh.setIcon(XImage.read(sp.getAnh()));
        }
    }

    SanPham getForm() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sp.setMaNCC(txtMaNCC.getText());
        sp.setGhiChu(txtGhiChu.getText());
        sp.setAnh(lblAnh.getToolTipText());
        return sp;
    }

    public void edit() {
        try {
            String masp = (String) tblSanPham.getValueAt(this.row, 0);
            SanPham sp = spDao.selectById(masp);
            if (sp != null) {
                this.setForm(sp);
                this.updateStatus();
            }

        } catch (Exception e) {
        }

    }

    void selectImage() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (XImage.save(file)) {
                // Hiển thị hình lên form
                lblAnh.setIcon(XImage.read(file.getName()));
                lblAnh.setToolTipText(file.getName());
            }
        }
    }

    void clearForm() {
        SanPham sp = new SanPham();
        this.setForm(sp);
        this.row = -1;
        this.updateStatus();
    }

    void insert() {
        SanPham sp = getForm();
        try {
            spDao.insert(sp);
            this.fillTable();
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

    public void delete() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa sản phẩm này")) {
            String msp = txtMaSP.getText();
            try {
                spDao.delete(msp);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }

    public void update() {
        SanPham sp = getForm();
        try {
            spDao.update(sp);
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

    boolean kiemTra() {
        if (txtMaSP.getText().equals("") || txtMaSP.getText().length() < 5 || txtMaSP.getText().length() > 6) {
            MsgBox.alert(this, "Vui lòng nhập mã sản phẩm từ 5---->6 kí tự");
            txtMaSP.requestFocus();
            return false;
        } else if (txtTenSP.getText().length() == 0) {
            MsgBox.alert(this, "Tên Sản Phẩm không được bỏ trống!!!");
            txtTenSP.requestFocus();
            return false;
        } else if (txtMaNCC.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập Mã Nhà Cung Cấp");
            txtMaNCC.requestFocus();
            return false;
        } else if (txtMaNCC.getText().length() < 3 || txtMaNCC.getText().length() > 8) {
            MsgBox.alert(this, "Mã nhà cung cấp từ 3---->8 kí tự");
            txtMaNCC.requestFocus();
            return false;
        } else if (lblAnh.getIcon() == null) {
            MsgBox.alert(this, "Bạn chưa chọn hình! click vào khu vực hình để chọn");
            return false;
        } else if (txtSoLuong.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập số lượng");
            txtSoLuong.requestFocus();
            return false;
        } else if (!txtSoLuong.getText().equals("")) {
            String sl = "";
            String tv = "";
            try {
                if (!txtSoLuong.getText().equals("")) {
                    int soluong = Integer.parseInt(txtSoLuong.getText());
                    if (soluong < 100) {
                        MsgBox.alert(this, "Số lượng phải >= 100");
                        txtSoLuong.requestFocus();
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                if (tv.equals(sl)) {
                    MsgBox.alert(this, "Số lượng là kiểu số nguyên");
                    txtSoLuong.requestFocus();
                    return false;
                }
            }
        }
        return true;
    }

    public void edit3() {
        try {
            String masp = (String) tblSanPham.getValueAt(this.row, 0);
            ChiTietSanPham ctsp = ctspDAO.selectByIdd(masp);
            if (ctsp != null) {
                this.setForm2(ctsp);
                tabs.setSelectedIndex(1);
                this.updateStatus();
            }

        } catch (Exception e) {
            MsgBox.alert(this, "Loi truy van du lieu");
        }

    }

    private void initTable2() {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        String[] cols = new String[]{"Mã Chi Tiết", "Mã Sản Phẩm", "Size", "Màu Sắc", "Chất Liệu", "Giá"};
        model.setColumnIdentifiers(cols);
    }

    public void fillTable2() {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        model.setRowCount(0);
        try {
            List<ChiTietSanPham> list = ctspDAO.selectAll(); // Đọc dữ liệu từ CSDL
            for (ChiTietSanPham ct : list) {
                Object[] data = {
                    ct.getMaCT(),
                    ct.getMaSP(),
                    ct.getSize(),
                    ct.getMauSac(),
                    ct.getChatLieu(),
                    ct.getGia()
                };
                model.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    public void setForm2(ChiTietSanPham ctsp) {
        txtMaCT.setText(ctsp.getMaCT());
        txtMaSPP.setText(ctsp.getMaSP());
        txtSize.setText(String.valueOf(ctsp.getSize()));
        txtMauSac.setText(ctsp.getMauSac());
        txtChatLieu.setText(ctsp.getChatLieu());
        txtGia.setText(String.valueOf(ctsp.getGia()));
    }

    ChiTietSanPham getForm2() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaCT(txtMaCT.getText());
        ctsp.setMaSP(txtMaSPP.getText());
        ctsp.setSize(Float.valueOf(txtSize.getText()));
        ctsp.setMauSac(txtMauSac.getText());
        ctsp.setGia(Float.valueOf(txtGia.getText()));
        ctsp.setChatLieu(txtChatLieu.getText());
        return ctsp;
    }

    public void updateStatus2() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblChiTietSp.getRowCount() - 1);
//        Trạng thái form
        btnSave.setEnabled(edit);
        btnCapNhat.setEnabled(edit);
        btnDelete.setEnabled(edit);
// Trạng thái điều hướng
        btnDau.setEnabled(edit && !first);
        btnLui.setEnabled(edit && !first);
        btnToi.setEnabled(edit && !last);
        btnCuoi.setEnabled(edit && !last);
        txtOFF2();
    }

    void clearForm2() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        this.setForm2(ctsp);
        this.row = -1;
        this.updateStatus2();
    }

    public void edit2() {
        try {
            String mact = (String) tblChiTietSp.getValueAt(this.row, 0);
            ChiTietSanPham ctsp = ctspDAO.selectById(mact);
            if (ctsp != null) {
                this.setForm2(ctsp);
                this.updateStatus2();
            }
        } catch (Exception e) {
        }

    }

    void insert2() {
        ChiTietSanPham ctsp = getForm2();
        try {
            ctspDAO.insert(ctsp);
            this.fillTable2();
            MsgBox.alert(this, "Thêm mới thành công");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        }
    }

    public void delete2() {
        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa chi tiết sản phẩm này")) {
            String mct = txtMaCT.getText();
            try {
                ctspDAO.delete(mct);
                this.fillTable2();
                this.clearForm2();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại");
            }
        }
    }

    public void update2() {
        ChiTietSanPham ctsp = getForm2();
        try {
            ctspDAO.update(ctsp);
            this.fillTable2();
            MsgBox.alert(this, "Cập nhật thành công");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        }
    }

    boolean kiemTra2() {
        if (txtMaCT.getText().equals("") || txtMaCT.getText().length() < 5 || txtMaCT.getText().length() > 6) {
            MsgBox.alert(this, "Vui lòng nhập mã chi tiết sản phẩm từ 5---->6 kí tự");
            txtMaCT.requestFocus();
            return false;
        } else if (txtMaSPP.getText().length() == 0) {
            MsgBox.alert(this, "Mã Sản Phẩm không được bỏ trống!!!");
            txtMaSPP.requestFocus();
            return false;
        } else if (txtMaSPP.getText().equals("") || txtMaSPP.getText().length() < 5 || txtMaSPP.getText().length() > 6) {
            MsgBox.alert(this, "Vui lòng nhập mã sản phẩm từ 5---->6 kí tự");
            txtMaSPP.requestFocus();
            return false;
        } else if (txtMauSac.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập màu sắc");
            txtMauSac.requestFocus();
            return false;
        } else if (txtChatLieu.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập chất liệu");
            txtChatLieu.requestFocus();
            return false;
        } else if (txtSize.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập size giày");
            txtSize.requestFocus();
            return false;
        } else if (txtGia.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập giá giày");
            txtGia.requestFocus();
            return false;
        } else if (!txtSize.getText().equals("")) {
            String size = "";
            String tv = "";
            String gia = "";
            try {
                if (!txtSize.getText().equals("") || !txtGia.getText().equals("")) {
                    float siZe = Float.parseFloat(txtSize.getText());
                    float Gia = Float.parseFloat(txtGia.getText());
                    if (siZe < 20) {
                        MsgBox.alert(this, "Size giày phải >= 20");
                        txtSize.requestFocus();
                        return false;
                    } else if (Gia < 100000) {
                        MsgBox.alert(this, "Giá giày phải >= 100K");
                        txtGia.requestFocus();
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                if (tv.equals(size)) {
                    MsgBox.alert(this, "Size giày và giá giày là kiểu số");
                    return false;
                }
            }
        }
        return true;
    }
    
    void timKiem(){
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        
    }

    public void txtOFF() {
        txtMaSP.setEditable(false);
        txtTenSP.setEditable(false);
    }

    public void txtON() {
        txtMaSP.setEditable(true);
        txtTenSP.setEditable(true);
    }

    public void txtOFF2() {
        txtMaCT.setEditable(false);
        txtMaSPP.setEditable(false);
    }

    public void txtON2() {
        txtMaCT.setEditable(true);
        txtMaSPP.setEditable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        lblAnh = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        txtMaNCC = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtTK = new javax.swing.JTextField();
        btnTK = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaCT = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMauSac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSPP = new javax.swing.JTextField();
        txtChatLieu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnHuyy = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblChiTietSp = new javax.swing.JTable();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnToi = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();

        tabs.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        btnTimKiem.setBackground(new java.awt.Color(102, 153, 255));
        btnTimKiem.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/search (4).png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Sản Phẩm");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Số Lượng");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã NCC");

        txtMaSP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Sản Phẩm");

        txtTenSP.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ghi Chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(51, 51, 51));
        btnThem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/add-button (1).png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/edit.png"))); // NOI18N
        btnUpdate.setText("Sửa");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(51, 51, 51));
        btnXoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/trash (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(51, 51, 51));
        btnLuu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/save-file.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(51, 51, 51));
        btnHuy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/cancel.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        txtMaNCC.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(txtSoLuong))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(txtMaNCC)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addGap(56, 56, 56)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate)
                    .addComponent(btnXoa))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tblSanPham.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanPhamMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);

        btnFirst.setBackground(new java.awt.Color(204, 255, 153));
        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow (1).png"))); // NOI18N
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setBackground(new java.awt.Color(204, 255, 153));
        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow.png"))); // NOI18N
        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(204, 255, 153));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow.png"))); // NOI18N
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(204, 255, 153));
        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow (1).png"))); // NOI18N
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPre)
                    .addComponent(btnFirst)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        tabs.addTab("Sản Phẩm", jPanel1);

        btnTK.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel5.setText("Mã CT");

        jLabel6.setText("Size");

        jLabel8.setText("Màu Sắc");

        jLabel9.setText("Mã Sản Phẩm");

        jLabel10.setText("Chất Liệu");

        jLabel11.setText("Giá");

        btnReset.setText("Thêm");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Sửa");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnHuyy.setText("Hủy");
        btnHuyy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSize)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel11))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnHuyy, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 174, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaCT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtMaSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel11))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyy, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        tblChiTietSp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblChiTietSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblChiTietSpMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblChiTietSp);

        btnDau.setText("|<");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnLui.setText("<<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        btnToi.setText(">>");
        btnToi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToiActionPerformed(evt);
            }
        });

        btnCuoi.setText(">|");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tabs.addTab("Chi Tiết Sản Phẩm", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblSanPham.getSelectedRow();
            this.edit();
        }
        if (evt.getClickCount() == 2) {
            this.row = tblSanPham.rowAtPoint(evt.getPoint());
            if (this.row >= 0) {
                this.edit3();
                //tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblSanPhamMousePressed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        this.row = 0;
        tblSanPham.setRowSelectionInterval(row, row);
        this.edit();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        if (this.row > 0) {
            this.row--;
            tblSanPham.setRowSelectionInterval(row, row);
            this.edit();
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (this.row < tblSanPham.getRowCount() - 1) {
            this.row++;
            tblSanPham.setRowSelectionInterval(row, row);
            this.edit();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        this.row = tblSanPham.getRowCount() - 1;
        tblSanPham.setRowSelectionInterval(row, row);
        this.edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblChiTietSpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSpMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblChiTietSp.getSelectedRow();
            this.edit2();
        }
    }//GEN-LAST:event_tblChiTietSpMousePressed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        this.row = 0;
        tblChiTietSp.setRowSelectionInterval(row, row);
        this.edit2();
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        if (this.row > 0) {
            this.row--;
            tblChiTietSp.setRowSelectionInterval(row, row);
            this.edit2();
        }
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnToiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToiActionPerformed
        if (this.row < tblChiTietSp.getRowCount() - 1) {
            this.row++;
            tblChiTietSp.setRowSelectionInterval(row, row);
            this.edit2();
        }
    }//GEN-LAST:event_btnToiActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        this.row = tblChiTietSp.getRowCount() - 1;
        tblChiTietSp.setRowSelectionInterval(row, row);
        this.edit2();
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (kiemTra() == true) {
            if (them == 1) {
                insert();
                return;
            }
            if (them == 2) {
                update();
                return;
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        them = 2;
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(true);
        txtON();
        txtMaSP.setEditable(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        this.selectImage();
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them = 1;
        btnUpdate.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(true);
        txtMaSP.setText("");
        txtTenSP.setText("");
        txtMaNCC.setText("");
        txtSoLuong.setText("");
        txtGhiChu.setText("");
        txtON();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        updateStatus();
        clearForm();
        btnLuu.setEnabled(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        them = 1;
        btnCapNhat.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(true);
        txtMaCT.setText("");
        txtMaSPP.setText("");
        txtChatLieu.setText("");
        txtSize.setText("");
        txtGia.setText("");
        txtMauSac.setText("");
        txtON2();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (kiemTra2() == true) {
            if (them == 1) {
                insert2();
                return;
            }
            if (them == 2) {
                update2();
                return;
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHuyyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyyActionPerformed
        updateStatus2();
        clearForm2();
        btnSave.setEnabled(false);
    }//GEN-LAST:event_btnHuyyActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        them = 2;
        btnReset.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(true);
        txtON2();
        txtMaCT.setEditable(false);
        txtMaSPP.setEditable(false);
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete2();
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuyy;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTK;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnToi;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JLabel lblAnh;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblChiTietSp;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtChatLieu;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaCT;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaSPP;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
