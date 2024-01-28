package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Game;

public class MenuView extends JFrame {

    public MenuView() {
        super("Welcome to Talabia Chess Game");

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new GridLayout(3, 1)); // Adjusted to 3 rows

        JLabel label = new JLabel("Welcome to Talabia Chess Game");
        label.setHorizontalAlignment(JLabel.CENTER);
        panel.add(label);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // Use GridLayout for buttons

        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        panel.add(buttonPanel);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the welcome window
                new Game(); // Start the game
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
}
