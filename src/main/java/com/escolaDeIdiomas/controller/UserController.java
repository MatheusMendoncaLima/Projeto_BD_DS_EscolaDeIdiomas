package com.escolaDeIdiomas.controller;

import com.escolaDeIdiomas.model.User;
import me.texels.mySqlOrm.Where;
import me.texels.mySqlOrm.annotations.Column;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    public static Object[][] getAllUsersInString(){
        List<User> allUsers = User.find(new Where());
        String[][] returnValue = new String[allUsers.size()][getAllColumnNames().length];

        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            returnValue[i][0]=""+user.id;
            returnValue[i][1]=user.name;
        }
        return returnValue;
    }

    public static String[] getAllColumnNames(){
        Field[] fields = User.class.getDeclaredFields();
        List<String> names = new ArrayList<>();
        for(Field field : fields){
            if (!field.isAnnotationPresent(Column.class)) continue;
            names.add(field.getName());
        }
        return names.toArray(new String[0]);
    }

}
