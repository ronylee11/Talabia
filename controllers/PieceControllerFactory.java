package controllers;

import models.*;
import models.PieceCoordinate;
import views.PieceView;

public class PieceControllerFactory {

    public static Piece getPiece (String coordinate) {
        return PieceCoordinate.getPieceCoordinate().getPiece(coordinate);
    }

    public static PieceController getController(String coordinate, PieceView view) {
        Piece piece = getPiece(coordinate);
        if (piece instanceof Point)
            return new PointController(piece, view);
        else if (piece instanceof Hourglass)
            return new HourglassController(piece, view);
        else if (piece instanceof Sun)
            return new SunController(piece, view);
        
        return null;
    }
}
