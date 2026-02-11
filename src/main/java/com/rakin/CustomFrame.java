package com.rakin;

import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame {
    CustomFrame() {
        this.setTitle("Sales Saver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);

        // Set colors
        this.getContentPane().setBackground(new Color(245, 245, 245));
        this.getContentPane().setForeground(new Color(17, 17, 17));
    }
}