package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;

import javax.swing.*;
import java.awt.*;

public class Button extends com.escolaDeIdiomas.Component {
    private final JButton button;
    private String text;
    public Runnable action;
    public Button(Component parent, String text, Runnable action) {
        super(parent, new BorderLayout());
        button=new JButton();
        setText(text);
        setAction(action);
        button.addActionListener(e -> this.action.run());
        add(button);
        setSize(60,30);
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

}
