package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Column extends Component {
    private final List<Component> children = new ArrayList<>();

    public Column() {
        super(null);

    }
    @Override
    public java.awt.Component add(java.awt.Component comp) {
        if (!(comp instanceof Component)) return null;
        children.add((Component) comp);
        return super.add(comp);
    }

    public int getTargetX() {
        if (children.isEmpty()) return this.getX();
        Component lastChild = children.get(children.size() - 2);
        return lastChild.getX() + lastChild.getMgEnd();
    }

    public int getTargetY() {
        if (children.isEmpty()) return this.getY();
        Component lastChild = children.get(children.size() - 2);
        return lastChild.getY() + lastChild.getHeight() + lastChild.getMgBottom();
    }

    public void wrapContentWidth(){
        if (children.isEmpty()) return;
        int maxWidth= 0;
        for (Component child : children){
            maxWidth = Math.max(child.getWidth()+child.getMgStart()+child.getMgEnd(), maxWidth);
        }
        setWidth(maxWidth);
    }

    @Override
    public void doLayout() {
        super.doLayout();
        children.forEach(child-> child.doLayout());
    }
}
