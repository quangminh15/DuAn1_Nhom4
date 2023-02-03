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
public class KhuyenMai {
    private String maKM;
    private String tenKM;
    private float giamGia;
    private Date ngayBD;
    private Date ngayKT;
    private String ghiChu;
    private boolean xoa;
    
    @Override
        public String toString() {
            return this.tenKM;
        }

    public KhuyenMai() {
    }


    public KhuyenMai(String maKM, String tenKM, float giamGia, Date ngayBD, Date ngayKT, String ghiChu, boolean xoa) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.giamGia = giamGia;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.ghiChu = ghiChu;
        this.xoa = xoa;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
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
