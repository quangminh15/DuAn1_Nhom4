/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.utils;

import com.nhom4.entity.NhanVien;



/**
 *
 * @author ACER
 */
public class Auth {
    public static NhanVien user = null;
    
    public static void clear(){
        Auth.user = null;
    }
    
    public static boolean  islogin(){
        return Auth.user !=null;
    }
    
    public static boolean isManager(){
        return Auth.islogin() && user.isVaiTro();
    }
}
