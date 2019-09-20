package com.mechadragonx.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener
{
    private static Random rng = new Random();

    private Point position;
    private Dimension size;
    private ArrayList<Window> windows;

    public Panel(Dimension size)
    {
        position = new Point(size.width / 2, size.height / 2);
        this.setPreferredSize(size);
        this.setSize(size);
        this.size = size;

        this.addMouseListener(this);
    }

    public Dimension getSize()
    {
        return size;
    }

    public void populate(int collectionSize)
    {
        windows = new ArrayList<Window>(collectionSize);
        for(int i = 0; i < collectionSize; i++)
        {
            windows.add(new Window(new Dimension(rng.nextInt(size.width), rng.nextInt(size.height))));
        }
    }

    private void checkAndRedraw(MouseEvent e)
    {
        Point mousePos = e.getPoint();
        int[] hitCount = new int[windows.size()];

        int i = 0;
        for(Window window : windows)
        {
            if(window.pointInside(mousePos) && i != 0)
            {
                hitCount[i]++;
            }
            i++;
        }

        int count = 0;
        int j = 0;
        int index = 0;
        for(int num : hitCount)
        {
            if(num == 1)
            {
                count++;
                index = j;
            }
            j++;
        }
        if(count == 1)
        {
            Window currentWindow = windows.get(index);
            windows.remove(index);
            windows.add(0, currentWindow);
//            windows.get(0).setPosition(mousePos);
            this.repaint();
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

        checkAndRedraw(e);
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}