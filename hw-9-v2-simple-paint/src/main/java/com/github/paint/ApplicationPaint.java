package com.github.paint;

import com.github.paint.commands.PaintColorThicknessCommands;
import com.github.paint.commands.PaintFileCommands;
import com.github.paint.view.PaintColorClearPanel;
import com.github.paint.view.PaintFilePanel;
import com.github.paint.view.PaintFrame;
import com.github.paint.view.PaintThicknessPanel;

public class ApplicationPaint {

    public static void main(String[] args) {
        PaintColorThicknessCommands colorThicknessCommands = new PaintColorThicknessCommands();
        PaintFileCommands fileCommands = new PaintFileCommands();
        PaintPanel paintPanel = new PaintPanel();
        fileCommands.setPaintPanel(paintPanel);

        colorThicknessCommands.setPaintPanelColor(paintPanel);
        colorThicknessCommands.setGraphics2D(paintPanel.getG2d());

        new PaintFrame(paintPanel, new PaintThicknessPanel(colorThicknessCommands), new PaintColorClearPanel(colorThicknessCommands), new PaintFilePanel(fileCommands))
                .getContentPane();
    }
}
