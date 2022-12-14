/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom4.ui;

import com.nhom4.dao.ChiTietSanPhamDAO;
import com.nhom4.dao.SanPhamDAO;
import com.nhom4.entity.ChiTietSanPham;
import com.nhom4.entity.SanPham;
import com.nhom4.utils.Auth;
import com.nhom4.utils.MsgBox;
import com.nhom4.utils.XImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hai
 */
public class SanPham1 extends javax.swing.JPanel {

    SanPhamDAO spDao = new SanPhamDAO();
    ChiTietSanPhamDAO ctspDAO = new ChiTietSanPhamDAO();
    JFileChooser fileChooser = new JFileChooser("hinh");
    ArrayList<SanPham> splist = new ArrayList<>();
    ArrayList<ChiTietSanPham> ctlist = new ArrayList<>();
    /**
     * Creates new form SanPham
     */
    int row = -1;
    int them = 0;
    int checklap = 0;
    String anh = "hinh/default.png";

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
        fillCboMaNCC();
        fillCboMaSP();
        setFont(btnHuy);
        setFont(btnThem);
        setFont(btnHuy);
        setFont(btnXoa);
        setFont(btnLuu);
        setFont(btnReset);
        setFont(btnHuyy);
        setFont(btnDelete);
        setFont(btnSave);
        setFont(btnUpdate);
        setFont(btnCapNhat);
    }

    public void setFont(JButton bt) {
        bt.setFont(getFont().deriveFont(Font.BOLD, 18));
    }

    private void initTable() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        String[] cols = new String[]{"M?? S???n Ph???m", "T??n S???n Ph???m", "S??? L?????ng", "M?? NCC", "???nh", "Ghi Ch??"};
        model.setColumnIdentifiers(cols);
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        splist.clear();
        try {
            List<SanPham> list = spDao.selectAll(); // ?????c d??? li???u t??? CSDL
            for (SanPham sp : list) {
                Object[] data = {
                    sp.getMaSP(),
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    sp.getMaNCC(),
                    sp.getAnh(),
                    sp.getGhiChu()
                };
                splist.add(sp);
                model.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    public void fillTable3() {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        model.setRowCount(0);
        ctlist.clear();
        try {
            List<ChiTietSanPham> list = ctspDAO.selectAll(); // ?????c d??? li???u t??? CSDL
            for (ChiTietSanPham ct : list) {
                Object[] data = {
                    ct.getMaCT(),
                    ct.getMaSP(),
                    ct.getSize(),
                    ct.getMauSac(),
                    ct.getChatLieu(),
                    ct.getGia()
                };
                ctlist.add(ct);
                model.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    public void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblSanPham.getRowCount() - 1);
//        Tr???ng th??i form
        btnThem.setEnabled(edit);
        btnUpdate.setEnabled(edit);
        btnXoa.setEnabled(edit);
// Tr???ng th??i ??i???u h?????ng
        btnFirst.setEnabled(edit && !first);
        btnPre.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
        txtOFF();
    }

    private void fillCboMaNCC() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaNCC.getModel();
        model.removeAllElements();
        List<String> list = spDao.selectMaNCC();
        for (String nv : list) {
            model.addElement(nv);
        }
    }

    private void fillCboMaSP() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaSP.getModel();
        model.removeAllElements();
        List<String> list = ctspDAO.selectMaSP();
        for (String nv : list) {
            model.addElement(nv);
        }
    }

    public void setForm(SanPham sp) {
        txtMaSP.setText(sp.getMaSP());
        txtTenSP.setText(sp.getTenSP());
        txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
        cboMaNCC.setSelectedItem(sp.getMaNCC());
        txtGhiChu.setText(sp.getGhiChu());
        lblAnh.setToolTipText(sp.getAnh());
        if (sp.getAnh() != null) {
            lblAnh.setIcon(XImage.read(sp.getAnh()));
            lblAnh.setToolTipText(sp.getAnh());
        }
    }

    SanPham getForm() {
        SanPham sp = new SanPham();
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        sp.setMaNCC(cboMaNCC.getSelectedItem().toString());
        sp.setGhiChu(txtGhiChu.getText());
        sp.setAnh(lblAnh.getToolTipText());
        sp.setXoa(true);
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
                // Hi???n th??? h??nh l??n form
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
            MsgBox.alert(this, "Th??m m???i th??nh c??ng");
            updateStatus();
            this.clearForm();
            fillCboMaSP();
            them = 0;
            btnLuu.setEnabled(false);
        } catch (Exception e) {
            MsgBox.alert(this, "Th??m m???i th???t b???i");
            System.out.println(e);
            updateStatus();
            them = 0;
            btnLuu.setEnabled(false);
        }
    }

    public void delete() {
        if (MsgBox.confirm(this, "B???n th???c s??? mu???n x??a s???n ph???m n??y")) {
            String msp = txtMaSP.getText();
            int i = tblSanPham.getSelectedRow();
            String key = tblSanPham.getValueAt(i, 0).toString();
            try {
                ctspDAO.deletebByMaSP(key);
                spDao.delete(key);
                this.fillTable();
                ImageIcon icon = new ImageIcon("hinh/default.png");
                lblAnh.setIcon(icon);
                this.clearForm();
                btnThem.setEnabled(true);
                this.fillTable3();
                MsgBox.alert(this, "X??a th??nh c??ng");
            } catch (Exception e) {
                MsgBox.alert(this, "X??a th???t b???i");
            }
        }
    }

    public void update() {
        SanPham sp = getForm();
        try {
            spDao.update(sp);
            this.fillTable();
            MsgBox.alert(this, "C???p nh???t th??nh c??ng");
            updateStatus();
            them = 0;
            btnLuu.setEnabled(false);
        } catch (Exception e) {
            MsgBox.alert(this, "C???p nh???t th???t b???i");
            updateStatus();
            them = 0;
            btnLuu.setEnabled(false);
        }
    }

    boolean kiemTra() {
        boolean checklap = true;
        List<String> listMaSP = spDao.selectMaSP();
        for (int i = 0; i < listMaSP.size(); i++) {
            if (listMaSP.get(i).equalsIgnoreCase(txtMaSP.getText())) {
                checklap = false;
            }
        }
        ImageIcon icon = new ImageIcon("hinh/default.png");

        if (txtMaSP.getText().equals("") || txtMaSP.getText().length() < 5 || txtMaSP.getText().length() > 6) {
            MsgBox.alert(this, "Vui l??ng nh???p m?? s???n ph???m t??? 5---->6 k?? t???");
            txtMaSP.requestFocus();
            return false;
        } else if (them == 1 && checklap == false) {
            MsgBox.alert(this, "M?? s???n ph???m ???? t???n t???i ho???c b??? ???n ??i. Vui l??ng nh???p m?? m???i");
            txtMaSP.requestFocus();
            checklap = false;
            return false;
        } else if (txtTenSP.getText().length() == 0) {
            MsgBox.alert(this, "T??n S???n Ph???m kh??ng ???????c b??? tr???ng!!!");
            txtTenSP.requestFocus();
            return false;
        } else if (txtSoLuong.getText().equals("")) {
            MsgBox.alert(this, "Vui l??ng nh???p s??? l?????ng");
            txtSoLuong.requestFocus();
            return false;
        } else if (lblAnh.getIcon() == null) {
            MsgBox.alert(this, "B???n ch??a ch???n h??nh! click v??o khu v???c h??nh ????? ch???n");
            return false;
        } else if (!txtSoLuong.getText().equals("")) {
            String sl = "";
            String tv = "";
            try {
                if (!txtSoLuong.getText().equals("")) {
                    int soluong = Integer.parseInt(txtSoLuong.getText());
                    if (soluong <= 0) {
                        MsgBox.alert(this, "S??? l?????ng ph???i > 0");
                        txtSoLuong.requestFocus();
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                if (tv.equals(sl)) {
                    MsgBox.alert(this, "S??? l?????ng l?? ki???u s??? nguy??n");
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
                this.updateStatus2();
            }

        } catch (Exception e) {
            MsgBox.alert(this, "Loi truy van du lieu");
        }

    }

    private void initTable2() {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        String[] cols = new String[]{"M?? Chi Ti???t", "M?? S???n Ph???m", "Size", "M??u S???c", "Ch???t Li???u", "Gi??"};
        model.setColumnIdentifiers(cols);
    }

    public void fillTable2() {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        model.setRowCount(0);
        ctlist.clear();
        try {
            String id = txtMaSP.getText();
            List<ChiTietSanPham> list = ctspDAO.selectByKeyword(id); // ?????c d??? li???u t??? CSDL
            for (ChiTietSanPham ct : list) {
                Object[] data = {
                    ct.getMaCT(),
                    ct.getMaSP(),
                    ct.getSize(),
                    ct.getMauSac(),
                    ct.getChatLieu(),
                    ct.getGia()
                };
                ctlist.add(ct);
                model.addRow(data);
            }
        } catch (Exception e) {
        }
    }

    public void setForm2(ChiTietSanPham ctsp) {
        txtMaCT.setText(ctsp.getMaCT());
        cboMaSP.setSelectedItem(ctsp.getMaSP());
        txtSize.setText(String.valueOf(ctsp.getSize()));
        txtMauSac.setText(ctsp.getMauSac());
        txtChatLieu.setText(ctsp.getChatLieu());
        txtGia.setText(String.valueOf(ctsp.getGia()));
    }

    ChiTietSanPham getForm2() {
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setMaCT(txtMaCT.getText());
        ctsp.setMaSP(cboMaSP.getSelectedItem().toString());
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
//        Tr???ng th??i form
        btnReset.setEnabled(edit);
        btnCapNhat.setEnabled(edit);
        btnDelete.setEnabled(edit);
// Tr???ng th??i ??i???u h?????ng
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
            this.fillTable3();
            MsgBox.alert(this, "Th??m m???i th??nh c??ng");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        } catch (Exception e) {
            MsgBox.alert(this, "Th??m m???i th???t b???i");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        }
    }

    public void delete2() {
        if (MsgBox.confirm(this, "B???n th???c s??? mu???n x??a chi ti???t s???n ph???m n??y")) {
            String mct = txtMaCT.getText();
            try {
                ctspDAO.delete(mct);
                this.fillTable3();
                this.clearForm2();
                MsgBox.alert(this, "X??a th??nh c??ng");
            } catch (Exception e) {
                MsgBox.alert(this, "X??a th???t b???i");
            }
        }
    }

    public void update2() {
        ChiTietSanPham ctsp = getForm2();
        try {
            ctspDAO.update(ctsp);
            this.fillTable2();
            MsgBox.alert(this, "C???p nh???t th??nh c??ng");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        } catch (Exception e) {
            MsgBox.alert(this, "C???p nh???t th???t b???i");
            updateStatus2();
            them = 0;
            btnSave.setEnabled(false);
        }
    }

    boolean kiemTra2() {
        for (int i = 0; i < ctlist.size(); i++) {
            if (ctlist.get(i).getMaCT().equalsIgnoreCase(txtMaCT.getText())) {
                checklap = 1;
            }
        }

        if (txtMaCT.getText().equals("") || txtMaCT.getText().length() < 5 || txtMaCT.getText().length() > 6) {
            MsgBox.alert(this, "Vui l??ng nh???p m?? chi ti???t s???n ph???m t??? 5---->6 k?? t???");
            txtMaCT.requestFocus();
            return false;
        } else if (them == 1 && checklap == 1) {
            MsgBox.alert(this, "M?? chi ti???t s???n ph???m ???? t???n t???i. Vui l??ng nh???p m?? m???i");
            txtMaCT.requestFocus();
            checklap = 0;
            return false;
        } else if (txtChatLieu.getText().equals("")) {
            MsgBox.alert(this, "Vui l??ng nh???p ch???t li???u");
            txtChatLieu.requestFocus();
            return false;
        } else if (txtMauSac.getText().equals("")) {
            MsgBox.alert(this, "Vui l??ng nh???p m??u s???c");
            txtMauSac.requestFocus();
            return false;
        } else if (txtSize.getText().equals("")) {
            MsgBox.alert(this, "Vui l??ng nh???p size gi??y");
            txtSize.requestFocus();
            return false;
        } else if (txtGia.getText().equals("")) {
            MsgBox.alert(this, "Vui l??ng nh???p gi?? gi??y");
            txtGia.requestFocus();
            return false;
        } else if (!txtSize.getText().equals("")) {
            String size = "";
            String tv = "";
            try {
                if (!txtSize.getText().equals("") || !txtGia.getText().equals("")) {
                    float siZe = Float.parseFloat(txtSize.getText());
                    float Gia = Float.parseFloat(txtGia.getText());
                    if (siZe <= 0) {
                        MsgBox.alert(this, "Size gi??y ph???i > 0");
                        txtSize.requestFocus();
                        return false;
                    } else if (Gia < 50000) {
                        MsgBox.alert(this, "Gi?? gi??y ph???i >= 50K");
                        txtGia.requestFocus();
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e) {
                if (tv.equals(size)) {
                    MsgBox.alert(this, "Size gi??y v?? gi?? gi??y l?? ki???u s???");
                    return false;
                }
            }
        }
        return true;
    }

    public void TimKiem() {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        try {
            String key = txtTimKiem.getText();
            List<SanPham> list = spDao.selectByKeyword2(key);
            for (SanPham nh : list) {
                Object[] data = {
                    nh.getMaSP(),
                    nh.getTenSP(),
                    nh.getSoLuong(),
                    nh.getMaNCC(),
                    nh.getAnh(),
                    nh.getGhiChu(),};
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, e.getMessage());
        }
        this.clearForm();
        this.row = -1;
        updateStatus();
    }

    public void TimKiem2() {
        DefaultTableModel model = (DefaultTableModel) tblChiTietSp.getModel();
        model.setRowCount(0);
        try {
            String key = txtTK.getText();
            List<ChiTietSanPham> list = ctspDAO.selectByKeyword(key);

            for (ChiTietSanPham nh : list) {
                Object[] data = {
                    nh.getMaCT(),
                    nh.getMaSP(),
                    nh.getMauSac(),
                    nh.getChatLieu(),
                    nh.getSize(),
                    nh.getGia(),};
                model.addRow(data);
            }
        } catch (Exception e) {
            MsgBox.alert(this, e.getMessage());
        }
        this.clearForm2();
        this.row = -1;
        updateStatus2();
    }

    public void txtOFF() {
        txtMaSP.setEditable(false);
        txtTenSP.setEditable(false);
        txtSoLuong.setEditable(false);
        cboMaNCC.setEnabled(false);
        txtGhiChu.setEditable(false);
    }

    public void txtON() {
        txtMaSP.setEditable(true);
        txtTenSP.setEditable(true);
        txtSoLuong.setEditable(true);
        cboMaNCC.setEnabled(true);
        txtGhiChu.setEditable(true);
    }

    public void txtOFF2() {
        txtMaCT.setEditable(false);
        cboMaSP.setEnabled(false);
        txtChatLieu.setEditable(false);
        txtGia.setEditable(false);
        txtMauSac.setEditable(false);
        txtSize.setEditable(false);

    }

    public void txtON2() {
        txtMaCT.setEditable(true);
        cboMaSP.setEnabled(true);
        txtChatLieu.setEditable(true);
        txtGia.setEditable(true);
        txtMauSac.setEditable(true);
        txtSize.setEditable(true);
    }

    public void deleteAn() {
        String maSP = txtMaSP.getText();
        try {
            spDao.hide(maSP);
            MsgBox.alert(this, "An th??nh c??ng");
            this.fillTable();
            ImageIcon icon = new ImageIcon("hinh/default.png");
            lblAnh.setIcon(icon);
            this.clearForm();
        } catch (Exception e) {
            MsgBox.alert(this, "An th???t b???i");
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

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pnlSl = new javax.swing.JPanel();
        pnlTen = new javax.swing.JPanel();
        txtTenSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        lblAnh = new javax.swing.JLabel();
        cboMaNCC = new javax.swing.JComboBox<>();
        pnlma = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new com.nhom4.ui.Table();
        btnThem = new com.nhom4.ui.ButtonCustom();
        btnUpdate = new com.nhom4.ui.ButtonCustom();
        btnHuy = new com.nhom4.ui.ButtonCustom();
        btnXoa = new com.nhom4.ui.ButtonCustom();
        btnLuu = new com.nhom4.ui.ButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblTK = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        btnTK = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMaCT = new javax.swing.JTextField();
        txtSize = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMauSac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtChatLieu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboMaSP = new javax.swing.JComboBox<>();
        btnSave = new com.nhom4.ui.ButtonCustom();
        btnHuyy = new com.nhom4.ui.ButtonCustom();
        btnDelete = new com.nhom4.ui.ButtonCustom();
        btnReset = new com.nhom4.ui.ButtonCustom();
        btnCapNhat = new com.nhom4.ui.ButtonCustom();
        pnlGia = new javax.swing.JPanel();
        pnlSize = new javax.swing.JPanel();
        pnlMau = new javax.swing.JPanel();
        pnlChatL = new javax.swing.JPanel();
        pnlMaCT = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnToi = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietSp = new com.nhom4.ui.Table();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        tabs.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/recycle-bin1.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTimKiem.setForeground(new java.awt.Color(102, 102, 102));
        lblTimKiem.setText("T??m ki???m theo t??n");
        jPanel3.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        txtTimKiem.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtTimKiem.setBorder(null);
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyTyped(evt);
            }
        });
        jPanel3.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 639, 40));

        btnTimKiem.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/search (4).png"))); // NOI18N
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel3.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 60, 40));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 670, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(195, 195, 195)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("M?? S???n Ph???m");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setText("S??? L?????ng");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel3.setText("M?? NCC");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        txtMaSP.setBackground(new java.awt.Color(245, 245, 245));
        txtMaSP.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtMaSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtMaSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaSPFocusLost(evt);
            }
        });
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });
        jPanel4.add(txtMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 320, 40));

        txtSoLuong.setBackground(new java.awt.Color(245, 245, 245));
        txtSoLuong.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtSoLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtSoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoLuongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoLuongFocusLost(evt);
            }
        });
        jPanel4.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 320, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setText("T??n S???n Ph???m");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        javax.swing.GroupLayout pnlSlLayout = new javax.swing.GroupLayout(pnlSl);
        pnlSl.setLayout(pnlSlLayout);
        pnlSlLayout.setHorizontalGroup(
            pnlSlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSlLayout.setVerticalGroup(
            pnlSlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(pnlSl, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 320, 3));

        javax.swing.GroupLayout pnlTenLayout = new javax.swing.GroupLayout(pnlTen);
        pnlTen.setLayout(pnlTenLayout);
        pnlTenLayout.setHorizontalGroup(
            pnlTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTenLayout.setVerticalGroup(
            pnlTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(pnlTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 99, 320, 3));

        txtTenSP.setBackground(new java.awt.Color(245, 245, 245));
        txtTenSP.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTenSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtTenSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenSPFocusLost(evt);
            }
        });
        jPanel4.add(txtTenSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 320, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel7.setText("Ghi Ch??");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 66, -1));

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 750, 90));

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/default.png"))); // NOI18N
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });
        jPanel4.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, 180, 170));

        cboMaNCC.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cboMaNCC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.add(cboMaNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 320, 40));

        javax.swing.GroupLayout pnlmaLayout = new javax.swing.GroupLayout(pnlma);
        pnlma.setLayout(pnlmaLayout);
        pnlmaLayout.setHorizontalGroup(
            pnlmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlmaLayout.setVerticalGroup(
            pnlmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(pnlma, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 320, 3));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(195, 195, 195)));

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow (1).png"))); // NOI18N
        btnFirst.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow.png"))); // NOI18N
        btnPre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow.png"))); // NOI18N
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow (1).png"))); // NOI18N
        btnLast.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblSanPhamMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNext)
                    .addComponent(btnLast)
                    .addComponent(btnPre)
                    .addComponent(btnFirst))
                .addGap(20, 20, 20))
        );

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/add2.png"))); // NOI18N
        btnThem.setText("Th??m");
        btnThem.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/editing.png"))); // NOI18N
        btnUpdate.setText("S???a");
        btnUpdate.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/delete.png"))); // NOI18N
        btnHuy.setText("H???y");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bin-with-lid.png"))); // NOI18N
        btnXoa.setText("X??a");
        btnXoa.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/diskette.png"))); // NOI18N
        btnLuu.setText("L??u");
        btnLuu.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(34, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("S???n Ph???m", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTK.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTK.setForeground(new java.awt.Color(102, 102, 102));
        lblTK.setText("T??m ki???m theo m?? s???n ph???m");
        jPanel6.add(lblTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtTK.setBorder(null);
        txtTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTKKeyTyped(evt);
            }
        });
        jPanel6.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 677, 50));

        btnTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/search (4).png"))); // NOI18N
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });
        jPanel6.add(btnTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 70, 50));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 710, 3));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(195, 195, 195)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(14, 65, 91));
        jLabel5.setText("M?? CT");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 60, -1));

        txtMaCT.setBackground(new java.awt.Color(245, 245, 245));
        txtMaCT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMaCT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtMaCT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaCTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaCTFocusLost(evt);
            }
        });
        jPanel7.add(txtMaCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 380, 40));

        txtSize.setBackground(new java.awt.Color(245, 245, 245));
        txtSize.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtSize.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSizeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSizeFocusLost(evt);
            }
        });
        jPanel7.add(txtSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 380, 40));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(14, 65, 91));
        jLabel6.setText("Size");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        txtMauSac.setBackground(new java.awt.Color(245, 245, 245));
        txtMauSac.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMauSac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtMauSac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMauSacFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMauSacFocusLost(evt);
            }
        });
        jPanel7.add(txtMauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 380, 40));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(14, 65, 91));
        jLabel8.setText("M??u S???c");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(14, 65, 91));
        jLabel9.setText("M?? S???n Ph???m");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, -1));

        txtChatLieu.setBackground(new java.awt.Color(245, 245, 245));
        txtChatLieu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtChatLieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtChatLieu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtChatLieuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtChatLieuFocusLost(evt);
            }
        });
        jPanel7.add(txtChatLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 380, 40));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(14, 65, 91));
        jLabel10.setText("Ch???t Li???u");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        txtGia.setBackground(new java.awt.Color(245, 245, 245));
        txtGia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(245, 245, 245), 2));
        txtGia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaFocusLost(evt);
            }
        });
        jPanel7.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 380, 40));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(14, 65, 91));
        jLabel11.setText("Gi??");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        cboMaSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel7.add(cboMaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 380, 40));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/diskette.png"))); // NOI18N
        btnSave.setText("L??u");
        btnSave.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel7.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 300, 50));

        btnHuyy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/delete.png"))); // NOI18N
        btnHuyy.setText("H???y");
        btnHuyy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyyActionPerformed(evt);
            }
        });
        jPanel7.add(btnHuyy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 300, 50));

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/bin-with-lid.png"))); // NOI18N
        btnDelete.setText("X??a");
        btnDelete.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel7.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 195, 50));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/add2.png"))); // NOI18N
        btnReset.setText("Th??m");
        btnReset.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel7.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 195, 50));

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/editing.png"))); // NOI18N
        btnCapNhat.setText("S???a");
        btnCapNhat.setStyle(com.nhom4.ui.ButtonCustom.ButtonStyle.SECONDARY);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel7.add(btnCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 420, 195, 50));

        javax.swing.GroupLayout pnlGiaLayout = new javax.swing.GroupLayout(pnlGia);
        pnlGia.setLayout(pnlGiaLayout);
        pnlGiaLayout.setHorizontalGroup(
            pnlGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGiaLayout.setVerticalGroup(
            pnlGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(pnlGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 380, 3));

        javax.swing.GroupLayout pnlSizeLayout = new javax.swing.GroupLayout(pnlSize);
        pnlSize.setLayout(pnlSizeLayout);
        pnlSizeLayout.setHorizontalGroup(
            pnlSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSizeLayout.setVerticalGroup(
            pnlSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(pnlSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 380, 3));

        javax.swing.GroupLayout pnlMauLayout = new javax.swing.GroupLayout(pnlMau);
        pnlMau.setLayout(pnlMauLayout);
        pnlMauLayout.setHorizontalGroup(
            pnlMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMauLayout.setVerticalGroup(
            pnlMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(pnlMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 380, 3));

        javax.swing.GroupLayout pnlChatLLayout = new javax.swing.GroupLayout(pnlChatL);
        pnlChatL.setLayout(pnlChatLLayout);
        pnlChatLLayout.setHorizontalGroup(
            pnlChatLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlChatLLayout.setVerticalGroup(
            pnlChatLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(pnlChatL, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 380, 3));

        javax.swing.GroupLayout pnlMaCTLayout = new javax.swing.GroupLayout(pnlMaCT);
        pnlMaCT.setLayout(pnlMaCTLayout);
        pnlMaCTLayout.setHorizontalGroup(
            pnlMaCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMaCTLayout.setVerticalGroup(
            pnlMaCTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(pnlMaCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 380, 3));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(14, 65, 91));
        jLabel12.setText("Thong Tin San Pham");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 210, 50));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(195, 195, 195)));

        btnToi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow.png"))); // NOI18N
        btnToi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToiActionPerformed(evt);
            }
        });

        btnCuoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/right-arrow (1).png"))); // NOI18N
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(tblChiTietSp);

        btnDau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow (1).png"))); // NOI18N
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnLui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/left-arrow.png"))); // NOI18N
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(14, 65, 91));
        jLabel13.setText("Danh Sach San Pham");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnToi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tabs.addTab("Chi Ti???t S???n Ph???m", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs))
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
        TimKiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

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

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        this.selectImage();
    }//GEN-LAST:event_lblAnhMouseClicked

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        TimKiem2();
    }//GEN-LAST:event_btnTKActionPerformed

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyTyped
        if (txtTimKiem.getText().equals("")) {
            lblTimKiem.setVisible(true);
        } else {
            lblTimKiem.setVisible(false);
        }
    }//GEN-LAST:event_txtTimKiemKeyTyped

    private void txtTKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTKKeyTyped
        if (txtTK.getText().equals("")) {
            lblTK.setVisible(true);
        } else {
            lblTK.setVisible(false);
        }
    }//GEN-LAST:event_txtTKKeyTyped

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        them = 1;
        btnUpdate.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(true);
        txtMaSP.setText("");
        txtTenSP.setText("");
        cboMaNCC.setSelectedIndex(0);
        txtSoLuong.setText("");
        txtGhiChu.setText("");
        lblAnh.setIcon(null);
//        ImageIcon icon = new ImageIcon("hinh/default.png");
//        lblAnh.setIcon(icon);
        txtON();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        them = 2;
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        btnLuu.setEnabled(true);
        txtON();
        txtMaSP.setEditable(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        updateStatus();
        clearForm();
        ImageIcon icon = new ImageIcon("hinh/default.png");
        lblAnh.setIcon(icon);
        btnLuu.setEnabled(false);
        btnThem.setEnabled(true);
        fillTable();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        Object[] options = {"An", "Xoa"};
        int n = JOptionPane.showOptionDialog(this, "B???n mu???n xoa ki???u n??o?", "Th??ng b??o x??c nh???n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        try {
            if (options[n] == "An") {

                deleteAn();
            } else {
                delete();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Ban Chua chon");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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

    private void tblSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblSanPham.getSelectedRow();
            fillCboMaNCC();
            this.edit();
        }
        if (evt.getClickCount() == 2) {
            tabs.setSelectedComponent(jPanel2);
            fillTable2();
        }
    }//GEN-LAST:event_tblSanPhamMousePressed

    private void txtMaSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSPFocusGained
        txtMaSP.setBackground(Color.WHITE);
        pnlma.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtMaSPFocusGained

    private void txtMaSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSPFocusLost
        txtMaSP.setBackground(new Color(242, 242, 242));
        pnlma.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtMaSPFocusLost

    private void txtTenSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenSPFocusGained
        txtTenSP.setBackground(Color.WHITE);
        pnlTen.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtTenSPFocusGained

    private void txtTenSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenSPFocusLost
        txtTenSP.setBackground(new Color(242, 242, 242));
        pnlTen.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtTenSPFocusLost

    private void txtSoLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongFocusGained
        txtSoLuong.setBackground(Color.WHITE);
        pnlSl.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtSoLuongFocusGained

    private void txtSoLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongFocusLost
        txtSoLuong.setBackground(new Color(242, 242, 242));
        pnlSl.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtSoLuongFocusLost

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
        fillTable3();
        btnSave.setEnabled(false);
        btnReset.setEnabled(true);
    }//GEN-LAST:event_btnHuyyActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete2();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        them = 1;
        fillTable3();
        btnCapNhat.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(true);
        txtMaCT.setText("");
        cboMaSP.setSelectedIndex(0);
        txtChatLieu.setText("");
        txtSize.setText("");
        txtGia.setText("");
        txtMauSac.setText("");
        txtON2();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        them = 2;
        btnReset.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(true);
        txtON2();
        txtMaCT.setEditable(false);
        cboMaSP.setEnabled(false);
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtMaCTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaCTFocusGained
        txtMaCT.setBackground(Color.WHITE);
        pnlMaCT.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtMaCTFocusGained

    private void txtMaCTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaCTFocusLost
        txtMaCT.setBackground(new Color(242, 242, 242));
        pnlMaCT.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtMaCTFocusLost

    private void txtChatLieuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChatLieuFocusGained
        txtChatLieu.setBackground(Color.WHITE);
        pnlChatL.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtChatLieuFocusGained

    private void txtChatLieuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtChatLieuFocusLost
        txtChatLieu.setBackground(new Color(242, 242, 242));
        pnlChatL.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtChatLieuFocusLost

    private void txtMauSacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMauSacFocusGained
        txtMauSac.setBackground(Color.WHITE);
        pnlMau.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtMauSacFocusGained

    private void txtMauSacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMauSacFocusLost
        txtMauSac.setBackground(new Color(242, 242, 242));
        pnlMau.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtMauSacFocusLost

    private void txtSizeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSizeFocusGained
        txtSize.setBackground(Color.WHITE);
        pnlSize.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtSizeFocusGained

    private void txtSizeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSizeFocusLost
        txtSize.setBackground(new Color(242, 242, 242));
        pnlSize.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtSizeFocusLost

    private void txtGiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaFocusGained
        txtGia.setBackground(Color.WHITE);
        pnlGia.setBackground(new Color(58, 136, 145));
    }//GEN-LAST:event_txtGiaFocusGained

    private void txtGiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaFocusLost
        txtGia.setBackground(new Color(242, 242, 242));
        pnlGia.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_txtGiaFocusLost

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        if (Auth.islogin()) {
            LichSuXoa ls = new LichSuXoa();
            ls.changePan(3);
            ls.setVisible(true);

        } else {
            MsgBox.alert(this, "Vui l??ng ????ng nh???p");
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void tblChiTietSpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSpMousePressed
        if (evt.getClickCount() == 1) {
            this.row = tblChiTietSp.getSelectedRow();
            fillCboMaSP();
            this.edit2();
        }
    }//GEN-LAST:event_tblChiTietSpMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.nhom4.ui.ButtonCustom btnCapNhat;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private com.nhom4.ui.ButtonCustom btnDelete;
    private javax.swing.JButton btnFirst;
    private com.nhom4.ui.ButtonCustom btnHuy;
    private com.nhom4.ui.ButtonCustom btnHuyy;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLui;
    private com.nhom4.ui.ButtonCustom btnLuu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private com.nhom4.ui.ButtonCustom btnReset;
    private com.nhom4.ui.ButtonCustom btnSave;
    private javax.swing.JButton btnTK;
    private com.nhom4.ui.ButtonCustom btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnToi;
    private com.nhom4.ui.ButtonCustom btnUpdate;
    private com.nhom4.ui.ButtonCustom btnXoa;
    private javax.swing.JComboBox<String> cboMaNCC;
    private javax.swing.JComboBox<String> cboMaSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblTK;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel pnlChatL;
    private javax.swing.JPanel pnlGia;
    private javax.swing.JPanel pnlMaCT;
    private javax.swing.JPanel pnlMau;
    private javax.swing.JPanel pnlSize;
    private javax.swing.JPanel pnlSl;
    private javax.swing.JPanel pnlTen;
    private javax.swing.JPanel pnlma;
    private javax.swing.JTabbedPane tabs;
    private com.nhom4.ui.Table tblChiTietSp;
    private com.nhom4.ui.Table tblSanPham;
    private javax.swing.JTextField txtChatLieu;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaCT;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
