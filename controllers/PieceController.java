package controllers;

import javax.swing.ImageIcon;
import models.*;
import models.Piece;
import views.PieceView;

public class PieceController {
    private Piece model;
    private PieceView view;
    static private String[] pieceLocations = {"a1", "b1", "c1", "d1", "e1", "f1", "g1",
                                                "a2", "b2", "c2", "d2", "e2", "f2", "g2",
                                                "a5", "b5", "c5", "d5", "e5", "f5", "g5",
                                                "a6", "b6", "c6", "d6", "e6", "f6", "g6"};

    public PieceController(Piece p, PieceView pv) {
        this.model = p;
        this.view = pv;
    }

    public void generatePieces() {
        String[] notationSequence = view.getNotationSequence();
        int pieceSpawned = view.pieceSpawned();
        for (int i = 0; i < pieceLocations.length; i++) {
            if (view.getCoordinate().equals(pieceLocations[i])) {
                if (view.getCoordinate().charAt(1) == '2') {
                    Point point = new Point("assets/arrow-y", view.getCoordinate());
                    view.setIcon(new ImageIcon("assets/arrow-y.png"));
                    break;
                } else if ((view.getCoordinate().charAt(1) == '5')){
                    Point point = new Point("assets/arrow-b", view.getCoordinate());
                    view.setIcon(new ImageIcon("assets/arrow-b.png"));
                    break;
                } else if ((view.getCoordinate().charAt(1) == '1')){ // yellow pieces
                    // plus yellow
                    if (notationSequence[pieceSpawned - 1].equals ("a1") || notationSequence[pieceSpawned - 1].equals("g1")){
                        Plus plus = new Plus("assets/plus-y", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/plus-y.png"));
                        break;
                    // hourglass yellow
                    } else if (notationSequence[pieceSpawned - 1].equals ("b1") || notationSequence[pieceSpawned - 1].equals("f1")){
                        Hourglass hourglass = new Hourglass("assets/hourglass-y", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/hourglass-y.png"));
                        break;
                    // cross yellow
                    } else if (notationSequence[pieceSpawned - 1].equals ("c1") || notationSequence[pieceSpawned - 1].equals("e1")){
                        Time time = new Time("assets/cross-y", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/cross-y.png"));
                        break;
                    // sun yellow
                    } else {
                        Sun sun = new Sun("assets/sun-y", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/sun-y.png"));
                        break;
                    }
                } else if ((view.getCoordinate().charAt(1) == '6')){ // blue pieces
                    // plus blue
                    if (notationSequence[pieceSpawned - 1].equals ("a6") || notationSequence[pieceSpawned - 1].equals("g6")){
                        Plus plus = new Plus("assets/plus-b", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/plus-b.png"));
                        break;
                    // hourglass blue
                    } else if (notationSequence[pieceSpawned - 1].equals ("b6") || notationSequence[pieceSpawned - 1].equals("f6")){
                        Hourglass hourglass = new Hourglass("assets/hourglass-b", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/hourglass-b.png"));
                        break;
                    // cross blue
                    } else if (notationSequence[pieceSpawned - 1].equals ("c6") || notationSequence[pieceSpawned - 1].equals("e6")){
                        Time time = new Time("assets/cross-b", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/cross-b.png"));
                        break;
                    // sun blue
                    } else {
                        Sun sun = new Sun("assets/sun-b", view.getCoordinate());
                        view.setIcon(new ImageIcon("assets/sun-b.png"));
                        break;
                    }
                }
            }
        }
    }

    public void movePiece(int x, int y) {

    }

    public void switchMovingMethod() {

    }

    public boolean isMoveValid() {
        return false;
    }

}
