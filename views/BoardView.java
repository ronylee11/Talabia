package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import models.Board;
import controllers.BoardController;

@SuppressWarnings("serial")
public class BoardView extends JFrame implements ActionListener {
    private Board b = new Board();
    PieceView[] buttons = new PieceView[42];

    public BoardView() {
        super("Talabia Chess");
        JPanel p = new JPanel();
        add(p);

        for (int i = 0; i < 42; i++) {
            PieceView button = new PieceView();
            buttons[i] = button;
            if (i % 2 == 0)
                button.setBackground(Color.WHITE);
            else
                button.setBackground(Color.BLACK);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(this);
            p.add(button);
        }

        p.setLayout(new GridLayout(6, 7));
        setSize(b.getDimensionX(), b.getDimensionY());
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setBoard(Board b) {
        this.b = b;
    }

    public void repaint() {
        super.validate();
        super.repaint();
        super.pack();
        super.setSize(b.getDimensionX(), b.getDimensionY());
    }

    public void actionPerformed(ActionEvent e) {
        PieceView btn = (PieceView) e.getSource();
        System.out.println("Button clicked! This button is " + btn.boardCoordinate);
    }
}
