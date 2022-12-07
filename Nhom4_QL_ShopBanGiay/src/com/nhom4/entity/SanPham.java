/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;

/**
 *
 * @author ACER
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private String maNCC;
    private String anh;
    private String ghiChu;
    private boolean xoa;
    
    @Override
        public String toString() {
            return this.tenSP;
        }

    public SanPham() {
    }

//    public SanPham(String maSP, String tenSP, int soLuong, String maNCC, String anh, String ghiChu) {
//        this.maSP = maSP;
//        this.tenSP = tenSP;
//        this.soLuong = soLuong;
//        this.maNCC = maNCC;
//        this.anh = anh;
//        this.ghiChu = ghiChu;
//    }
//
//    public String getMaSP() {
//        return maSP;
//    }
//
//    public void setMaSP(String maSP) {
//        this.maSP = maSP;
//    }
//
//    public String getTenSP() {
//        return tenSP;
//    }
//
//    public void setTenSP(String tenSP) {
//        this.tenSP = tenSP;
//    }
//
//    public int getSoLuong() {
//        return soLuong;
//    }
//
//    public void setSoLuong(int soLuong) {
//        this.soLuong = soLuong;
//    }
//
//    public String getMaNCC() {
//        return maNCC;
//    }
//
//    public void setMaNCC(String maNCC) {
//        this.maNCC = maNCC;
//    }
//
//    public String getAnh() {
//        return anh;
//    }
//
//    public void setAnh(String anh) {
//        this.anh = anh;
//    }
//
//    public String getGhiChu() {
//        return ghiChu;
//    }
//
//    public void setGhiChu(String ghiChu) {
//        this.ghiChu = ghiChu;
//    }

    public SanPham(String maSP, String tenSP, int soLuong, String maNCC, String anh, String ghiChu, boolean xoa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.maNCC = maNCC;
        this.anh = anh;
        this.ghiChu = ghiChu;
        this.xoa = xoa;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }
    
    
        
    
}
