package com.escolaDeIdiomas.views;

import com.escolaDeIdiomas.controller.UserController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.management.BufferPoolMXBean;

public class MainPage extends JPanel {
    JPanel wrapper = new JPanel(new BorderLayout()) {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    };
    public MainPage(){
        JTable table = new JTable(UserController.getAllUsersInString(),
                new String[]{"id", "nome"});
        JScrollPane scroll = new JScrollPane(table);
        wrapper.add(scroll, BorderLayout.CENTER);
        wrapper.setOpaque(false);
        setLayout(new BorderLayout());
        add(wrapper, BorderLayout.CENTER);
        setBackground(Color.darkGray);

    }

    @Override
    public void doLayout(){
        super.doLayout();
        int w = getWidth();
        int h = getHeight();
        wrapper.setPreferredSize(new Dimension((int)(0.8f * w), (int)(0.8f * h)));
        wrapper.setBorder(new EmptyBorder((int)(0.1f*h),(int)(0.1f*w),(int)(0.1f*h),(int)(0.1f*w)));
        wrapper.revalidate();
    }
}
