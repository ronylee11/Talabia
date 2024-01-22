package models;

import java.util.HashMap;
import java.util.Map;

public class PieceCoordinate {
    // private char column;    // a to g
    // private int row;        // 1 to 6
    private static PieceCoordinate pieceCoordinate;
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

    public void removePiece(String coordinate) {
        pieceCoordinateMap.remove(coordinate);
    }

    public Map<String, Piece> getCoordinateMap() {
        return pieceCoordinateMap;
    }

    // change while flippping board
    public void changeCoordinate() {
        Map<String, Piece> tempMap = new HashMap<>();

        // change coordinate, put in temp map
        pieceCoordinateMap.forEach((key, value) -> {
            String newKey = CoordinateConverter.convertCoordinate(key);
            value.setCoordinate(newKey);
            tempMap.put(newKey, value);
        });

        pieceCoordinateMap.clear();
        pieceCoordinateMap.putAll(tempMap);
    }

}
