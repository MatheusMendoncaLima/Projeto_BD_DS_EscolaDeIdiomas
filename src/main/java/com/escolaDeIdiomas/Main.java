package com.escolaDeIdiomas;

import com.escolaDeIdiomas.model.User;
import com.escolaDeIdiomas.views.MainPage;

public class Main {
    public static void main(String[] args) {
        GeneralInitializer.init();
        User user =new User();
        user.name = "lindo";
        user.save();
        Frame mainFrame = new Frame();
        mainFrame.setContentPane(new MainPage());
        mainFrame.setVisible(true);

    }
}
