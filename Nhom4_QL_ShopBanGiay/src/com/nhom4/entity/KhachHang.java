/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;

/**
 *
 * @author ACER
 */
public class KhachHang {
    private int maKH;
    private String tenKH;
    private String email;
    private String matKhau;
    private String SDT;
    private String diaChi;
    private boolean xoa;
    
    @Override
        public String toString() {
            return this.tenKH;
        }

    public KhachHang() {
    }

    public KhachHang(int maKH, String tenKH, String email, String matKhau, String SDT, String diaChi, boolean xoa) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.email = email;
        this.matKhau = matKhau;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.xoa = xoa;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
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
