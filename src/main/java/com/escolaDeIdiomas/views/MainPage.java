package com.escolaDeIdiomas.views;

import com.escolaDeIdiomas.*;
import com.escolaDeIdiomas.components.Button;
import com.escolaDeIdiomas.components.*;
import com.escolaDeIdiomas.controller.UserController;

import java.awt.*;

public class MainPage extends Page {
    public MainPage() {
        setBackground(Color.darkGray);

        Row row = new Row(this);
        row.fillMaxSize();
        Column column = new Column(row);
        column.fillMaxSize();
        column.setMinHeight(100);
        column.setMinWidth(200);
        column.setMaxWidth(500);

        Table table = new Table(column, UserController.getAllUsersInString(),
                UserController.getAllColumnNames());
        table.fillMaxWidth();
        table.fillHeight(0.7f);

        Button button = new Button(column, "lixo", ()->{
            System.out.println("aaaaaaaaa teste");
        });
        button.setHorizontalAlignment(HorizontalAlignment.CENTER);
    }
}
