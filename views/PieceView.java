package views;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import models.*;
import models.Point;

@SuppressWarnings("serial")
public class PieceView extends JButton {
    static int pieceSpawned = 0; // max: 42 // assign coordinates on Board from a6~g6, a5~g5.. to 1~14, 29~42
    static private String[] pieceLocations = {"a1", "b1", "c1", "d1", "e1", "f1", "g1",
                                                "a2", "b2", "c2", "d2", "e2", "f2", "g2",
                                                "a5", "b5", "c5", "d5", "e5", "f5", "g5",
                                                "a6", "b6", "c6", "d6", "e6", "f6", "g6"};
    private String[] notationSequence = generateNotationSequence();
    private String boardCoordinate = "";
    
    Piece piece;
    Point[] point;
    Plus[] plus;
    Hourglass[] hourglass;
    Time[] time;
    Sun[] sun;

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
        //super(new ImageIcon("assets/arrow-y.png"));
        super();
        // add coordinate
        pieceSpawned++;
        boardCoordinate = notationSequence[pieceSpawned - 1];
        // generate respective piece on locations
        for (int i = 0; i < pieceLocations.length; i++) {
            if (boardCoordinate.equals(pieceLocations[i])) {
                if (boardCoordinate.charAt(1) == '2') {
                    Point point = new Point("assets/arrow-y", boardCoordinate);
                    this.setIcon(new ImageIcon("assets/arrow-y.png"));
                    break;
                } else if ((boardCoordinate.charAt(1) == '5')){
                    Point point = new Point("assets/arrow-b", boardCoordinate);
                    this.setIcon(new ImageIcon("assets/arrow-b.png"));
                    break;
                } else if ((boardCoordinate.charAt(1) == '1')){ // yellow pieces
                    // plus yellow
                    if (notationSequence[pieceSpawned - 1].equals ("a1") || notationSequence[pieceSpawned - 1].equals("g1")){
                        Plus plus = new Plus("assets/plus-y", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/plus-y.png"));
                        break;
                    // hourglass yellow
                    } else if (notationSequence[pieceSpawned - 1].equals ("b1") || notationSequence[pieceSpawned - 1].equals("f1")){
                        Hourglass hourglass = new Hourglass("assets/hourglass-y", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/hourglass-y.png"));
                        break;
                    // cross yellow
                    } else if (notationSequence[pieceSpawned - 1].equals ("c1") || notationSequence[pieceSpawned - 1].equals("e1")){
                        Time time = new Time("assets/cross-y", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/cross-y.png"));
                        break;
                    // sun yellow
                    } else {
                        Sun sun = new Sun("assets/sun-y", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/sun-y.png"));
                        break;
                    }
                } else if ((boardCoordinate.charAt(1) == '6')){ // blue pieces
                    // plus blue
                    if (notationSequence[pieceSpawned - 1].equals ("a6") || notationSequence[pieceSpawned - 1].equals("g6")){
                        Plus plus = new Plus("assets/plus-b", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/plus-b.png"));
                        break;
                    // hourglass blue
                    } else if (notationSequence[pieceSpawned - 1].equals ("b6") || notationSequence[pieceSpawned - 1].equals("f6")){
                        Hourglass hourglass = new Hourglass("assets/hourglass-b", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/hourglass-b.png"));
                        break;
                    // cross blue
                    } else if (notationSequence[pieceSpawned - 1].equals ("c6") || notationSequence[pieceSpawned - 1].equals("e6")){
                        Time time = new Time("assets/cross-b", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/cross-b.png"));
                        break;
                    // sun blue
                    } else {
                        Sun sun = new Sun("assets/sun-b", boardCoordinate);
                        this.setIcon(new ImageIcon("assets/sun-b.png"));
                        break;
                    }
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
