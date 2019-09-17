package com.mechadragonx.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window
{
    private static Random rng = new Random();

    private Point position;
    private Dimension dimension;
    private Color color;

    public Window(Dimension dimension)
    {
        this.dimension = dimension;
        // this.color = new Color(rng.nextFloat(), rng.nextFloat(), rng.nextFloat());
        this.color = color.BLUE;
    }

    public void draw(Graphics gfx, JPanel panel)
    {
         gfx.setColor(color);
        gfx.drawRect(rng.nextInt(panel.getPreferredSize().width), rng.nextInt(panel.getPreferredSize().height), dimension.width, dimension.height);
        gfx.drawRect(100, 100, 100,100);
        panel.paint(gfx);
    }
    public void click()
    {
        position = MouseInfo.getPointerInfo().getLocation();
    }
}
