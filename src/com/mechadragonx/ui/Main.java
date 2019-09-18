package com.mechadragonx.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main
{
    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame();

        mainFrame.setSize(1000,1000);
        mainFrame.setVisible(true);

        Window window1 = new Window(new Dimension(200, 200));
        window1.setSize(window1.getSize());
        window1.setVisible(true);

        Window window2 = new Window(new Dimension(100, 100));
        window2.setSize(window2.getSize());
        // Explicitly set position, otherwise panel is added behind first one
        window2.setPosition(window2.getPosition());
        window2.setVisible(true);

        Window window3 = new Window(new Dimension(300, 300));
        window3.setSize(window3.getSize());
        window3.setPosition(window3.getPosition());
        window3.setVisible(true);

        mainFrame.add(window1);
        mainFrame.add(window2);
        mainFrame.add(window3);
    }
}
