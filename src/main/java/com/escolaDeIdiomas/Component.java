package com.escolaDeIdiomas;

import com.escolaDeIdiomas.components.Box;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Component extends JPanel {
    public final List<Runnable> executeAfterReady = new ArrayList<>();
    private int mgTop = 0;
    private int mgBottom = 0;
    private int mgStart = 0;
    private int mgEnd = 0;
    private int width = 0;
    private int height = 0;
    private int maxWidth = -1;
    private int maxHeight = -1;
    private int minWidth = -1;
    private int minHeight = -1;
    private int x = 0;
    private int y = 0;
    private int initialX = 0;
    private int initialY = 0;
    private float verticalPercentage = -1;
    private float horizontalPercentage = -1;
    private VerticalAlignment verticalAlignment = VerticalAlignment.TOP;
    private HorizontalAlignment horizontalAlignment = HorizontalAlignment.START;

    public Component(Component parent,LayoutManager layoutManager) {
        super(layoutManager);
        if (parent != null) parent.add(this);
    }

    public int getMgTop() {
        return mgTop;
    }

    public void setMgTop(int mgTop) {
        this.mgTop = mgTop;
    }


    public int getMgBottom() {
        return mgBottom;
    }

    public void setMgBottom(int mgBottom) {
        this.mgBottom = mgBottom;
    }

    public int getMgEnd() {
        return mgEnd;
    }

    public void setMgEnd(int mgEnd) {
        this.mgEnd = mgEnd;
    }

    public int getMgStart() {
        return mgStart;
    }

    public void setMgStart(int mgStart) {
        this.mgStart = mgStart;
    }

    public VerticalAlignment getVerticalAlignment() {
        return verticalAlignment;
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    public HorizontalAlignment getHorizontalAlignment() {
        return horizontalAlignment;
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    public float getHorizontalPercentage() {
        return horizontalPercentage;
    }

    public void setHorizontalPercentage(float horizontalPercentage) {
        this.horizontalPercentage = horizontalPercentage;
    }

    public float getVerticalPercentage() {
        return verticalPercentage;
    }

    public void setVerticalPercentage(float verticalPercentage) {
        this.verticalPercentage = verticalPercentage;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void fillWidth(float percentage) {
            executeAfterReady.add(()-> fillWidthRaw(percentage));
    }
    public void fillWidthRaw(float percentage) {
        if (this.getParent() == null) return;
        horizontalPercentage = percentage;
        this.width = handleMaxAndMins((int) (getParent().getWidth() * percentage) - mgStart - mgEnd, maxWidth, minWidth);
    }
    public void fillMaxWidth() {
        fillWidth(1f);
    }

    public void fillMaxWidthRaw() {
        fillWidthRaw(1f);
    }

    public void setWidth(int width) {
        horizontalPercentage = -1;
        this.width = handleMaxAndMins(width, maxWidth, minWidth);
    }

    private int handleMaxAndMins(int value, int maxValue, int minValue) {
        if (maxValue != -1) value = Math.min(value, maxValue);
        if (minValue != -1) value = Math.max(value, minValue);
        return value;

    }


    public void fillHeight(float percentage) {
        executeAfterReady.add(()->{
            fillHeightRaw(percentage);
        });
    }
    public void fillHeightRaw(float percentage) {
        if (this.getParent() == null) return;
        verticalPercentage = percentage;


        this.height = handleMaxAndMins((int) (getParent().getHeight() * percentage) - mgTop - mgBottom, maxHeight, minHeight);
    }

    public void fillMaxHeight() {
        fillHeight(1f);
    }
    public void fillMaxHeightRaw() {
        fillHeightRaw(1f);
    }

    public void setHeight(int height) {
        verticalPercentage = -1;
        this.height = handleMaxAndMins(height, maxHeight, minHeight);
    }

    public void fillSize(float percentage) {
        fillHeight(percentage);
        fillWidth(percentage);

    }
    public void fillSizeRaw(float percentage) {
        fillHeightRaw(percentage);
        fillWidthRaw(percentage);
    }

    public void fillMaxSize() {
        fillMaxHeight();
        fillMaxWidth();
    }
    public void fillMaxSizeRaw() {
        fillMaxHeightRaw();
        fillMaxWidthRaw();
    }

    public void setSize(int width,int height) {
        setHeight(height);
        setWidth(width);
    }

    public void updateWidthByPercentage() {
        if (horizontalPercentage != -1) fillWidthRaw(horizontalPercentage);
        if (verticalPercentage != -1) fillHeightRaw(verticalPercentage);
    }

    public void adjustPosition() {

        if ( this.getParent() == null || !(this.getParent() instanceof com.escolaDeIdiomas.components.Box)) return;


        com.escolaDeIdiomas.components.Box parent = (Box) this.getParent();
        if (verticalAlignment == VerticalAlignment.BOTTOM) {
            setY(this.getParent().getY() + this.getParent().getHeight() - this.height - this.mgBottom);
        } else if (verticalAlignment == VerticalAlignment.CENTER) {
            setY(parent.getTargetY(this)+(parent.getHeight()- this.getHeight() + this.mgStart+this.mgEnd)/2);
        }else if (verticalAlignment == VerticalAlignment.TOP) {
            setY(parent.getTargetY(this) + this.mgTop);
        }

        if (horizontalAlignment == HorizontalAlignment.END) {
            setX(parent.getTargetX(this)+parent.getWidth() - this.width - this.mgEnd);
        } else if (horizontalAlignment == HorizontalAlignment.CENTER) {
            setX(parent.getTargetX(this)+(parent.getWidth()- this.getWidth() + this.mgStart+this.mgEnd)/2);
        } else if (horizontalAlignment == HorizontalAlignment.START) {
            setX(parent.getTargetX(this) + this.mgStart);

        }

    }


    public void executeAfterReady(){
        for(Runnable runnable : executeAfterReady){
            runnable.run();
        }

    }

    @Override
    public void doLayout() {
        super.doLayout();
        super.doLayout();
        setBounds(x, y, width, height);
        updateWidthByPercentage();
        adjustPosition();
        revalidate();
    }
}
