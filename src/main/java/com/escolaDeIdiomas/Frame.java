package com.escolaDeIdiomas;

import com.escolaDeIdiomas.components.Page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Frame  extends JFrame {
    private final Frame self = this;
    Timer resizeTimer;
    private Page page = null;
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
                if (page == null) return;
                if (resizeTimer != null) resizeTimer.stop();

                resizeTimer = new Timer(1, ev -> {
                    System.out.println("Resize contínuo: " + getWidth() + "x" + getHeight());
                    page.fillMaxSizeRaw();
                    self.doLayout();
                    page.doLayout();

                });

                resizeTimer.setRepeats(false);
                resizeTimer.start();
            }
        });

    }

    @Override
    public void setContentPane(Container contentPane) {
        if (!(contentPane instanceof Page)) return;
        this.page = (Page) contentPane;
        super.setContentPane(contentPane);
        for (Component component : ((Page) contentPane).getChildren()){
            component.executeAfterReady();
        }
    }

}
