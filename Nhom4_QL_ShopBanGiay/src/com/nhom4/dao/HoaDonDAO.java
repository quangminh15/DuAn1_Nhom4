/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.HoaDon;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class HoaDonDAO extends MainDAO<HoaDon, String> {
        final String INSERT_SQL = "INSERT INTO HoaDon (MaHD, MaNV, MaKM, NgayBan, MaKH,ThanhTien,TrangThai)VALUES (?,?,?,?,?,?,?)";
        final String UPDATE_SQL = "UPDATE HoaDon SET MaNV =?, MaKM=?, NgayBan =?, MaKH =?, ThanhTien =?, TrangThai =? WHERE MaHD=?";
        final String DELETE_SQL = "DELETE FROM HoaDon WHERE MaHD = ?";
        final String SELECT_ALL_SQL = "SELECT * FROM HoaDon";
        final String SELECT_By_Id_SQL = "SELECT * FROM HoaDon WHERE MaHD = ?";
    @Override
    public void insert(HoaDon entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaHD(), entity.getMaNV(), entity.getMaKM(), entity.getNgayBan(), entity.getMaKH(), entity.getThanhTien(), entity.isTrangThai());
    }

    @Override
    public void update(HoaDon entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getMaNV(), entity.getMaKM(), entity.getNgayBan(), entity.getMaKH(), entity.getThanhTien(), entity.isTrangThai(), entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<HoaDon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HoaDon selectById(String id) {
        List<HoaDon> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
               HoaDon entity = new HoaDon();
               entity.setMaHD(rs.getString("MaHD"));
               entity.setMaNV(rs.getString("MaNV"));
               entity.setMaKM(rs.getString("MaKM"));
               entity.setNgayBan(rs.getDate("NgayBan"));
               entity.setMaKH(rs.getString("MaKH"));
               entity.setThanhTien(rs.getFloat("ThanhTien"));
               entity.setTrangThai(rs.getBoolean("TrangThai"));
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<String> selectMaNV(){
        String sql = "Select maNV from NhanVien";
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
    public List<String> selectMaKH(){
        String sql = "Select maKH from KhachHang";
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
    public List<String> selectMaKM(){
        String sql = "Select maKM from KhuyenMai";
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
    public void updateNgayBan(String id){
        String UPDATE_Date = "UPDATE HOADON SET NGAYBAN=GETDATE() WHERE MaHD=?";
        JdbcHelper.executeUpdate(UPDATE_Date, id);
    }
    public void updateThanhTien(String id){
        String Update_ThanhTien ="{CALL sp_TongTien(?)}";
        JdbcHelper.executeUpdate(Update_ThanhTien, id);
    }
}
