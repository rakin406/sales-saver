package com.rakin;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

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

        JPanel panel = new JPanel();

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        JFormattedTextField amountTextField = new JFormattedTextField(currencyFormat);
        amountTextField.setName("Amount");
        amountTextField.setColumns(10);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setLabelFor(amountTextField);

        panel.add(amountLabel);
        panel.add(amountTextField);

        JPanel mainPanel = new JPanel();
        mainPanel.add(panel);

        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }
}