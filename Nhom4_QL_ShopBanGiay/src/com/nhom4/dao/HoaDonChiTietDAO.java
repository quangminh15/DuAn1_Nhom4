/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.HoaDonChiTiet;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ACER
 */
public class HoaDonChiTietDAO extends MainDAO<HoaDonChiTiet, String> {
    final String INSERT_SQL = "INSERT INTO KhuyenMai (MaKM, TenKM, GiamGia, NgayBD, NgayKT, GhiChu) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhuyenMai SET TenKM =?, GiamGia=?, NgayBD =?, NgayKT =?, GhiChu =? WHERE MaKM=?";
    final String DELETE_SQL = "DELETE FROM KhuyenMai WHERE MaKM = 'KM004'";
    final String SELECT_ALL_SQL = "SELECT * FROM KhuyenMai";
    final String SELECT_By_Id_SQL = "SELECT * FROM KhuyenMai WHERE MaKM = ?";
    
    @Override
    public void insert(HoaDonChiTiet entity) {
        
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        
    }

    @Override
    public void delete(String id) {
        
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        
    }

    @Override
    public HoaDonChiTiet selectById(String id) {
        
    }

    @Override
    public List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        
    }
    
}
