package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;

public class Row extends Box{
    public Row(Component parent) {
        super(parent);
    }

    @Override
    public int getTargetX(Component target) {
        if (getChildren().isEmpty() || !getChildren().contains(target)) return this.getX();
        int indexOfTarget = getChildren().indexOf(target);
        if (indexOfTarget == 0) return 0;
        Component lastChild = getChildren().get(indexOfTarget-1);
        return lastChild.getX()+lastChild.getWidth() + lastChild.getMgEnd();
    }
    @Override
    public void wrapContentWidth() {
        if (getChildren().isEmpty()) return;
        int maxWidth = 0;
        for (Component child : getChildren()) {
            maxWidth += child.getWidth() + child.getMgStart() + child.getMgEnd();
        }
        setWidth(maxWidth);
    }
}
