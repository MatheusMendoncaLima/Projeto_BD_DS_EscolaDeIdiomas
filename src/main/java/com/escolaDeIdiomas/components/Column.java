package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;

public class Column extends Box{

    public Column(Component parent) {
        super(parent);
    }

    @Override
    public int getTargetY(Component target) {
        if (getChildren().isEmpty() || !getChildren().contains(target)) return 0;
        int indexOfTarget = getChildren().indexOf(target);
        if (indexOfTarget == 0) return 0;
        Component lastChild = getChildren().get(indexOfTarget-1);
        return lastChild.getY() + lastChild.getHeight() + lastChild.getMgBottom();
    }
    @Override
    public void wrapContentWidth() {
        if (getChildren().isEmpty()) return;
        int maxWidth = 0;
        for (Component child : getChildren()) {
            maxWidth = Math.max(child.getWidth() + child.getMgStart() + child.getMgEnd(), maxWidth);
        }
        setWidth(maxWidth);
    }
    @Override
    public void wrapContentHeight() {
        if (getChildren().isEmpty()) return;
        int maxHeight = 0;
        for (Component child : getChildren()) {
            maxHeight += child.getHeight() + child.getMgTop() + child.getMgBottom();
        }
        setHeight(maxHeight);
    }
}
