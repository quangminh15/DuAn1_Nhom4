/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.NhanVien;
import com.nhom4.entity.TaiKhoan;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class TaiKhoanDAO extends MainDAO<TaiKhoan, String> {
    final String INSERT_SQL = "INSERT INTO TaiKhoan(MaNV, Username, Pass, Role) VALUES ( ?,?,?,? ) ";
    final String UPDATE_SQL = "UPDATE TaiKhoan SET Username = ? , Pass = ? , Role =  ? WHERE MaNV = ?";
    final String DELETE_SQL = "DELETE FROM TaiKhoan WHERE MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan";
    final String SELECT_By_Id_SQL = "SELECT * FROM TaiKhoan WHERE Username = ?";
    
    
    
    @Override
    public void insert(TaiKhoan entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNV(), entity.getUsername(),entity.getPass(), entity.getRole());
    }

    @Override
    public void update(TaiKhoan entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getUsername(),entity.getPass(), entity.getRole(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectById(String id) {
        List<TaiKhoan> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
               TaiKhoan entity = new TaiKhoan();
               entity.setMaNV(rs.getString("MaNV"));
               entity.setUsername(rs.getString("Username"));
               entity.setPass(rs.getString("Pass"));
               entity.setRole(rs.getBoolean("role"));
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
}
