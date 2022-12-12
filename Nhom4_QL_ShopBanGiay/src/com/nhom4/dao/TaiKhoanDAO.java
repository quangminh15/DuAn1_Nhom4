/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.dao;

import com.nhom4.entity.NhanVien;
import com.nhom4.entity.TaiKhoan;
import com.nhom4.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class TaiKhoanDAO extends MainDAO<TaiKhoan, String> {

    final String INSERT_SQL = "INSERT INTO TaiKhoan(MaNV, Username, Pass, Role) VALUES ( ?,?,?,? ) ";
    final String UPDATE_SQL = "UPDATE TaiKhoan SET Username = ? , Pass = ? , Role =  ? WHERE MaNV = ?";
    final String DELETE_SQL = "DELETE FROM TaiKhoan WHERE MaNV = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM TaiKhoan where MaNV in (select MaNV from NhanVien where Xoa = 0)";
    final String SELECT_By_Id_SQL = "SELECT * FROM TaiKhoan WHERE Username = ?";

    @Override
    public void insert(TaiKhoan entity) {
        JdbcHelper.executeUpdate(INSERT_SQL, entity.getMaNV(), entity.getUsername(), entity.getPass(), entity.getRole());
    }

    @Override
    public void update(TaiKhoan entity) {
        JdbcHelper.executeUpdate(UPDATE_SQL, entity.getUsername(), entity.getPass(), entity.getRole(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TaiKhoan selectById(String id) {
        List<TaiKhoan> list = selectBySql(SELECT_By_Id_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<TaiKhoan> selectByKeyword(String user) {
        String sql = "select NhanVien.MaNV, Username, Pass, role from TaiKhoan  inner join NhanVien on NhanVien.MaNV = TaiKhoan.MaNV where Xoa = 0 and Username like ?";
        return this.selectBySql(sql, "%" + user + "%");
    }

    public List<String> selectListUser() {
        String sql = "select Username from TaiKhoan where MaNV in (select MaNV from NhanVien where Xoa = 1)";
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
    public List<String> selectMaNV() {
    String sql = "select MaNV from NhanVien";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                TaiKhoan entity = new TaiKhoan();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setUsername(rs.getString("Username"));
                entity.setPass(rs.getString("Pass"));
                entity.setRole(rs.getBoolean("role"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
