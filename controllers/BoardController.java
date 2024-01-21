package controllers;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import models.Board;
import models.Piece;
import models.PieceCoordinate;
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
            button.setBorderPainted(true);
            button.addActionListener(view);
            p.add(button);
        }
    }

    //
    public void resetHint() {
        for (PieceView btn : buttons) {
            if (Piece.getPossibleMovesList().contains(btn.getCoordinate())) {
                btn.setBorder(new LineBorder(Color.GREEN, 6));
            }
            else {
                btn.setBorder(null);
            }
        }
    }

    // change icon after piece move
    public void addIcon(String previousCoordinate, String newCoordinate) {
        for (PieceView btn : buttons) {
            String btnCoordinate = btn.getCoordinate();
            if (previousCoordinate.equals(btnCoordinate)) {
                btn.setIcon(null);
            }
            else if (newCoordinate.equals(btnCoordinate)) {
                String url = PieceCoordinate.getPieceCoordinate().getPiece(newCoordinate).getImageUrl();
                btn.setIcon(new ImageIcon(url));
            }
        }
    }

    public void resetIcon() {
        PieceCoordinate pc = PieceCoordinate.getPieceCoordinate();
        for (PieceView btn : buttons) {
            String btnCoordinate = btn.getCoordinate();
            if (pc.isOccupied(btnCoordinate)) {
                String url = pc.getPiece(btnCoordinate).getImageUrl();
                btn.setIcon(new ImageIcon(url));
            }
            else
                btn.setIcon(null);
        }
    }

    public void flipBoard() {
        PieceCoordinate pc = PieceCoordinate.getPieceCoordinate();
        pc.changeCoordinate();
        for (PieceView btn : buttons) {
            String btnCoordinate = btn.getCoordinate();
            if (pc.isOccupied(btnCoordinate)) {
                Piece piece = pc.getPiece(btnCoordinate);
                piece.switchUrl();    
                String url = piece.getImageUrl();
                btn.setIcon(new ImageIcon(url));
            }
            else
                btn.setIcon(null);
        }
    }
    
}
