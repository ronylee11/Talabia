package controllers;

import models.*;
import models.PieceCoordinate;
import views.PieceView;

public class PieceControllerFactory {

    private static Piece getPiece (String coordinate) {
        return PieceCoordinate.getPieceCoordinate().getPiece(coordinate);
    }

    // create controller based on the pieces
    public static PieceController getController(String coordinate, PieceView view) {
        Piece piece = getPiece(coordinate);
        if (piece != null)
            return piece.createController(piece, view);
        
        return null;
    }
}
