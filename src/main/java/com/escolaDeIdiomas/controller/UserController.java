package com.escolaDeIdiomas.controller;

import com.escolaDeIdiomas.model.User;
import me.texels.mySqlOrm.Where;

import java.util.List;

public class UserController {
    public static Object[][] getAllUsersInString(){
        List<User> allUsers = User.find(new Where());
        String[][] returnValue = new String[allUsers.size()][2];

        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            returnValue[i][0]=""+user.id;
            returnValue[i][1]=user.name;
        }
        return returnValue;
    }

}
