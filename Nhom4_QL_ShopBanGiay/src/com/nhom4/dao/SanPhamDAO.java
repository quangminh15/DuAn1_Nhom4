/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.SanPham;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class SanPhamDAO extends MainDAO<SanPham, String>  {
    final String INSERT_SQL = "INSERT INTO SanPham(MaSP, TenSP, SoLuong, MaNCC, Anh, GhiChu) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE SanPham SET TenSP = ?, SoLuong= ?, MaNCC =?, Anh =?, GhiChu =? WHERE MaSP=?";
    final String DELETE_SQL = "DELETE FROM SanPham WHERE MaSP = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    final String SELECT_By_Id_SQL = "SELECT * FROM SanPham WHERE MaSP = ?";

    @Override
    public void insert(SanPham entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaSP(), entity.getTenSP(),entity.getSoLuong(), entity.getMaNCC(), entity.getAnh(), entity.getGhiChu());
    }

    @Override
    public void update(SanPham entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenSP(),entity.getSoLuong(), entity.getMaNCC(), entity.getAnh(), entity.getGhiChu(), entity.getMaSP());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<SanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public List<SanPham> selectByKeyword(String key) {
        String sql = "SELECT * FROM SanPham WHERE TenSP like ?";
        return this.selectBySql(sql, "%"+key+"%");
    }

    @Override
    public List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<SanPham>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
               SanPham entity = new SanPham();
               entity.setMaSP(rs.getString("MaSP"));
               entity.setTenSP(rs.getString("TenSP"));
               entity.setSoLuong(rs.getInt("SoLuong"));
               entity.setMaNCC(rs.getString("MaNCC"));
               entity.setAnh(rs.getString("Anh"));
               entity.setGhiChu(rs.getString("GhiChu"));
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    

    
}
