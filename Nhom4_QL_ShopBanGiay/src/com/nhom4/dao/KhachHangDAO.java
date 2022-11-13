/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.KhachHang;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhachHangDAO extends MainDAO<KhachHang, String> {
    final String INSERT_SQL = "INSERT INTO KhuyenMai (MaKM, TenKM, GiamGia, NgayBD, NgayKT, GhiChu) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhuyenMai SET TenKM =?, GiamGia=?, NgayBD =?, NgayKT =?, GhiChu =? WHERE MaKM=?";
    final String DELETE_SQL = "DELETE FROM KhuyenMai WHERE MaKM = 'KM004'";
    final String SELECT_ALL_SQL = "SELECT * FROM KhuyenMai";
    final String SELECT_By_Id_SQL = "SELECT * FROM KhuyenMai WHERE MaKM = ?";
    
    @Override
    public void insert(KhachHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(KhachHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KhachHang selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
