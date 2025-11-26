package com.escolaDeIdiomas;

import com.escolaDeIdiomas.components.Column;

import javax.swing.*;
import java.awt.*;

public class Component extends JPanel {
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

    public Component(LayoutManager layoutManager) {
        super(layoutManager);
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
        horizontalPercentage = percentage;
        this.width = handleMaxAndMins((int) (getParent().getWidth() * percentage) - mgStart - mgEnd, maxWidth, minWidth);
    }

    public void fillMaxWidth() {
        horizontalPercentage = 1f;
        this.width = handleMaxAndMins(getParent().getWidth() - mgStart - mgEnd, maxWidth, minWidth);

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
        verticalPercentage = percentage;
        this.height = handleMaxAndMins((int) (getParent().getHeight() * percentage) - mgTop - mgBottom, maxHeight, minHeight);
        // System.out.println();
    }

    public void fillMaxHeight() {
        verticalPercentage = 1f;
        this.height = handleMaxAndMins(getParent().getHeight() - mgTop - mgBottom, maxHeight, minHeight);
    }

    public void setHeight(int height) {
        verticalPercentage = -1;
        this.height = handleMaxAndMins(height, maxHeight, minHeight);
    }

    public void fillSize(float percentage) {
        fillHeight(percentage);
        fillWidth(percentage);

    }

    public void fillMaxSize() {
        fillMaxHeight();
        fillMaxWidth();
    }

    public void setSize(int height, int width) {
        setHeight(height);
        setWidth(width);
    }

    public void updateWidthByPercentage() {
        if (horizontalPercentage != -1) fillWidth(horizontalPercentage);
        if (verticalPercentage != -1) fillHeight(verticalPercentage);
    }

    public void adjustPosition() {

        if (!(this.getParent() instanceof Column)) return;


        Column parent = (Column) this.getParent();
        if (verticalAlignment == VerticalAlignment.BOTTOM) {
            setY(this.getParent().getY() + this.getParent().getHeight() - this.height - this.mgBottom);
        } else if (verticalAlignment == VerticalAlignment.CENTER) {
            setY((this.getParent().getY() + this.getParent().getHeight() - this.height) / 2 - this.mgBottom);
        }else if (verticalAlignment == VerticalAlignment.TOP) {
            setY(parent.getTargetY() + this.mgTop);
        }

        if (horizontalAlignment == HorizontalAlignment.END) {
            setX(this.getParent().getX() + this.getParent().getWidth() - this.width - this.mgEnd);
        } else if (horizontalAlignment == HorizontalAlignment.CENTER) {
            setX((this.getParent().getX() + this.getParent().getWidth() - this.width) / 2 - this.mgEnd);
        } else if (horizontalAlignment == HorizontalAlignment.START) {
            setX(parent.getTargetX() + this.mgStart);

        }

    }


    @Override
    public void doLayout() {
        super.doLayout();
        setBounds(x, y, width, height);
        updateWidthByPercentage();
        adjustPosition();
        revalidate();
    }
}
