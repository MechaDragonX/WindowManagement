package com.mechadragonx.ui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Window
{
    private static Random rng = new Random();

    private Dimension size;
    private Color color;
    private Point position;

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
