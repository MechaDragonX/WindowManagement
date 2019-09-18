package com.mechadragonx.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window extends JPanel
{
    private static Random rng = new Random();

    private Dimension size;
    private Point position;
    private Color color;

    public Window(Dimension size)
    {
        this.size = size;
        position = new Point(rng.nextInt(size.width), rng.nextInt(size.height));
        color = new Color(rng.nextFloat(), rng.nextFloat(), rng.nextFloat());
    }

    public Dimension getSize()
    {
        return size;
    }
    public Point getPosition()
    {
        return position;
    }
    public void setPosition(Point position)
    {
        this.position = position;
    }
    public Color getColor()
    {
        return color;
    }

    public void paintComponent(Graphics gfx)
    {
        super.paintComponent(gfx);
        gfx.setColor(color);
        gfx.fillRect(position.x, position.y, size.width, size.height);
    }
    public void click()
    {
        position = MouseInfo.getPointerInfo().getLocation();
    }
}
