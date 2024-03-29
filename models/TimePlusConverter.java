package models;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//AU JI HIN
public class TimePlusConverter {

    private static boolean isTimeRound = false;
    private static Set<String> replacedCoordinates = new HashSet<>();

    public static void replaceTimeAndPlus() {
        replacedCoordinates.clear(); 
        replacePieces(PieceType.TIME, PieceType.PLUS);
        replacePieces(PieceType.PLUS, PieceType.TIME);
        isTimeRound = !isTimeRound;
    }

    private static void replacePieces(PieceType fromType, PieceType toType) {
        PieceCoordinate pieceCoordinate = PieceCoordinate.getPieceCoordinate();
        Map<String, Piece> coordinateMap = pieceCoordinate.getCoordinateMap();

        Set<String> keysCopy = new HashSet<>(coordinateMap.keySet());

        for (String coordinate : keysCopy) {
            Piece piece = coordinateMap.get(coordinate);

            if (!replacedCoordinates.contains(coordinate) &&
                    ((piece instanceof Time && fromType == PieceType.TIME) ||
                    (piece instanceof Plus && fromType == PieceType.PLUS))) {

                pieceCoordinate.removePiece(coordinate);
                Piece replacementPiece = createReplacementPiece(piece, toType, coordinate);
                pieceCoordinate.placePiece(coordinate, replacementPiece);

                replacedCoordinates.add(coordinate);
            }
        }
    }

    private static Piece createReplacementPiece(Piece originalPiece, PieceType replacementType, String coordinate) {
        if (replacementType == PieceType.PLUS) {
            return new Plus("assets/plus-" + originalPiece.getColor().getColorString() + ".png", coordinate,
                    originalPiece.getColor());
        } else {
            return new Time("assets/cross-" + originalPiece.getColor().getColorString() + ".png", coordinate,
                    originalPiece.getColor());
        }
    }
}
