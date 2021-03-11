package com.github.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class PaintPanel extends JPanel implements MouseListener, MouseMotionListener {

    private int x, y;

    public static List<CustomLine> lines = new ArrayList<>();

    private int color;

    private int width;

    private Graphics2D g2d;

    public Graphics2D getG2d(){
        return  g2d;
    }

    public PaintPanel() {
        setBounds(10, 60, 800, 600);
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(Boolean.TRUE);
    }

    public void setColor(int color){
        this.color = color;
    }

    public void setWidth(int width){
        this.width = width;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;
        for (CustomLine line : lines) {
            g2d.setStroke(new BasicStroke(line.getWidth()));
            g2d.setColor(new Color(line.getColor()));
            g2d.drawLine(line.getFirstX(), line.getFirstY(), line.getLastX(), line.getLastY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        this.x = p.x;
        this.y = p.y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = e.getPoint();
        int newX = p.x;
        int newY = p.y;
        lines.add(new CustomLine(this.x, this.y, newX, newY, this.color, this.width));
        this.x = newX;
        this.y = newY;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
