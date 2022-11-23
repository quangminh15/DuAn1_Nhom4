/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import java.util.ArrayList;
import java.util.List;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class ThongKeDAO {
    
     private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            // X jdbc va jdbcHelper la 1
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

    public List<Object[]> getKhachHang(String makh) {
        String sql = "{CALL sp_BangDiem(?)}";
        String [] cols = {"MaNH","HoTen","Diem"};
        return this.getListOfArray(sql, cols, makh);
    }

    public List<Object[]> getDoanhThu() {
        String sql = "{CALL sp_ThongKeNguoiHoc}";
        String [] cols = {"Nam","SoLuong","DauTien","CuoiCung"};
        return this.getListOfArray(sql, cols);
    }

}
