/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class HoaDon {
    private String maHD;
    private String maNV;
    private String maKM;
    private Date ngayBan;
    private String maKH;
    private float thanhTien;
    private boolean trangThai;
    private boolean xoa;
    
    @Override
        public String toString() {
            return this.maHD;
        }

    public HoaDon() {
    }

//    public HoaDon(String maHD, String maNV, String maKM, Date ngayBan, String maKH, float thanhTien, boolean trangThai) {
//        this.maHD = maHD;
//        this.maNV = maNV;
//        this.maKM = maKM;
//        this.ngayBan = ngayBan;
//        this.maKH = maKH;
//        this.thanhTien = thanhTien;
//        this.trangThai = trangThai;
//    }
//
//    public String getMaHD() {
//        return maHD;
//    }
//
//    public void setMaHD(String maHD) {
//        this.maHD = maHD;
//    }
//
//    public String getMaNV() {
//        return maNV;
//    }
//
//    public void setMaNV(String maNV) {
//        this.maNV = maNV;
//    }
//
//    public String getMaKM() {
//        return maKM;
//    }
//
//    public void setMaKM(String maKM) {
//        this.maKM = maKM;
//    }
//
//    public Date getNgayBan() {
//        return ngayBan;
//    }
//
//    public void setNgayBan(Date ngayBan) {
//        this.ngayBan = ngayBan;
//    }
//
//    public String getMaKH() {
//        return maKH;
//    }
//
//    public void setMaKH(String maKH) {
//        this.maKH = maKH;
//    }
//
//    public float getThanhTien() {
//        return thanhTien;
//    }
//
//    public void setThanhTien(float thanhTien) {
//        this.thanhTien = thanhTien;
//    }
//
//    public boolean isTrangThai() {
//        return trangThai;
//    }
//
//    public void setTrangThai(boolean trangThai) {
//        this.trangThai = trangThai;
//    }

    public HoaDon(String maHD, String maNV, String maKM, Date ngayBan, String maKH, float thanhTien, boolean trangThai, boolean xoa) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKM = maKM;
        this.ngayBan = ngayBan;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.xoa = xoa;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }
    
    
        
    
}
