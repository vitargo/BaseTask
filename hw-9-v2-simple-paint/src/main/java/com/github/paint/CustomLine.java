package com.github.paint;

import java.io.Serializable;
import java.util.Objects;

public class CustomLine implements Serializable {

    private int firstX, firstY, lastX, lastY;

    private int color;

    private int width;

    public void setFirstX(int firstX) {
        this.firstX = firstX;
    }

    public void setFirstY(int firstY) {
        this.firstY = firstY;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public CustomLine(int firstX, int firstY, int lastX, int lastY, int color, int width) {
        this.firstX = firstX;
        this.firstY = firstY;
        this.lastX = lastX;
        this.lastY = lastY;
        this.color = color;
        this.width = width;
    }
    public CustomLine() {

    }

    public int getFirstX() {
        return firstX;
    }

    public int getFirstY() {
        return firstY;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public int getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomLine line = (CustomLine) o;
        return firstX == line.firstX && firstY == line.firstY && lastX == line.lastX && lastY == line.lastY && color == line.color && width == line.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstX, firstY, lastX, lastY, color, width);
    }

    @Override
    public String toString() {
        return "CustomLine{" +
                "firstX=" + firstX +
                ", firstY=" + firstY +
                ", lastX=" + lastX +
                ", lastY=" + lastY +
                ", color=" + color +
                ", width=" + width +
                '}';
    }
}
