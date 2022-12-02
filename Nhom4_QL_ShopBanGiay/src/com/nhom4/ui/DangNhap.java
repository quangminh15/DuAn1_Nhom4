/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.nhom4.ui;

import com.nhom4.dao.TaiKhoanDAO;
import com.nhom4.entity.NhanVien;
import com.nhom4.entity.TaiKhoan;
import com.nhom4.utils.Auth;
import com.nhom4.utils.MsgBox;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author ACER
 */
public class DangNhap extends javax.swing.JDialog {
    TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    /**
     * Creates new form DangNhap
     */
    public DangNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        
    }
    
    class jPanelGradient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(234, 74, 107);
            Color color2 = new Color(114, 113, 193);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
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

        jPanel1 = new jPanelGradient();
        pnlForm = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        lblMatKhau = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txtMatKhau2 = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblOut = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ĐĂNG NHẬP");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 600));

        pnlForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("ĐĂNG NHẬP");
        pnlForm.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 240, 39));

        lblUserName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(102, 102, 102));
        lblUserName.setText("Ten Dang Nhap");
        pnlForm.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, 30));

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(51, 51, 51));
        txtMaNV.setText("nguyenvana");
        txtMaNV.setBorder(null);
        txtMaNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaNVFocusLost(evt);
            }
        });
        txtMaNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaNVMouseClicked(evt);
            }
        });
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });
        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaNVKeyTyped(evt);
            }
        });
        pnlForm.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 460, 50));

        lblMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(102, 102, 102));
        lblMatKhau.setText("Mat Khau");
        pnlForm.add(lblMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/view.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        pnlForm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(51, 51, 51));
        txtMatKhau.setText("1234");
        txtMatKhau.setBorder(null);
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });
        txtMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMatKhauMouseClicked(evt);
            }
        });
        txtMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatKhauKeyTyped(evt);
            }
        });
        pnlForm.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 460, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/eye.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        pnlForm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        txtMatKhau2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMatKhau2.setBorder(null);
        pnlForm.add(txtMatKhau2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 460, 50));

        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/btnLog1.png"))); // NOI18N
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoginMouseExited(evt);
            }
        });
        pnlForm.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 70));

        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pnlForm.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 500, 10));

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pnlForm.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 500, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/key.png"))); // NOI18N
        pnlForm.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/padlock.png"))); // NOI18N
        pnlForm.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lblOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom4/icon/out.png"))); // NOI18N
        lblOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOutMouseExited(evt);
            }
        });
        pnlForm.add(lblOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 540, -1, -1));

        jLabel4.setText("Shop ABC xin kính chào quý khách");
        pnlForm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        getContentPane().add(pnlForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 620, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNVFocusLost
        
    }//GEN-LAST:event_txtMaNVFocusLost

    private void txtMaNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNVMouseClicked
       
    }//GEN-LAST:event_txtMaNVMouseClicked

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void txtMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMatKhauMouseClicked
       
    }//GEN-LAST:event_txtMatKhauMouseClicked

    private void txtMaNVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyTyped
       if(txtMaNV.getText().equals("")){
           lblUserName.setVisible(true);
       }
       else
           lblUserName.setVisible(false);
    }//GEN-LAST:event_txtMaNVKeyTyped

    private void txtMatKhauKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatKhauKeyTyped
       if(txtMatKhau.getText().equals("")){
           lblMatKhau.setVisible(true);
       }
       else
           lblMatKhau.setVisible(false);
           
           txtMatKhau2.setText(txtMatKhau.getText());
    }//GEN-LAST:event_txtMatKhauKeyTyped

    private void lblLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseEntered
        lblLogin.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\btnLog2.png"));
    }//GEN-LAST:event_lblLoginMouseEntered

    private void lblLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseExited
        lblLogin.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\btnLog1.png"));
    }//GEN-LAST:event_lblLoginMouseExited

    private void lblOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMouseEntered
        lblOut.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\out2.png"));
    }//GEN-LAST:event_lblOutMouseEntered

    private void lblOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMouseExited
       lblOut.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\out.png"));
    }//GEN-LAST:event_lblOutMouseExited

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        this.dangNhap();
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOutMouseClicked
         this.ketThuc();
    }//GEN-LAST:event_lblOutMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        txtMatKhau.setVisible(false); 
        txtMatKhau2.setVisible(true);
        txtMatKhau2.requestFocus(true);
        jLabel5.setVisible(true);
        jLabel3.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        txtMatKhau.setVisible(true);
        txtMatKhau2.setVisible(false);        
        txtMatKhau.requestFocus(true);
        jLabel5.setVisible(false);
        jLabel3.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked
    
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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhap dialog = new DangNhap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void init() {
         this.setLocationRelativeTo(null);
         //lblUserName.setVisible(false);
         //lblLogin.setIcon(new ImageIcon("src\\com\\nhom4\\icon\\btnLog1.png"));
         
    }
    
void dangNhap() {
        String manv = txtMaNV.getText();
        String matkhau = new String(txtMatKhau.getPassword());
        TaiKhoan nv = tkDAO.selectById(manv);
        if (nv == null) {
            MsgBox.alert(this, "Tên đăng nhập không chính xác");
        } else {
            if (!nv.getPass().equals(matkhau)) {
                MsgBox.alert(this, "Mật khẩu không chính xác");
            } else {
                //new loading().setVisible(true);
                Auth.user = nv;
                
                MsgBox.alert(this, "Đăng nhập thành công!");
                
                this.dispose();
            }
        }
    }

    void ketThuc() {
        if (MsgBox.confirm(this, "Bạn có chắc muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblOut;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtMatKhau2;
    // End of variables declaration//GEN-END:variables
}
