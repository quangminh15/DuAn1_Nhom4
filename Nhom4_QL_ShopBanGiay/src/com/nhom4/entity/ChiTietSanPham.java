/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;

/**
 *
 * @author ACER
 */
public class ChiTietSanPham {
    private String maCT;
    private String maSP;
    private float size;
    private String mauSac;
    private String chatLieu;
    private float gia;
    
    @Override
        public String toString() {
            return this.maCT;
        }

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String maCT, String maSP, float size, String mauSac, String chatLieu, float gia) {
        this.maCT = maCT;
        this.maSP = maSP;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.gia = gia;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
        
    
}
