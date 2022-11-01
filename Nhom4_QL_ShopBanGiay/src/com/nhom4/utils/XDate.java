/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class XDate {
    static SimpleDateFormat DATE_FORMATER = new SimpleDateFormat();
    
    public static Date toDate(String date, String pattern) {
        try {
            DATE_FORMATER.applyPattern(pattern);
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static String toString(Date date, String pattern) {
            DATE_FORMATER.applyPattern(pattern);
            return DATE_FORMATER.format(date);
        }
    
    public static Date now() {
            return new Date();
        }
    
    public static Date addDays(Date date, long days) {
            date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
            return date;
        }
    
}
