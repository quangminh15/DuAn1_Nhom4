/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.ChiTietSanPham;
import com.nhom4.utils.JdbcHelper;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class ChiTietSanPhamDAO extends MainDAO<ChiTietSanPham, String> {
        final String INSERT_SQL = "INSERT INTO ChiTietSP(MaCT, MaSP, Size, MauSac, ChatLieu, Gia) VALUES (?,?,?,?,?,?)";
        final String UPDATE_SQL = "UPDATE ChiTietSP SET MaSP =?, Size=?, MauSac =?, ChatLieu =?, Gia =? WHERE MaCT=?";
        final String DELETE_SQL = "DELETE FROM ChiTietSP WHERE MaCT = ?";
        final String SELECT_ALL_SQL = "SELECT * FROM ChiTietSP";
        final String SELECT_By_Id_SQL = "SELECT * FROM ChiTietSP WHERE MaCT = ?";
        final String SELECT_By_Id_SQLL = "SELECT * FROM ChiTietSP WHERE MaSP = ?";
    @Override
    public void insert(ChiTietSanPham entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaCT(), entity.getMaSP(), entity.getSize(), entity.getMauSac(), entity.getChatLieu(), entity.getGia());
    }

    @Override
    public void update(ChiTietSanPham entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getMaSP(), entity.getSize(), entity.getMauSac(), entity.getChatLieu(), entity.getGia(), entity.getMaCT());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<ChiTietSanPham> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChiTietSanPham selectById(String id) {
        List<ChiTietSanPham> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    public ChiTietSanPham selectByIdd(String id) {
        List<ChiTietSanPham> list = selectBySql(SELECT_By_Id_SQLL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
    
    public List<ChiTietSanPham> selectByKeyword(String key) {
        String sql = "SELECT * FROM ChiTietSP WHERE MaCT like ?";
        return this.selectBySql(sql, "%"+key+"%");
    }
    
    @Override
    public List<ChiTietSanPham> selectBySql(String sql, Object... args) {
        List<ChiTietSanPham> list = new ArrayList<ChiTietSanPham>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
               ChiTietSanPham entity = new ChiTietSanPham();
               entity.setMaCT(rs.getString("MaCT"));
               entity.setMaSP(rs.getString("MaSP"));
               entity.setSize(rs.getFloat("Size"));
               entity.setMauSac(rs.getString("MauSac"));
               entity.setChatLieu(rs.getString("ChatLieu"));
               entity.setGia(rs.getFloat("Gia"));
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
