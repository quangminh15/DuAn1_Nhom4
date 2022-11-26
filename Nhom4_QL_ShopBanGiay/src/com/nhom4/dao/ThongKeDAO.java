/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import java.util.ArrayList;
import java.util.List;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author hp
 */
public class ThongKeDAO {
    
     private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.executeQuery(sql,args);
            while (rs.next()) {                
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     
      public List<Integer> selectYears(){
        String sql = "select distinct year(NgayBan) from HoaDon";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
      
      public List<Integer> selectMonths(){
        String sql = "select distinct month(NgayBan) from HoaDon";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {                
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getKhachHang(int thang, int nam) {
        String sql = "{CALL sp_KhachHang(?,?)}";
        String [] cols = {"MaKH","TenKH","Số lượng","Thành tiền"};
        return this.getListOfArray(sql, cols, thang, nam);
    }
    
    public List<Object[]> getDoanhThu(int nam) {
        String sql = "{CALL sp_DoanhThu(?)}";
        String [] cols = {"Nam","SoLuong","CaoNhat","ThapNhat","TrungBinh"};
        return this.getListOfArray(sql, cols,nam);
    }
}
