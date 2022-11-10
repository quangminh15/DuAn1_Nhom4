/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;

/**
 *
 * @author ACER
 */
public class HoaDonChiTiet {
    private String maHD;
    private String maCT;
    private String tenSP;
    private int soLuong;
    private float gia;
    private float tongTien;
    
    @Override
        public String toString() {
            return this.tenSP;
        }

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHD, String maCT, String tenSP, int soLuong, float gia, float tongTien) {
        this.maHD = maHD;
        this.maCT = maCT;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tongTien = tongTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
        
    
}
