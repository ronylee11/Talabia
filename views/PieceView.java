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
    private static final int MAX_PIECE_SPAWNED = 42;
    static private int pieceSpawned = 0; // max: 42 // assign coordinates on Board from a6~g6, a5~g5.. to 1~14, 29~42
    private String[] notationSequence = generateNotationSequence();
    private String boardCoordinate = "";

    PieceController controller;
    Piece model;

    // Lee Rong Yi
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

    // Lee Rong Yi
    public PieceView() {
        // add image
        //super(new ImageIcon("assets/arrow-y.png"));
        super();
        // add coordinate
        pieceSpawned++;
        if (pieceSpawned <= MAX_PIECE_SPAWNED) {
            boardCoordinate = notationSequence[pieceSpawned - 1];
            controller = new PieceController(model, this);
            controller.generatePieces();
        } else {
            // Handle the case where pieceSpawned exceeds the maximum
            // For example, you might want to reset it to 1 or handle it differently.
            pieceSpawned = 1;
        }
        
        boardCoordinate = notationSequence[pieceSpawned - 1];
        // connect PieceController
        controller = new PieceController(model, this);
        // generate respective piece on locations
        controller.generatePieces();

        setPreferredSize(new Dimension(50, 50));
        setOpaque(true);
        setBorderPainted(true);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    // Lee Rong Yi
    public String getCoordinate() {
        return boardCoordinate;
    }

    // Lee Rong Yi
    public String[] getNotationSequence() {
        return notationSequence;
    }

    // Lee Rong Yi
    public int pieceSpawned() {
        return pieceSpawned;
    }

    // Chia Zhi Xuan
    // reset hint border
    public void setHint(boolean hint) {
        if (hint)
            setBorder(new LineBorder(Color.GREEN, 6));
        else
            setBorder(null);
    }

    // Chia Zhi Xuan
    // update icon on the button
    public void resetIcon() {
        Piece piece = PieceCoordinate.getPieceCoordinate().getPiece(boardCoordinate);
        if (piece != null)
            setIcon(new ImageIcon(piece.getImageUrl()));
        else
            setIcon(null);
    }

    
}
