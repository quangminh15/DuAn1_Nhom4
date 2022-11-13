/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.KhachHang;
import com.nhom4.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

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
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaKH(), entity.getTenKH(),entity.getSDT(), entity.getDiaChi());
    }

    @Override
    public void update(KhachHang entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getMaKH(), entity.getTenKH(),entity.getSDT(), entity.getDiaChi());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<KhachHang> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
               KhachHang entity = new KhachHang();
               entity.setMaKH(rs.getString("MaKH"));
               entity.setTenKH(rs.getString("TenKH"));
               entity.setSDT(rs.getString("SDT"));
               entity.setDiaChi(rs.getString("DiaChi"));
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
