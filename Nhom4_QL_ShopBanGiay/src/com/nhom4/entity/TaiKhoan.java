/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.entity;

/**
 *
 * @author ACER
 */
public class TaiKhoan {
    private String maNV;
    private String username;
    private String pass;
    private boolean role;
    
    @Override
        public String toString() {
            return this.username;
        }

    public TaiKhoan() {
    }

    public TaiKhoan(String maNV, String username, String pass, boolean role) {
        this.maNV = maNV;
        this.username = username;
        this.pass = pass;
        this.role = role;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
        
    
}
