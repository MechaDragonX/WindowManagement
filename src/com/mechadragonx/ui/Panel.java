package com.mechadragonx.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel implements MouseListener, MouseMotionListener
{
    private static Random rng = new Random();

    private Dimension size;
    private Point position;
    private ArrayList<Window> windows;

    public Panel(Dimension size)
    {
        this.setPreferredSize(size);
        this.setSize(size);
        this.size = size;
        position = new Point(size.width / 2, size.height / 2);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public Point getPosition()
    {
        return position;
    }
    public void setPosition(Point position)
    {
        this.position = position;
    }
    public Dimension getSize()
    {
        return size;
    }

    public void populate(int collectionSize)
    {
        windows = new ArrayList<Window>();
        for(int i = 0; i < collectionSize; i++)
        {
            windows.add(new Window(new Dimension(rng.nextInt(size.width), rng.nextInt(size.height))));
        }
    }

    private void checkAndRedraw()
    {
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        for(int i = 0; i < windows.size(); i++)
        {
            if(windows.get(i).pointInside(mousePos) && i != 0)
            {
                Window currentWindow = windows.get(i);
                windows.remove(i);
                windows.add(0, currentWindow);
//                windows.get(0).setPosition(mousePos);
                this.repaint();
                break;
            }
        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i = windows.size() - 1; i >= 0; i--)
        {
            g.setColor(windows.get(i).getColor());
            g.fillRect(windows.get(i).getPosition().x, windows.get(i).getPosition().y, windows.get(i).getSize().width, windows.get(i).getSize().height);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        checkAndRedraw();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
//        checkAndRedraw();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
//        Point mousePos = MouseInfo.getPointerInfo().getLocation();
//        for(int i = windows.size() - 1; i >= 0; i--)
//        {
//            if(windows.get(i).pointInside(mousePos))
//            {
//                mouseEntered = true;
//                System.out.println("in");
//                break;
//            }
//            else
//            {
//                mouseEntered = false;
//                System.out.println("out");
//            }
//        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
//        Point mousePos = MouseInfo.getPointerInfo().getLocation();
//        for(int i = windows.size() - 1; i >= 0; i--)
//        {
//            if(windows.get(i).pointInside(mousePos))
//            {
//                mouseEntered = true;
//                System.out.println("in");
//            }
//            else
//            {
//                mouseEntered = false;
//                System.out.println("out");
//            }
//        }

//        Point mousePos = getMousePosition();
//        Window currentWindow = (Window) e.getSource();
//        findIndex(currentWindow);
//        mouseEntered = isMouseWithinComponent((Component) e.getSource());
//        if(mouseEntered)
//        {
//            System.out.println("in");
//        }
//        else
//        {
//            System.out.println("out");
//        }
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }
}