/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.ChiTietSanPham;
import com.nhom4.utils.JdbcHelper;
import java.util.List;

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
        
    }

    @Override
    public List<ChiTietSanPham> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietSanPham selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietSanPham> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
