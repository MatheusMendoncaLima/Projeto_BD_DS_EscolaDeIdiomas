package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends Component {
    private final JButton button;
    private String text;
    public Runnable action;
    public Button(String text, Runnable action) {
        super(new BorderLayout());
        button=new JButton();
        setText(text);
        setAction(action);
        button.addActionListener(e -> this.action.run());
        add(button);
        setSize(30,60);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        button.setText(text);
    }

    public Runnable getAction() {
        return action;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }

    @Override
    public void doLayout() {
        super.doLayout();
        System.out.println("y do botao + " + getY());
    }
}
