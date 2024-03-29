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

    // Lee Rong Yi
    public PieceController(Piece p, PieceView pv) {
        this.model = p;
        this.view = pv;
        pieceCoordinate = PieceCoordinate.getPieceCoordinate();
    }

    // Lee Rong Yi, Sally Khor Zhi Xuan
    public void generatePieces() {
        String[] notationSequence = view.getNotationSequence();
        int pieceSpawned = view.pieceSpawned();
        for (int i = 0; i < pieceLocations.length; i++) {
            if (view.getCoordinate().equals(pieceLocations[i])) {
                if (view.getCoordinate().charAt(1) == '2') {
                    Point point = new Point("assets/arrow-y.png", view.getCoordinate(), PieceColor.YELLOW);
                    point.setImageUrl2("assets/arrow-y2.png");
                    view.setIcon(new ImageIcon("assets/arrow-y.png"));
                    pieceCoordinate.placePiece(view.getCoordinate(), point);
                    break;
                } else if ((view.getCoordinate().charAt(1) == '5')){
                    Point point = new Point("assets/arrow-b.png", view.getCoordinate(), PieceColor.BLUE);
                    point.setImageUrl2("assets/arrow-b2.png");
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
}
