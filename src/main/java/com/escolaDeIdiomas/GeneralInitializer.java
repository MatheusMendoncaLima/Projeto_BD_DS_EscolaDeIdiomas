package com.escolaDeIdiomas;

import com.escolaDeIdiomas.model.User;
import me.texels.mySqlOrm.Database;

public class GeneralInitializer {
    public static void init(){
        Database db = new Database("projetoDs", new Database.Ip("localhost", 3306), "root", "");
        db.connect();
        User.init(User.class, db);
        User.sync();
    }
}
