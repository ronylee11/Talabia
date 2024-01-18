package controllers;

import java.awt.*;
import javax.swing.*;
import models.Board;
import models.Piece;
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

    // 
    public void addHint() {
        for (PieceView btn : buttons) {
            if (Piece.getPossibleMovesList().contains(btn.getCoordinate())) {
                btn.setIcon(new ImageIcon("assets/hint.png"));
            }
        }
    }

    // remove hint
    public void resetIcon() {
        for (PieceView btn : buttons) {
            if (Piece.getPossibleMovesList().contains(btn.getCoordinate())) {
                btn.setIcon(null);
            }
        }
    }

    
}
