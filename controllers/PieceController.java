package controllers;

import javax.swing.*;
import models.*;
import views.PieceView;

public class PieceController {
    private Piece model;
    private PieceView view;
    private PieceCoordinate pieceCoordinate;
    static private String[] pieceLocations = {"a1", "b1", "c1", "d1", "e1", "f1", "g1",
                                                "a2", "b2", "c2", "d2", "e2", "f2", "g2",
                                                "a5", "b5", "c5", "d5", "e5", "f5", "g5",
                                                "a6", "b6", "c6", "d6", "e6", "f6", "g6"};

    public PieceController(Piece p, PieceView pv) {
        this.model = p;
        this.view = pv;
        pieceCoordinate = PieceCoordinate.getPieceCoordinate();
    }

    public void generatePieces() {
        String[] notationSequence = view.getNotationSequence();
        int pieceSpawned = view.pieceSpawned();
        for (int i = 0; i < pieceLocations.length; i++) {
            if (view.getCoordinate().equals(pieceLocations[i])) {
                if (view.getCoordinate().charAt(1) == '2') {
                    Point point = new Point("assets/arrow-y.png", view.getCoordinate(), PieceColor.YELLOW);
                    view.setIcon(new ImageIcon("assets/arrow-y.png"));
                    pieceCoordinate.placePiece(view.getCoordinate(), point);
                    break;
                } else if ((view.getCoordinate().charAt(1) == '5')){
                    Point point = new Point("assets/arrow-b.png", view.getCoordinate(), PieceColor.BLUE);
                    view.setIcon(new ImageIcon("assets/arrow-b.png"));
                    pieceCoordinate.placePiece(view.getCoordinate(), point);
                    break;
                } else if ((view.getCoordinate().charAt(1) == '1')){ // yellow pieces
                    // plus yellow
                    if (notationSequence[pieceSpawned - 1].equals ("a1") || notationSequence[pieceSpawned - 1].equals("g1")){
                        Plus plus = new Plus("assets/plus-y.png", view.getCoordinate(), PieceColor.YELLOW);
                        view.setIcon(new ImageIcon("assets/plus-y.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), plus);
                        break;
                    // hourglass yellow
                    } else if (notationSequence[pieceSpawned - 1].equals ("b1") || notationSequence[pieceSpawned - 1].equals("f1")){
                        Hourglass hourglass = new Hourglass("assets/hourglass-y.png", view.getCoordinate(), PieceColor.YELLOW);
                        view.setIcon(new ImageIcon("assets/hourglass-y.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), hourglass);
                        break;
                    // cross yellow
                    } else if (notationSequence[pieceSpawned - 1].equals ("c1") || notationSequence[pieceSpawned - 1].equals("e1")){
                        Time time = new Time("assets/cross-y.png", view.getCoordinate(), PieceColor.YELLOW);
                        view.setIcon(new ImageIcon("assets/cross-y.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), time);
                        break;
                    // sun yellow
                    } else {
                        Sun sun = new Sun("assets/sun-y.png", view.getCoordinate(), PieceColor.YELLOW);
                        view.setIcon(new ImageIcon("assets/sun-y.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), sun);
                        break;
                    }
                } else if ((view.getCoordinate().charAt(1) == '6')){ // blue pieces
                    // plus blue
                    if (notationSequence[pieceSpawned - 1].equals ("a6") || notationSequence[pieceSpawned - 1].equals("g6")){
                        Plus plus = new Plus("assets/plus-b.png", view.getCoordinate(), PieceColor.BLUE);
                        view.setIcon(new ImageIcon("assets/plus-b.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), plus);
                        break;
                    // hourglass blue
                    } else if (notationSequence[pieceSpawned - 1].equals ("b6") || notationSequence[pieceSpawned - 1].equals("f6")){
                        Hourglass hourglass = new Hourglass("assets/hourglass-b.png", view.getCoordinate(), PieceColor.BLUE);
                        view.setIcon(new ImageIcon("assets/hourglass-b.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), hourglass);
                        break;
                    // cross blue
                    } else if (notationSequence[pieceSpawned - 1].equals ("c6") || notationSequence[pieceSpawned - 1].equals("e6")){
                        Time time = new Time("assets/cross-b.png", view.getCoordinate(), PieceColor.BLUE);
                        view.setIcon(new ImageIcon("assets/cross-b.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), time);
                        break;
                    // sun blue
                    } else {
                        Sun sun = new Sun("assets/sun-b.png", view.getCoordinate(), PieceColor.BLUE);
                        view.setIcon(new ImageIcon("assets/sun-b.png"));
                        pieceCoordinate.placePiece(view.getCoordinate(), sun);
                        break;
                    }
                }
            }
        }
    }

    public void setNotations(String boardCoordinate) {
        // if boardCoordinate.charAt(1) == '1', set the columns, a~g
        // if boardCoordinate.charAt(0) == 'a', set the row, 1~6
        // if boardCoordinate == 'a1', setText to 'a1'
        if (boardCoordinate.equals("a1")) {
            view.setText(boardCoordinate);
        } else if (boardCoordinate.charAt(1) == '1') {
            view.setText("" + boardCoordinate.charAt(0));
        } else if (boardCoordinate.charAt(0) == 'a') {
            view.setText("" + boardCoordinate.charAt(1));
        }  
        view.setVerticalTextPosition(JButton.BOTTOM);
        view.setHorizontalTextPosition(JButton.CENTER);
    }

    public void movePiece(String currentCoordinate, String newCoordinate) {
        Piece piece = PieceCoordinate.getPieceCoordinate().getPiece(currentCoordinate);
        PieceCoordinate.getPieceCoordinate().removePiece(currentCoordinate);
        if (PieceCoordinate.getPieceCoordinate().getPiece(newCoordinate) != null) {
            PieceCoordinate.getPieceCoordinate().removePiece(newCoordinate);
        }
        piece.setCoordinate(newCoordinate);
        PieceCoordinate.getPieceCoordinate().placePiece(newCoordinate, piece);
    }

    public void switchMovingMethod() {

    }

    public boolean isMoveValid() {
        return false;
    }

    public boolean isMoveValid(String targetCoordinate, PieceCoordinate piecesCoordinate, Piece piece) {
        // check if on the board
        if (targetCoordinate.charAt(1) >= '1' && targetCoordinate.charAt(1) <= '6'
            && targetCoordinate.charAt(0) >= 'a' && targetCoordinate.charAt(0) <= 'g') {
            // check is there any obstacles
            if (piecesCoordinate.isOccupied(targetCoordinate)) {
                // check if having different color
                if (!piece.getColor().equals(piecesCoordinate.getPiece(targetCoordinate).getColor()))
                    return true;
            }
            else
                return true;
        }
        return false;
    }

    public void checkPossibleMove() {};

}
