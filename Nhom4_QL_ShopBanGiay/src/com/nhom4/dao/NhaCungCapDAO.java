/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.dao.MainDAO;
import com.nhom4.entity.NhaCungCap;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class NhaCungCapDAO extends MainDAO<NhaCungCap, String>{
        final String INSERT_SQL = "INSERT INTO NCC (MaNCC, TenNCC) VALUES (?,?)";
        final String UPDATE_SQL = "UPDATE NCC SET TenNCC = ? WHERE MaNCC = ?";
        final String DELETE_SQL = "DELETE FROM NCC WHERE MaNCC = ?";
        final String SELECT_ALL_SQL = "SELECT * FROM NCC";
        final String SELECT_By_Id_SQL = "SELECT * FROM NCC WHERE MaNCC = ?";
        
    @Override
    public void insert(NhaCungCap entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNCC(), entity.getTenNCC());
    }

    @Override
    public void update(NhaCungCap entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getTenNCC(), entity.getMaNCC());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<NhaCungCap> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhaCungCap selectById(String id) {
        List<NhaCungCap> list = selectBySql(SELECT_By_Id_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
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
               list.add(entity);  
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
