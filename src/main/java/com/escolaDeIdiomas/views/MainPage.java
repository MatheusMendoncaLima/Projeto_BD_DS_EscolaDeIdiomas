package com.escolaDeIdiomas.views;

import com.escolaDeIdiomas.HorizontalAlignment;
import com.escolaDeIdiomas.VerticalAlignment;
import com.escolaDeIdiomas.components.Column;
import com.escolaDeIdiomas.components.Table;
import com.escolaDeIdiomas.components.Button;
import com.escolaDeIdiomas.controller.UserController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.management.BufferPoolMXBean;

public class MainPage extends JPanel {
    Table table;

    public MainPage() {
        Column column = new Column();
        add(column);
        table = new Table(UserController.getAllUsersInString(),
                new String[]{"id", "nome"});
        column.add(table);
        setLayout(null);
        table.setVerticalAlignment(VerticalAlignment.CENTER);
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);
        table.setMinHeight(100);
        table.setMinWidth(200);
        table.setMaxWidth(500);
        table.fillSize(0.5f);
        setBackground(Color.darkGray);
        table.setMgStart(50);
        Button button = new Button("lixo", ()->{
            System.out.println("aaaaaaaaa teste");
        });

        column.add(button);

        column.fillMaxSize();
    }

    @Override
    public void doLayout() {
        super.doLayout();
        table.doLayout();

    }
}
