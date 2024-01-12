package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import models.Piece;
import models.Point;

@SuppressWarnings("serial")
public class PieceView extends JButton {
    static int pieceSpawned = 0; // max: 42 // assign coordinates on Board from a6~g6, a5~g5.. to 1~14, 29~42
    static private String[] pointLocations = {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "a5", "b5", "c5", "d5", "e5", "f5", "g5"};
    private String[] notationSequence = generateNotationSequence();
    private String boardCoordinate = "";
    Piece piece;
    Point[] point;


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
        // generate respective piece on locations
        for (int i = 0; i < pointLocations.length; i++) {
            if (boardCoordinate.equals(pointLocations[i])) {
                if (boardCoordinate.charAt(1) == '2') {
                    Point point = new Point("assets/arrow-y", boardCoordinate);
                    this.setIcon(new ImageIcon("assets/arrow-y.jpg"));
                    break;
                } else {
                    Point point = new Point("assets/arrow-b", boardCoordinate);
                    this.setIcon(new ImageIcon("assets/arrow-b.jpg"));
                    break;
                }
            }
        }

        setPreferredSize(new Dimension(50, 50));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    public String getCoordinate() {
        return boardCoordinate;
    }
}
