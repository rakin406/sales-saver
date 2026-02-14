package com.rakin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomFrame extends JFrame implements ActionListener {
    private static JTextField amountTextField;
    private static JButton submitButton;

    CustomFrame() {
        this.setTitle("Sales Saver");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

        // Set colors
        this.getContentPane().setBackground(new Color(245, 245, 245));
        this.getContentPane().setForeground(new Color(17, 17, 17));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setPreferredSize(new Dimension(400, 0));
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        amountTextField = new JTextField();
        amountTextField.setName("Amount");
        amountTextField.setColumns(10);
        amountTextField.setFont(new Font("Segoe UI", Font.PLAIN, 35));
        amountTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel amountLabel = new JLabel("Amount: ");
        amountLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
        amountLabel.setLabelFor(amountTextField);
        amountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        panel.add(amountLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(amountTextField);
        panel.add(Box.createVerticalStrut(80));
        panel.add(submitButton);

        mainPanel.add(sidePanel, BorderLayout.WEST);
        mainPanel.add(panel, BorderLayout.CENTER);

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            System.out.println(amountTextField.getText());
            amountTextField.setText("");
        }
    }
}