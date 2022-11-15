/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.HoaDonChiTiet;
import java.sql.ResultSet;
import java.util.List;
import com.nhom4.utils.JdbcHelper;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class HoaDonChiTietDAO extends MainDAO<HoaDonChiTiet, String> {

    final String INSERT_SQL = "INSERT INTO HoaDonCT (MaHDCT,MaHD, MaCT, TenSP, SoLuong,Gia,TongTien)VALUES(?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE HoaDonCT SET MaHD=?, MaCT =?, TenSP=?, SoLuong=?, Gia=?, TongTien=? WHERE MaHDCT=?";
    final String DELETE_SQL = "DELETE FROM HoaDonCT WHERE MaHDCT = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM HoaDonCT ";
    final String SELECT_By_Id_SQL = "SELECT * FROM HoaDonCT WHERE MaHDCT = ?";

    @Override
    public void insert(HoaDonChiTiet entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaHDCT(), entity.getMaHD(), entity.getMaCT(), entity.getTenSP(), entity.getSoLuong(), entity.getGia(), entity.getTongTien());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getMaHD(), entity.getMaCT(), entity.getTenSP(), entity.getSoLuong(), entity.getGia(), entity.getTongTien(), entity.getMaHDCT());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDonChiTiet selectById(String id) {
        List<HoaDonChiTiet> list = selectBySql(SELECT_By_Id_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaHDCT(rs.getString("MaHDCT"));
                entity.setMaHD(rs.getString("MaHD"));
                entity.setMaCT(rs.getString("MaCT"));
                entity.setTenSP(rs.getString("TenSP"));
                entity.setSoLuong(rs.getInt("SoLuong"));
                entity.setGia(rs.getFloat("Gia"));
                entity.setTongTien(rs.getFloat("TongTien"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
