/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;

/**
 *
 * @author ACER
 */
public class NhanVien {
    private String maNV;
    private String tenNV;
    private boolean gioiTinh = true;
    private String SDT;
    private String email;
    private String hinh;
    private String diaChi;
    private boolean xoa;
    
    
    @Override
        public String toString() {
            return this.tenNV;
        }

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, boolean gioiTinh, String SDT, String email, String hinh, String diaChi, boolean xoa) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.email = email;
        this.hinh = hinh;
        this.diaChi = diaChi;
        this.xoa = xoa;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

   
}
