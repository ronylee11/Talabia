package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import models.Piece;

@SuppressWarnings("serial")
public class PieceView extends JButton {
    static int pieceSpawned = 0; // max: 42 // assign coordinates on Board from a6~g6, a5~g5.. to 1~14, 29~42
    static String[] pointLocations = {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "a5", "b5", "c5", "d5", "e5", "f5", "g5"};
    String[] notationSequence = generateNotationSequence();
    String boardCoordinate = "";
    Piece piece;

    String[] generateNotationSequence() {
        ArrayList<String> notationSequence = new ArrayList<String>();
        for (int row = 6; row >= 1; row--) {
            for (int col = 'a'; col <= 'g'; col++) {
                notationSequence.add("" + (char) col + row);
            }
        }
        return notationSequence.toArray(new String[notationSequence.size()]);
    }

    public PieceView() {
        // add image
        //super(new ImageIcon("assets/arrow-y.jpg"));
        super();
        // add coordinate
        pieceSpawned++;
        boardCoordinate = notationSequence[pieceSpawned - 1];

        setPreferredSize(new Dimension(50, 50));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
