package com.escolaDeIdiomas;

public class HorizontalAlignment {
    public static final HorizontalAlignment START = HorizontalAlignment.start();
    public static final HorizontalAlignment CENTER = HorizontalAlignment.center();
    public static final HorizontalAlignment END = HorizontalAlignment.end();
    private static final String _START = "START";
    private static final String _CENTER = "CENTER";
    private static final String _END = "END";
    String type;
    private static HorizontalAlignment start(){
        return new HorizontalAlignment(_START);
    }
    private static HorizontalAlignment end(){
        return new HorizontalAlignment(_END);
    }
    private static HorizontalAlignment center(){
        return new HorizontalAlignment(_CENTER);
    }
    private HorizontalAlignment(String type){
        this.type=type;
    }

}
