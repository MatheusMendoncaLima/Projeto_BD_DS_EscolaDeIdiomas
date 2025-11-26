package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;
import com.escolaDeIdiomas.controller.UserController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Table extends Component {
    private final JTable jTable;
    private final JScrollPane scroll;


    public JTable getjTable() {
        return jTable;
    }
    public JScrollPane getScroll() {
        return scroll;
    }


    public Table(Object[][] values, String[] columns){
        super(new BorderLayout());
        this.jTable=new JTable(values,columns);
        this.scroll = new JScrollPane(jTable);
        add(scroll, BorderLayout.CENTER);
        setOpaque(false);
    }

    @Override
    public void doLayout() {
        super.doLayout();
        System.out.println("y da table - " + getY());
    }
}
