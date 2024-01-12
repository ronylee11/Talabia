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
    // buttons = [
    // 'a6', 'b6', 'c6', 'd6', 'e6', 'f6', 'g6',
    // 'a5', 'b5', 'c5', 'd5', 'e5', 'f5', 'g5',
    // 'a4', 'b4', 'c4', 'd4', 'e4', 'f4', 'g4',
    // 'a3', 'b3', 'c3', 'd3', 'e3', 'f3', 'g3',
    // 'a2', 'b2', 'c2', 'd2', 'e2', 'f2', 'g2',
    // 'a1', 'b1', 'c1', 'd1', 'e1', 'f1', 'g1'
    // ]

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
