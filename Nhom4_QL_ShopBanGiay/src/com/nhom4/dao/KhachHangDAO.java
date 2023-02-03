/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.KhachHang;
import com.nhom4.entity.NhanVien;
import com.nhom4.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class KhachHangDAO extends MainDAO<KhachHang, String> {
    final String INSERT_SQL = "insert into KhachHang (MaKH,TenKH,Email, MatKhau,SDT,DiaChi,Xoa) Values(?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "update KhachHang set TenKH=?, Email=?,MatKhau=?,SDT=?,DiaChi=?,Xoa=? where MaKH = ?";
    final String DELETE_SQL = "delete from KhachHang where MaKH = ?";
    final String SELECT_By_Id_SQL = "select * from KhachHang where MaKH=?";
    final String SELECT_ALL_SQL = "select * from KhachHang";
    final String SELECT_ALL_SQL_1 = "select * from KhachHang where Xoa = 1";
    final String SELECT_ALL_SQL_2 = "select * from KhachHang where Xoa = 0";
    final String HIDE_SQL = "Update KhachHang set xoa=0 where MaKH = ?";
    final String RESTORE_SQL = "Update KhachHang set xoa=1 where MaKH = ?";
    
    @Override
    public void insert(KhachHang entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaKH(), entity.getTenKH(), entity.getEmail(), entity.getMatKhau(), entity.getSDT(), entity.getDiaChi(), entity.isXoa());
    }

    @Override
    public void update(KhachHang entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenKH(), entity.getEmail(), entity.getMatKhau(), entity.getSDT(), entity.getDiaChi(), entity.isXoa(), entity.getMaKH());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL_1);
    }
     public List<KhachHang> selectByKeyword(String user) {
        String sql = "SELECT * FROM KhachHang WHERE Xoa = 1 and TenKH like ?";
        return this.selectBySql(sql, "%"+user+"%");
    }
     
    public List<KhachHang> selectAn() {
        return selectBySql(SELECT_ALL_SQL_2);
    }
     
     public void hide(String id){
        JdbcHelper.executeUpdate(HIDE_SQL, id);
    }
    public void restore(String id){
        JdbcHelper.executeUpdate(RESTORE_SQL, id);
    }
    
    public List<String> selectMaKH() {
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
    
    public List<String> selectListEmail() {
        String sql = "select Email from KhachHang where MaKH in (select MaKH from KhachHang where Xoa = 1)";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
               KhachHang entity = new KhachHang();
               entity.setMaKH(rs.getInt("MaKH"));
               entity.setTenKH(rs.getString("TenKH"));
               entity.setEmail(rs.getString("Email"));
               entity.setMatKhau(rs.getString("MatKhau"));
               entity.setSDT(rs.getString("SDT"));
               entity.setDiaChi(rs.getString("DiaChi"));
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    
    public KhachHang selectById(int id) {
        List<KhachHang> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public KhachHang selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
