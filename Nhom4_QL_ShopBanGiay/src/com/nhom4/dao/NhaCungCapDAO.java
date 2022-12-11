/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.dao.MainDAO;
import com.nhom4.entity.NhaCungCap;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class NhaCungCapDAO extends MainDAO<NhaCungCap, String> {

    final String INSERT_SQL = "INSERT INTO NCC (MaNCC, TenNCC,Xoa) VALUES (?,?,?)";
    final String UPDATE_SQL = "UPDATE NCC SET TenNCC = ?, Xoa = ? WHERE MaNCC = ?";
    final String DELETE_SQL = "DELETE FROM NCC WHERE MaNCC = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM NCC";
    final String SELECT_ALL_SQL_1 = "SELECT * FROM NCC where Xoa = 1";
    final String SELECT_By_Id_SQL = "SELECT * FROM NCC WHERE MaNCC = ?";
    final String SELECT_ALL_SQL_2 = "SELECT * FROM NCC where Xoa = 0";
    final String HIDE_SQL = "Update NCC set xoa=0 where MaNCC = ?";
    final String RESTORE_SQL = "Update NCC set xoa=1 where MaNCC = ?";

    @Override
    public void insert(NhaCungCap entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNCC(), entity.getTenNCC(), entity.isXoa());
    }

    @Override
    public void update(NhaCungCap entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenNCC(), entity.isXoa(), entity.getMaNCC());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<NhaCungCap> selectAll() {
        return selectBySql(SELECT_ALL_SQL_1);
    }

    public List<NhaCungCap> selectAn() {
        return selectBySql(SELECT_ALL_SQL_2);
    }
    
    public void hide(String id){
        JdbcHelper.executeUpdate(HIDE_SQL, id);
    }
    public void restore(String id){
        JdbcHelper.executeUpdate(RESTORE_SQL, id);
    }
    
    @Override
    public NhaCungCap selectById(String id) {
        List<NhaCungCap> list = selectBySql(SELECT_By_Id_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public List<NhaCungCap> selectByKeyword(String key) {
        String sql = "SELECT * FROM NCC WHERE Xoa = 1 and TenNCC like ?";
        return this.selectBySql(sql, "%" + key + "%");
    }
    
    public List<String> selectMaNCC() {
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
    public List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<NhaCungCap>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhaCungCap entity = new NhaCungCap();
                entity.setMaNCC(rs.getString("MaNCC"));
                entity.setTenNCC(rs.getString("TenNCC"));
                entity.setXoa(rs.getBoolean("Xoa"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
