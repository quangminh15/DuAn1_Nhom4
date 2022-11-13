/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.KhachHang;
import com.nhom4.utils.JdbcHelper;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhachHangDAO extends MainDAO<KhachHang, String> {
    final String INSERT_SQL = "insert into KhachHang (MaKH,TenKH,SDT,DiaChi) Values(?,?,?,?)";
    final String UPDATE_SQL = "update KhachHang set TenKH=?,SDT=?,DiaChi=? where MaKH = ?";
    final String DELETE_SQL = "delete from KhachHang where MaKH = ?";
    final String SELECT_ALL_SQL = "select * from KhachHang";
    final String SELECT_By_Id_SQL = "select * from KhachHang where MaKH=?";
    
    @Override
    public void insert(KhachHang entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaKM(), entity.getTenKM(),entity.getGiamGia(), entity.getNgayBD(), entity.getNgayKT(), entity.getGhiChu());
    }

    @Override
    public void update(KhachHang entity) {
        
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<KhachHang> selectAll() {
        
    }

    @Override
    public KhachHang selectById(String id) {
        
    }

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        
    }
    
}
