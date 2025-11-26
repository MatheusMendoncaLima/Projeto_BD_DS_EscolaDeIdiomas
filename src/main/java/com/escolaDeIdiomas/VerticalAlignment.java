package com.escolaDeIdiomas;

public class VerticalAlignment {
    public static final VerticalAlignment TOP = VerticalAlignment.top();
    public static final VerticalAlignment CENTER = VerticalAlignment.center();
    public static final VerticalAlignment BOTTOM = VerticalAlignment.bottom();
    private static final String _TOP = "START";
    private static final String _CENTER = "CENTER";
    private static final String _BOTTOM = "END";
    String type;

    private static VerticalAlignment top() {
        return new VerticalAlignment(_TOP);
    }

    private static VerticalAlignment center() {
        return new VerticalAlignment(_CENTER);
    }

    private static VerticalAlignment bottom() {
        return new VerticalAlignment(_BOTTOM);
    }


    private VerticalAlignment(String type) {
        this.type = type;
    }

}
