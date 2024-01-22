package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import models.Board;
import models.Game;
import models.Piece;
import models.PieceCoordinate;
import views.BoardView;
import views.PieceView;

public class BoardController implements ActionListener{
    private Board model;
    private BoardView view;
    private PieceView[] buttons = new PieceView[42];
    private String previousCoordinate;
    private Piece piece;

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
            button.addActionListener(this);
            p.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PieceView btn = (PieceView) e.getSource();
        String coordinate = btn.getCoordinate();
        System.out.println("Button clicked! This button is " + coordinate);

        if (previousCoordinate != null) {
            if (isPieceMove(coordinate))
                coordinate = null;
        }
    
        handlePossibleMoveCheck(coordinate);

        setHintPiece();
        updateView();
    }

    private boolean isPieceMove(String coordinate) {
        piece = PieceCoordinate.getPieceCoordinate().getPiece(previousCoordinate);
        if (piece != null && piece.getPossibleMovesList().contains(coordinate)) {
            piece.movePiece(previousCoordinate, coordinate);
            Game.switchPlayer();
            model.flipBoard();
            return true;
        }
        return false;
    }

    private void handlePossibleMoveCheck(String coordinate) {
        piece = PieceCoordinate.getPieceCoordinate().getPiece(coordinate);
        if (piece != null)
            piece.checkPossibleMove();
        previousCoordinate = coordinate;
    }
    
    private void setHintPiece() {
        for (PieceView btn : buttons) {
            if (piece != null && piece.getPossibleMovesList().contains(btn.getCoordinate()))
                btn.setHint(true);
            else
                btn.setHint(false);
        }
    }

    private void updateView() {
        for (PieceView btn : buttons) {
            btn.resetIcon();
        }
    }
}
