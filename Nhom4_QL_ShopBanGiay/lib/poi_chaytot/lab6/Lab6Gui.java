/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.com.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import poly.com.lab5.Sinhvien;

/**
 *
 * @author adm1n
 */
public class Lab6Gui extends javax.swing.JFrame {

    /**
     * Creates new form Lab6Gui
     */
    ArrayList<Modelbook> arr = new ArrayList<Modelbook>();
    public void LoadDataToArrayList()
    {
        arr.clear();
         try
        {
            String user="sa";
            String pass="123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:50591;databaseName=Library";
            Connection con =DriverManager.getConnection(url,user,pass);
            String sql="select * from Books";
            Statement st=con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("ID");
                String title=rs.getString(2);
                float price=rs.getFloat("price");
               Modelbook book = new Modelbook(id, title, price);
                           
               
               
               arr.add(book);
            }
         con.close();
        }
         
         
        catch(Exception e)
        {
            e.printStackTrace();
        }
         
    }
    
    public void  LoadDataArrayListToTable()
    {
        DefaultTableModel model = (DefaultTableModel) tbldanhsach.getModel();
        model.setRowCount(0);
     
        for(Modelbook book : arr )
       {
                     
           model.addRow(new Object[]{book.getId(),book.getTitle(),book.getPrice() });
       }
        
 
  
     /*for(int i=0; i<arr.size(); i++)
            {
             Vector v = new Vector();
             v.add(arr.get(i).getId());
             v.add(arr.get(i).getTitle());
             v.add(arr.get(i).getPrice());
             model.addRow(v);
            }
     */ 
    }
    public Lab6Gui() {
        initComponents();
        LoadDataToArrayList();
        LoadDataArrayListToTable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpopomenu = new javax.swing.JPopupMenu();
        xoaxoa = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        pupxoa1 = new javax.swing.JMenuItem();
        txttim = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldanhsach = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        xoaxoa.setText("Xoa");
        xoaxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoaxoaMouseClicked(evt);
            }
        });
        xoaxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaxoaActionPerformed(evt);
            }
        });
        jpopomenu.add(xoaxoa);

        jMenuItem2.setText("Sua");
        jpopomenu.add(jMenuItem2);

        pupxoa1.setText("jMenuItem1");
        jPopupMenu1.add(pupxoa1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        txttim.setText("jTextField1");
        txttim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimKeyReleased(evt);
            }
        });

        btnsearch.setText("Search");

        jButton2.setText("Exit");

        tbldanhsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Title ", "Price"
            }
        ));
        tbldanhsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldanhsachMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbldanhsachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbldanhsachMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbldanhsachMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbldanhsachMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbldanhsach);

        jButton1.setText("UPDATE GIA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("IN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("xoa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btnsearch)
                                .addGap(37, 37, 37)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton1)
                        .addGap(82, 82, 82)
                        .addComponent(jButton3)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch)
                    .addComponent(jButton2))
                .addGap(89, 89, 89)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    private void txttimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKeyReleased
        // TODO add your handling code here:
       arr.clear();
        
        float gia=0;
         try
        {
            String user="sa";
            String pass="123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:50591;databaseName=Library";
            Connection con =DriverManager.getConnection(url,user,pass);
            
           if (txttim.getText().isEmpty())
            gia=0;
            else
                 if(txttim.getText().chars().allMatch(Character::isDigit))//khi nhap chuoi thi khong nhan, so o txttim moi nhan.
             
                     gia=Float.parseFloat(txttim.getText());
                   
            String sql="select * from Books where title like N'%" + txttim.getText() + "%'  or price=" + gia;
            System.out.println(sql);
            Statement st=con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            System.out.println(sql);
            
            while(rs.next())
            {
                int id=rs.getInt("ID");
                String title=rs.getString(2);
                float price=rs.getFloat("price");
               Modelbook book = new Modelbook(id, title, price);
                                              
               arr.add(book);
                             
            }
            con.close();
            
        LoadDataArrayListToTable();
            
            
        }
            catch (Exception ex)
                    {
                    ex.printStackTrace();
                    }
       
          /* String sql="select * from username where uname like N'%" + user.getUname() + 
                   "%' or ufullname like N'%" + user.getUfullname() + "%' or upass like '" 
                   + user.getUpass() +"' or role=" + user.getRol()  ;
                System.out.println(sql);  
          */      
                
          
         
        
        
        
    }//GEN-LAST:event_txttimKeyReleased

    private void tbldanhsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMouseClicked
    
      
     
    }//GEN-LAST:event_tbldanhsachMouseClicked

    private void tbldanhsachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMouseEntered
        // TODO add your handling code here:
             // JOptionPane.showMessageDialog(this, "bạn muốn xóa không");
     
    }//GEN-LAST:event_tbldanhsachMouseEntered

    private void tbldanhsachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tbldanhsachMousePressed

    private void tbldanhsachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMouseExited
        // TODO add your handling code here:
        // JOptionPane.showMessageDialog(this, "ban muon xoa khong");
    }//GEN-LAST:event_tbldanhsachMouseExited

    private void tbldanhsachMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldanhsachMouseReleased
        // TODO add your handling code here:
       //  JOptionPane.showMessageDialog(this, "ban muon xoa khong");
    }//GEN-LAST:event_tbldanhsachMouseReleased
public void xoa(int id)
{
     int rows=0;
             try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:50591;databaseName=Library";
            Connection con =DriverManager.getConnection(url,"sa","123");
           String sql="delete from Books where id=?";
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setInt(1, id);
                        
         rows=stm.executeUpdate();
         
          if(rows>=1)
          {   System.out.println("Xóa thành công");
              System.out.println(rows);
          }
          else
          {  System.out.println(rows);
              System.out.println("Thất Bại");
          } 
          
          stm.close(); con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
              System.out.println("Cập nhật thất bại");
             
              System.out.println(rows);
        } 
}
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void xoaxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoaxoaMouseClicked
        // TODO add your handling code here:
 
    
    }//GEN-LAST:event_xoaxoaMouseClicked

    private void xoaxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaxoaActionPerformed
        // TODO add your handling code here:
          int ret=JOptionPane.showConfirmDialog(this, "Bạn Muốn Xoa Hay không?","thông bao",JOptionPane.YES_NO_OPTION);
        if (ret==JOptionPane.YES_OPTION)
        {  
        int idxoa;
        int dong;
        dong=tbldanhsach.getSelectedRow();
        idxoa=(int) tbldanhsach.getValueAt(tbldanhsach.getSelectedRow(), 0);
       
        System.out.println(" " + idxoa);      
        xoa(idxoa);
         LoadDataToArrayList();
        LoadDataArrayListToTable();
               JOptionPane.showMessageDialog(this,"xoa thanh cong");
        
           
        
        }
        
        
    }//GEN-LAST:event_xoaxoaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
         int rows=0;
             try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:50591;databaseName=Library";
            Connection con =DriverManager.getConnection(url,"sa","123");
            System.out.println(tbldanhsach.getRowCount());
           //  System.out.println(tbldanhsach.getValueAt(0, 2));
          for(int i=0; i<tbldanhsach.getRowCount() ; i++)
          {
            String sql="update Books set price=? where id=?";
            PreparedStatement stm=con.prepareStatement(sql);
            float gia;
            int id;
            gia=Float.parseFloat(tbldanhsach.getValueAt(i, 2).toString());
            id=Integer.parseInt(tbldanhsach.getValueAt(i, 0).toString());
            stm.setFloat(1, gia);
            stm.setInt(2, id);
              System.out.println(gia);
              System.out.println(id);
          rows=stm.executeUpdate();
          }
          
          if(rows>=1)
          {   System.out.println("update thành công");
              System.out.println(rows);
          }
          else
          {  System.out.println(rows);
              System.out.println("chưa update được");
          } 
        con.close();
        LoadDataToArrayList();
        LoadDataArrayListToTable();
        JOptionPane.showMessageDialog(this, "update gia thanh cong");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
              System.out.println("update thất bại");
             
              System.out.println(rows);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try
        {
        XSSFWorkbook wordkbook = new XSSFWorkbook();
        XSSFSheet sheet=wordkbook.createSheet("danhsach");
        XSSFRow row =null;
        Cell cell=null;
        row=sheet.createRow(2);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("DANH SACH GIA SACH");
        
        row=sheet.createRow(3);
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("STT");
        
        cell=row.createCell(1,CellType.STRING);
        cell.setCellValue("ID");
        
        cell=row.createCell(2,CellType.STRING);
        cell.setCellValue("TILTLE");
        
        cell=row.createCell(3,CellType.STRING);
        cell.setCellValue("PRICES");
        
        for(int i=0; i<arr.size(); i++)
        {
            //Modelbook book =arr.get(i);
            row=sheet.createRow(4+i);
           
            cell=row.createCell(0,CellType.NUMERIC);
            cell.setCellValue(i+1);
            
            cell=row.createCell(1,CellType.STRING);
            cell.setCellValue(arr.get(i).getId());
            
            
            cell=row.createCell(2,CellType.STRING);
            cell.setCellValue(arr.get(i).getTitle());
            
            cell=row.createCell(3,CellType.STRING);
            cell.setCellValue(arr.get(i).getPrice());
                                  
        }
        
        File f = new File("D://danhsach.xlsx");
        try 
        {
            FileOutputStream fis = new FileOutputStream(f);
            wordkbook.write(fis);
            fis.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
       
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }
        
        
        JOptionPane.showMessageDialog(this, "in thanh cong D:\\danhsach");
        
        }
        
        
        catch(Exception ex)
        {
            ex.printStackTrace();
              JOptionPane.showMessageDialog(this, "Loi mo file");
        }
        
    
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
int dongxoa=-1;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
       
        int idxoa;
     
        
        
        dongxoa=tbldanhsach.getSelectedRow();
        if(dongxoa==-1)
            JOptionPane.showMessageDialog(this, "bạn phai chon dong de xoa");
        else
        {  
               int ret=JOptionPane.showConfirmDialog(this, "Bạn Muốn Xoa Hay không?","thông bao",JOptionPane.YES_NO_OPTION);
                if (ret==JOptionPane.YES_OPTION) 
                {
                idxoa=(int) tbldanhsach.getValueAt(tbldanhsach.getSelectedRow(), 0);
       
                System.out.println(" " + idxoa);      
                xoa(idxoa);
                LoadDataToArrayList();
                 LoadDataArrayListToTable();
               JOptionPane.showMessageDialog(this,"xoa thanh cong");
                }
            
        }
      
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Lab6Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lab6Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lab6Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lab6Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lab6Gui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu jpopomenu;
    private javax.swing.JMenuItem pupxoa1;
    private javax.swing.JTable tbldanhsach;
    private javax.swing.JTextField txttim;
    private javax.swing.JMenuItem xoaxoa;
    // End of variables declaration//GEN-END:variables
}