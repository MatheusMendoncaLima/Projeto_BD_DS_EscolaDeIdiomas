package com.escolaDeIdiomas;

import com.escolaDeIdiomas.views.MainPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Frame  extends JFrame {
    private final Frame self = this;
    Timer resizeTimer;
    private Container contentPane = null;
    public Frame(){
        setSize(800,600);
        setResizable(true);
        setDefaultCloseOperation(3);
        setName("Escola de idiomas");
        setLocationRelativeTo(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (contentPane == null) return;
                if (resizeTimer != null) resizeTimer.stop();

                resizeTimer = new Timer(15, ev -> {
                    System.out.println("Resize contínuo: " + getWidth() + "x" + getHeight());
                    self.doLayout();
                    contentPane.doLayout();

                });

                resizeTimer.setRepeats(false);
                resizeTimer.start();
            }
        });

    }

    @Override
    public void setContentPane(Container contentPane) {
        this.contentPane = contentPane;
        super.setContentPane(contentPane);
    }

}
