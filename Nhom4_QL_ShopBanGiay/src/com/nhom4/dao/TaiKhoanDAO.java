/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.TaiKhoan;
import java.util.List;

/**
 *
 * @author ACER
 */
public class TaiKhoanDAO extends MainDAO<TaiKhoan, String> {
    final String INSERT_SQL = "INSERT INTO TaiKhoan(MaNV, Username, Pass, Role) VALUES ( ?,?,?,?  ) ";
    final String UPDATE_SQL = "UPDATE NhanVien SET HoTen = ?, MatKhau = ?  , VaiTro = ? where MaNV = ?";
    final String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    final String SELECT_By_Id_SQL = "SELECT * FROM NhanVien WHERE MaNV = ?";
    
    
    @Override
    public void insert(TaiKhoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TaiKhoan entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TaiKhoan> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoan selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TaiKhoan> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
