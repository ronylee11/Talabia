package controllers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import models.Board;
import views.BoardView;
import views.PieceView;

public class BoardController {
    private Board model;
    private BoardView view;
    private PieceView[] buttons = new PieceView[42];

    public BoardController(Board b, BoardView bv) {
        this.model = b;
        this.view = bv;
    }

    public void setBoardDimension(int dimensionX, int dimensionY) {
        model.setDimensionX(dimensionX);
        model.setDimensionY(dimensionY);
    }

    public void updateBoard() {
        view.repaint();
    }

    public void generateBoardNotations(JPanel p) {
        for (int i = 0; i < 42; i++) {
            PieceView button = new PieceView();
            buttons[i] = button;
            if (i % 2 == 0)
                button.setBackground(Color.WHITE);
            else
                button.setBackground(Color.BLACK);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.addActionListener(view);
            p.add(button);
        }
    }
}
