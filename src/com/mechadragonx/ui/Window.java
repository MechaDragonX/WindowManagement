package com.mechadragonx.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;

public class Window
{
    private static Random rng = new Random();

    private Color color;
    private Point position;
    private Dimension size;

    public Window(Dimension size)
    {
        color = new Color(rng.nextFloat(), rng.nextFloat(), rng.nextFloat());
        position = new Point(rng.nextInt(size.width), rng.nextInt(size.height));
        this.size = size;
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


    public boolean pointInside(Point point)
    {
        if(point.x >= getPosition().x && point.x <= getPosition().x + getSize().width)
        {
            if(point.y >= getPosition().y && point.y <= getPosition().y + getSize().height)
            {
                return true;
            }
        }
        return false;
    }
}
