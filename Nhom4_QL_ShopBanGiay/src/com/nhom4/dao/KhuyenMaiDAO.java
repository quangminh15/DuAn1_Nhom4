/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.HoaDon;
import com.nhom4.entity.KhuyenMai;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhuyenMaiDAO extends MainDAO<KhuyenMai, String> {

    final String INSERT_SQL = "INSERT INTO KhuyenMai (MaKM, TenKM, GiamGia, NgayBD, NgayKT, GhiChu,Xoa) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhuyenMai SET TenKM =?, GiamGia=?, NgayBD =?, NgayKT =?, GhiChu =?,Xoa=? WHERE MaKM=?";
    final String DELETE_SQL = "DELETE FROM KhuyenMai WHERE MaKM = ?";
    final String SELECT_By_Id_SQL = "SELECT * FROM KhuyenMai WHERE MaKM = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM KhuyenMai";
    final String SELECT_ALL_SQL_1 = "SELECT * FROM KhuyenMai where Xoa = 1";
    final String SELECT_ALL_SQL_2 = "SELECT * FROM KhuyenMai where Xoa = 0";
    final String HIDE_SQL = "Update KhuyenMai set xoa=0 where MaKM = ?";
    final String RESTORE_SQL = "Update KhuyenMai set xoa=1 where MaKM = ?";

    @Override
    public void insert(KhuyenMai entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaKM(), entity.getTenKM(), entity.getGiamGia(), new java.sql.Date(entity.getNgayBD().getTime()), new java.sql.Date(entity.getNgayKT().getTime()), entity.getGhiChu(), entity.isXoa());
    }

    @Override
    public void update(KhuyenMai entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenKM(), entity.getGiamGia(), new java.sql.Date(entity.getNgayBD().getTime()), new java.sql.Date(entity.getNgayKT().getTime()), entity.getGhiChu(),entity.isXoa(), entity.getMaKM());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return selectBySql(SELECT_ALL_SQL_1);
    }
    
    public List<KhuyenMai> selectAn() {
        return selectBySql(SELECT_ALL_SQL_2);
    }
     
     public void hide(String id){
        JdbcHelper.executeUpdate(HIDE_SQL, id);
    }
    public void restore(String id){
        JdbcHelper.executeUpdate(RESTORE_SQL, id);
    }

    @Override
    public KhuyenMai selectById(String id) {
        List<KhuyenMai> list = selectBySql(SELECT_By_Id_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<KhuyenMai> selectByKeyword(String key) {
        String sql = "SELECT * FROM KhuyenMai WHERE TenKM like ?";
        return this.selectBySql(sql, "%" + key + "%");
    }
    
    public List<String> selectMaKM() {
        String sql = SELECT_ALL_SQL;
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<KhuyenMai>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                KhuyenMai entity = new KhuyenMai();
                entity.setMaKM(rs.getString("MaKM"));
                entity.setTenKM(rs.getString("TenKM"));
                entity.setGiamGia(rs.getFloat("GiamGia"));
                java.sql.Date ngayBD = rs.getDate("NgayBD");
                java.sql.Date ngayKT = rs.getDate("NgayKT");
                entity.setNgayBD(new Date(ngayBD.getTime()));
                entity.setNgayKT(new Date(ngayKT.getTime()));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
