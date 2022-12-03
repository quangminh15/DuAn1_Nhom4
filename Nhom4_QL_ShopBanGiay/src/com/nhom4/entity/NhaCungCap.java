/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;



/**
 *
 * @author ACER
 */
public class NhaCungCap {
        private String maNCC;
        private String tenNCC;
        private boolean xoa;
        
        @Override
        public String toString() {
            return this.tenNCC;
        }

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, boolean xoa) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.xoa = xoa;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public boolean isXoa() {
        return xoa;
    }

    public void setXoa(boolean xoa) {
        this.xoa = xoa;
    }

    
    
    
}
