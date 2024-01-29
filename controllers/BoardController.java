package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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

    // Lee Rong Yi
    public BoardController(Board b, BoardView bv) {
        this.model = b;
        this.view = bv;
    }

    // Lee Rong Yi
    public void setBoardDimension(int dimensionX, int dimensionY) {
        model.setDimensionX(dimensionX);
        model.setDimensionY(dimensionY);
    }

    // Lee Rong Yi
    public void updateBoard() {
        view.repaint();
    }

    // Lee Rong Yi
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

    // Chia Zhi Xuan
    @Override
    public void actionPerformed(ActionEvent e) {
        PieceView btn = (PieceView) e.getSource();
        String coordinate = btn.getCoordinate();

        if (previousCoordinate != null) {
            if (isPieceMove(coordinate))
                coordinate = null;
        }
    
        handlePossibleMoveCheck(coordinate);

        setHintPiece();
        updateView();
    }

    // Chia Zhi Xuan, Lee Rong Yi
    private boolean isPieceMove(String coordinate) {
        piece = PieceCoordinate.getPieceCoordinate().getPiece(previousCoordinate);
        if (piece != null && piece.getPossibleMovesList().contains(coordinate)) {
            // if coordinate contains piece, print "piece captured"
            // if coordinate does not contain piece, print "piece moved"
            if (PieceCoordinate.getPieceCoordinate().getPiece(coordinate) != null) {
                // if captured piece is Sun, print "Game Over"
                if (PieceCoordinate.getPieceCoordinate().getPiece(coordinate).getName().equals("Sun")) {
                    System.out.println("Game Over!");
                    // close window and open new popup window saying "Congratulations! Player X wins!"
                    view.dispose();
                    new JOptionPane().showMessageDialog(null, "Congratulations! Player " + Game.getCurrentPlayer().getPlayerColor() + " wins!");
                    System.exit(0);
                }
                System.out.println("Piece captured!");
            }
            else {
                System.out.println("Piece moved!");
            }


            piece.movePiece(previousCoordinate, coordinate);
            Game.switchPlayer();
            model.flipBoard();
            return true;
        }
        return false;
    }

    // Chia Zhi Xuan
    private void handlePossibleMoveCheck(String coordinate) {
        piece = PieceCoordinate.getPieceCoordinate().getPiece(coordinate);
        if (piece != null)
            piece.checkPossibleMove();
        previousCoordinate = coordinate;
    }
    
    // Chia Zhi Xuan
    private void setHintPiece() {
        for (PieceView btn : buttons) {
            if (piece != null && piece.getPossibleMovesList().contains(btn.getCoordinate()))
                btn.setHint(true);
            else
                btn.setHint(false);
        }
    }

    // Chia Zhi Xuan
    public void updateView() {
        for (PieceView btn : buttons) {
            btn.resetIcon();
        }
    }

    // Lee Rong Yi
    public JPanel generateBoardNumbers(JPanel numbersPanel) {
        // generate text for numbers 1 to 7
        for (int i = 6 ; i >= 1 ; i--) {
            numbersPanel.add(new JLabel(Integer.toString(i)));
        }

        return numbersPanel;
    }

    // Lee Rong Yi
    public JPanel generateBoardLetters(JPanel lettersPanel) {
        // generate text for letters A to G
        for (int i = 0 ; i < 7 ; i++) {
            // add some padding to the left
            String text = "  " + Character.toString((char) (i + 65));
            lettersPanel.add(new JLabel(text));
        }

        return lettersPanel;
    }

    // Lee Rong Yi
    public JPanel generateRoundPanel(JPanel roundPanel) {
        // generate text for round number and which player turn
        roundPanel.add(new JLabel("Round: " + Game.getRound()));
        roundPanel.add(new JLabel("Player: " + Game.getPlayerTurn()));

        return roundPanel;
    }
}
