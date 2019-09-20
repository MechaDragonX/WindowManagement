package com.mechadragonx.ui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Main
{
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private static final int COLLECTION_SIZE = 10;
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> showFrame());
    }

    private static void showFrame()
    {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Panel panel = new Panel(new Dimension(WIDTH,HEIGHT));
        panel.populate(COLLECTION_SIZE);

        frame.add(panel);
        panel.setVisible(true);
    }
}
