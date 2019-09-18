package com.mechadragonx.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Window extends JPanel implements MouseListener
{
    private static Random rng = new Random();

    private Dimension size;
    private Point position;
    private Color color;
    private boolean mouseEntered = false;
    private boolean mouseDown = false;

    public Window(Dimension size)
    {
        this.size = size;
        position = new Point(rng.nextInt(size.width), rng.nextInt(size.height));
        color = new Color(rng.nextFloat(), rng.nextFloat(), rng.nextFloat());
       this.addMouseListener(this);
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

    public boolean isMouseWithinComponent(Component c)
    {
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        Rectangle bounds = c.getBounds();
        bounds.setLocation(c.getLocationOnScreen());
        return bounds.contains(mousePos);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        mouseEntered = isMouseWithinComponent((Component) e.getSource());
        if(mouseEntered)
        {
            System.out.println("in");
        }
        else
        {
            System.out.println("out");
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        mouseEntered = isMouseWithinComponent((Component) e.getSource());
        if(mouseEntered)
        {
            System.out.println("in");
        }
        else
        {
            System.out.println("out");
        }
    }
}