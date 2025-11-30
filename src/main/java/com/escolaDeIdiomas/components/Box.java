package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;

import java.util.ArrayList;
import java.util.List;

public class Box extends Component {
    private final List<Component> children = new ArrayList<>();

    public List<Component> getChildren() {
        return children;
    }

    @Override
    public java.awt.Component add(java.awt.Component comp) {
        if (!(comp instanceof Component)) return null;
        children.add((Component) comp);
        return super.add(comp);
    }

    public int getTargetX(Component target) {
        return 0;
    }

    public int getTargetY(Component target) {
        return 0;
    }

    public void wrapContentWidth() {
        if (getChildren().isEmpty()) return;
        int maxWidth = 0;
        for (Component child : getChildren()) {
            maxWidth = Math.max(child.getWidth() + child.getMgStart() + child.getMgEnd(), maxWidth);
        }
        setWidth(maxWidth);
    }

    public void wrapContentHeight() {
        if (getChildren().isEmpty()) return;
        int maxHeight = 0;
        for (Component child : getChildren()) {
            maxHeight = Math.max(child.getHeight() + child.getMgTop() + child.getMgBottom(), maxHeight);
        }
        setHeight(maxHeight);
    }

    public void wrapContentSize() {
        wrapContentWidth();
        wrapContentHeight();
    }

    @Override
    public void doLayout() {
        super.doLayout();
        getChildren().forEach(child -> child.doLayout());

    }

    @Override
    public void executeAfterReady() {
        super.executeAfterReady();
        for (Component child : children){
            child.executeAfterReady();
        }
    }

    public Box(Component parent) {
        super(parent, null);
        setOpaque(false);
    }


}
