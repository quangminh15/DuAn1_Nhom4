/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.KhuyenMai;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class KhuyenMaiDAO extends MainDAO<KhuyenMai, String>{
    final String INSERT_SQL = "INSERT INTO KhuyenMai (MaKM, TenKM, GiamGia, NgayBD, NgayKT, GhiChu) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE KhuyenMai SET TenKM =?, GiamGia=?, NgayBD =?, NgayKT =?, GhiChu =? WHERE MaKM=?";
    final String DELETE_SQL = "DELETE FROM KhuyenMai WHERE MaKM = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM KhuyenMai";
    final String SELECT_By_Id_SQL = "SELECT * FROM KhuyenMai WHERE MaKM = ?";
    
    @Override
    public void insert(KhuyenMai entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaKM(), entity.getTenKM(),entity.getGiamGia(), entity.getNgayBD(), entity.getNgayKT(), entity.getGhiChu());
    }

    @Override
    public void update(KhuyenMai entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenKM(),entity.getGiamGia(), entity.getNgayBD(), entity.getNgayKT(), entity.getGhiChu(), entity.getMaKM());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<KhuyenMai> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMai selectById(String id) {
        List<KhuyenMai> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
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
               entity.setNgayBD(rs.getDate("NgayBD"));
               entity.setNgayKT(rs.getDate("NgayKT"));
               entity.setGhiChu(rs.getString("GhiChu"));
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
