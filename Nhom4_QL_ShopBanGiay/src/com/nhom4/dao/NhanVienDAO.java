/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.NhanVien;
import com.nhom4.entity.TaiKhoan;
import com.nhom4.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author ACER
 */
public class NhanVienDAO extends MainDAO<NhanVien, String> {

    final String INSERT_SQL = "insert into NhanVien(MaNV,TenNV,GioiTinh,SDT,Email,Hinh,DiaChi,Xoa) Values(?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "Update NhanVien set TenNV=?,GioiTinh=?,SDT=?,Email=?,Hinh=?,DiaChi=?,Xoa=? where MaNV = ?";
    final String DELETE_SQL = "delete from NhanVien where MaNV = ?";
    final String SELECT_By_Id_SQL = "select * from NhanVien where MaNV=?";
    final String SELECT_ALL_SQL_1 = "select * from NhanVien where Xoa = 0";
    final String SELECT_ALL_SQL_2 = "select * from NhanVien where Xoa = 1";
    final String HIDE_SQL = "Update NhanVien set xoa=1 where MaNV = ?";
    final String RESTORE_SQL = "Update NhanVien set xoa=0 where MaNV = ?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNV(), entity.getTenNV(), entity.getGioiTinh(), entity.getSDT(), entity.getEmail(), entity.getHinh(), entity.getDiaChi(), entity.isXoa());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenNV(), entity.getGioiTinh(), entity.getSDT(), entity.getEmail(), entity.getHinh(), entity.getDiaChi(),entity.isXoa(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selectBySql(SELECT_ALL_SQL_1);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_By_Id_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<NhanVien> selectAn() {
        return selectBySql(SELECT_ALL_SQL_2);
    }
     
     public void hide(String id){
        JdbcHelper.executeUpdate(HIDE_SQL, id);
    }
    public void restore(String id){
        JdbcHelper.executeUpdate(RESTORE_SQL, id);
    }

    public List<NhanVien> selectByKeyword(String user) {
        String sql = "SELECT * FROM NhanVien WHERE TenNV like ?";
        return this.selectBySql(sql, "%" + user + "%");
    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setSDT(rs.getString("SDT"));
                entity.setEmail(rs.getString("Email"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setDiaChi(rs.getString("DiaChi"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<NhanVien> selectByMaHD(String key) {
        String sql = "SELECT * FROM HoaDonCT WHERE MaHD like ?";
        return this.selectBySql(sql, "%" + key + "%");
    }

}
