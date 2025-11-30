package com.escolaDeIdiomas.model;

import me.texels.mySqlOrm.Table;
import me.texels.mySqlOrm.annotations.Column;
import me.texels.mySqlOrm.column.ColumnTypes;

public class User extends Table {
    @Column(type = ColumnTypes.INTEGER, unsigned = true, autoIncrement = true, primaryKey = true)
    public int id;
    @Column(type = ColumnTypes.STRING)
    public String name;
    @Column(type = ColumnTypes.STRING)
    public String email;


}
