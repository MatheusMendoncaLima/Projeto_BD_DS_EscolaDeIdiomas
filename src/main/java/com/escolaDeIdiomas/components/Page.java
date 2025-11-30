package com.escolaDeIdiomas.components;

import com.escolaDeIdiomas.Component;

import java.util.ArrayList;
import java.util.List;

public class Page extends Component {
    private final List<Component> children = new ArrayList<>();

    public Page() {
        super(null, null);
        setOpaque(true);
    }

    public List<Component> getChildren() {
        return children;
    }

    @Override
    protected void addImpl(java.awt.Component comp, Object constraints, int index) {
        if (!(comp instanceof Component)) return;
        children.add((Component) comp);
        super.addImpl(comp, constraints, index);
    }

    @Override
    public void doLayout() {
        super.doLayout();
        getChildren().forEach(child -> child.doLayout());
    }
}
