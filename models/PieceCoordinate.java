package models;

import java.util.HashMap;
import java.util.Map;

public class PieceCoordinate {
    // private char column;    // a to g
    // private int row;        // 1 to 6
    public static PieceCoordinate pieceCoordinate;
    private Map<String, Piece> pieceCoordinateMap;

    private PieceCoordinate () {
        pieceCoordinateMap = new HashMap<>();
    }

    public static PieceCoordinate getPieceCoordinate() {
        if (pieceCoordinate == null)
            pieceCoordinate = new PieceCoordinate();
        return pieceCoordinate;
    }

    public void placePiece(String coordinate, Piece piece) {
        pieceCoordinateMap.put(coordinate, piece);
    }

    // check whether the coordinate is being occupied by pieces
    public boolean isOccupied(String coordinate) {
        return pieceCoordinateMap.containsKey(coordinate);
    }

    public Piece getPiece(String coordinate) {
        return pieceCoordinateMap.get(coordinate);
    }

    public void setPiece() {
        
    }

    // public void setPiece(Piece piece) {
    //     this.piece = piece;
    // }

}
