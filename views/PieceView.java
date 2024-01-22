package views;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import models.*;
import controllers.PieceController;

@SuppressWarnings("serial")
public class PieceView extends JButton {
    static private int pieceSpawned = 0; // max: 42 // assign coordinates on Board from a6~g6, a5~g5.. to 1~14, 29~42
    private String[] notationSequence = generateNotationSequence();
    private String boardCoordinate = "";

    PieceController controller;
    Piece model;

    // generate board coordinates from a6~g6, a5~g5.. to 1~14, 29~42
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
        // connect PieceController
        controller = new PieceController(model, this);
        // set text
        // controller.setNotations(boardCoordinate);
        // generate respective piece on locations
        controller.generatePieces();

        setPreferredSize(new Dimension(50, 50));
        setOpaque(true);
        setBorderPainted(true);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    public String getCoordinate() {
        return boardCoordinate;
    }

    public String[] getNotationSequence() {
        return notationSequence;
    }

    public int pieceSpawned() {
        return pieceSpawned;
    }

    // reset hint border
    public void setHint(boolean hint) {
        if (hint)
            setBorder(new LineBorder(Color.GREEN, 6));
        else
            setBorder(null);
    }

    // update icon on the button
    public void resetIcon() {
        Piece piece = PieceCoordinate.getPieceCoordinate().getPiece(boardCoordinate);
        if (piece != null)
            setIcon(new ImageIcon(piece.getImageUrl()));
        else
            setIcon(null);
    }

    
}
