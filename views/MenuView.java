package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Game;

//AU JI HIN
public class MenuView extends JFrame {

    public MenuView() {
        super("Welcome to Talabia Chess Game");

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        JLabel label = new JLabel("Welcome to Talabia Chess Game");
        label.setHorizontalAlignment(JLabel.CENTER);

        // Set preferred size for the title label
        Dimension titleLabelSize = new Dimension(500, 50);
        label.setPreferredSize(titleLabelSize);

        panel.add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1)); 

        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        // button size
        Dimension buttonSize = new Dimension(300, 50);
        startButton.setPreferredSize(buttonSize);
        exitButton.setPreferredSize(buttonSize);

        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        panel.add(buttonPanel, BorderLayout.CENTER);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Game(); // Start the game
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the game
            }
        });

        setSize(500, 200); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
