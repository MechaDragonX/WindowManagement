package com.mechadragonx.ui;

import com.sun.java.swing.plaf.motif.MotifBorders;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class Main
{
    public static void main(String[] args) {
        {
            JFrame mainFrame = new JFrame();
            mainFrame.setLayout(new GridBagLayout());
            mainFrame.setTitle("Windows");
            //This line is needed to set the initial size of the window (i.e. JFrame)
            mainFrame.setSize(new Dimension(1280,720));
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(Color.RED);
            mainFrame.setPreferredSize(new Dimension(1280, 720));
            panel.setPreferredSize(new Dimension(1280, 720));
           //This line is needed to set the size of the panel
            panel.setSize(new Dimension(1280, 720));
            panel.setVisible(true);

            mainFrame.add(panel);
            mainFrame.setVisible(true);


            Window window = new Window(new Dimension(100, 100));
            window.draw(panel.getGraphics(), panel);
        }
    }
}
