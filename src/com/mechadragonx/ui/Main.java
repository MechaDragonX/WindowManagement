package com.mechadragonx.ui;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        Panel panel = new Panel(new Dimension(1000,1000));
        panel.populate(5);


        frame.add(panel);
        panel.setVisible(true);



    }
}
