/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;


import com.nhom4.entity.KhuyenMai;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author ACER
 */
public class NewClass {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        System.out.println(df.format(now));

        
        List<KhuyenMai> listKM = new ArrayList<>();
        System.out.println("1");
        for (KhuyenMai khuyenMai : listKM) {
            System.out.println(khuyenMai.getMaKM());
        }
        System.out.println("2");
        for (int i = 0; i < listKM.size(); i++) {
            System.out.println("3");
            System.out.println(i);
        }

    }
}
