package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import models.Board;

public class BoardView extends JFrame implements ActionListener {
    private Board b = new Board();

    public BoardView() {
        super("Talabia Chess");

        for (int i = 0; i < 42; i++) {
            JButton button = new JButton();
            if (i % 2 == 0)
                button.setBackground(Color.WHITE);
            else
                button.setBackground(Color.BLACK);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(this);
            add(button);
        }

        setLayout(new GridLayout(6, 7));
        setSize(b.getDimensionX(), b.getDimensionY());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setBoard(Board b) {
        this.b = b;
    }

    public void repaint() {
        super.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("Button clicked!");
    }
}
