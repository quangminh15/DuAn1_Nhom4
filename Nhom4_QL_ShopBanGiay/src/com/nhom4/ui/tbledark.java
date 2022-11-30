/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom4.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Hai
 */
public class tbledark extends JTable {
    
    public tbledark() {
        getTableHeader().setDefaultRenderer(new TableDarkHeader());
        getTableHeader().setPreferredSize(new Dimension(0, 40));
        setDefaultRenderer(Object.class, new TableDarkCelll());
        setRowHeight(60);
    }
    
    
    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 33, 33));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(30, 30, 30));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));
    }
    private class TableDarkHeader extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(33, 33, 33));
            com.setForeground(new Color(219, 216, 227));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 14));
            return com;
        }

    }

    private class TableDarkCelll extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isCellSelected(row, column)) {
                if (row % 2 == 0) {
                    com.setBackground(new Color(33, 103, 153));
                } else {
                    com.setBackground(new Color(29, 86, 127));
                }
            } else {
                if (row % 2 == 0) {
                    com.setBackground(new Color(50, 50, 50));
                } else {
                    com.setBackground(new Color(34, 34, 34));
                }
            }
            setBorder(new EmptyBorder(0, 5, 0, 5));
            com.setForeground(new Color(219, 216, 227));
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
            
            return com;
        }

    }
}
