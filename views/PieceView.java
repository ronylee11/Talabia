package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.Piece;

@SuppressWarnings("serial")
public class PieceView extends JButton {
    static int pieceSpawned = 0; // max: 28
    static String[] pointLocations = {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "a5", "b5", "c5", "d5", "e5", "f5", "g5"};
    Piece piece;

    public PieceView() {
        super(new ImageIcon("assets/arrow-y.jpg"));
        // add image

        setPreferredSize(new Dimension(50, 50));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
