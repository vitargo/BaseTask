package com.github.simple.paint.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.Map;

public class AreaPaint extends JComponent {
    private Image image;
    private Graphics2D gr;
    private int currentX, currentY,oldX, oldY;

    public AreaPaint(){
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                currentX = e.getX();
                currentY = e.getY();

                if(gr != null){
                    gr.drawLine(oldX, oldY, currentX, currentY);
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g){
        if(image == null){
            image = createImage(getSize().width, getSize().height);
            gr = (Graphics2D) image.getGraphics();
            gr.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear(){
        gr.setPaint(Color.white);
        gr.fillRect(0,0,getSize().width, getSize().height);
        gr.setPaint(Color.black);
        repaint();
    }

    public void colorChooser(){
        gr.setPaint(JColorChooser.showDialog(new JFrame(), "Select a color", Color.RED));
    }

    public void thicknessLine(int thick){
        gr.setStroke(new BasicStroke(thick));
    }
}

