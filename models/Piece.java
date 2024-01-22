package models;

import java.util.HashSet;
import java.util.Set;

import controllers.PieceController;
import views.PieceView;

public abstract class Piece {
    private String imageUrl;
    private String coordinate;
    private PieceColor color;
    private Set<String> possibleMoves;
    private PieceCoordinate pieces;
    private boolean block = false;

    public Piece(String imageUrl, String coordinate, PieceColor color) {
        this.imageUrl = imageUrl;
        this.coordinate = coordinate;
        this.color = color;
        this.pieces = PieceCoordinate.getPieceCoordinate();
        possibleMoves = new HashSet<>();
    }

    public PieceController createController(Piece piece, PieceView view) {
        return new PieceController(piece, view);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isBlocking() {
        return block;
    }

    public void setBlock(Boolean b) {
        block = b;
    }

    public Set<String> getPossibleMovesList() {
        return possibleMoves;
    }

    public void clearPossibleList () {
        possibleMoves.clear();
    }

    public void addToPossibleMovesList(String coordinate) {
        possibleMoves.add(coordinate);
    }

    public void clearPossibleMovesList() {
        possibleMoves.clear();
    }

    public void switchUrl(){};

    public void movePiece(String currentCoordinate, String newCoordinate) {
        PieceCoordinate pc = PieceCoordinate.getPieceCoordinate();
        Piece piece = pc.getPiece(currentCoordinate);
        pc.removePiece(currentCoordinate);
        if (pc.getPiece(newCoordinate) != null) {
            pc.removePiece(newCoordinate);
        }
        piece.setCoordinate(newCoordinate);
        pc.placePiece(newCoordinate, piece);
    }

    public boolean isMoveValid(String targetCoordinate, Piece piece) {
        // check if the piece color same with the player color
        if (piece.getColor().equals(Game.getCurrentColor())) {
            // check if on the board
            if (targetCoordinate.charAt(1) >= '1' && targetCoordinate.charAt(1) <= '6'
                && targetCoordinate.charAt(0) >= 'a' && targetCoordinate.charAt(0) <= 'g') {
                // check is there any obstacles
                if (pieces.isOccupied(targetCoordinate)) {
                    piece.setBlock(true);
                    // check if having different color
                    if (!piece.getColor().equals(pieces.getPiece(targetCoordinate).getColor()))
                        return true;
                }
                else
                    return true;
            }
        }
        return false;
    }

    public void checkPossibleMove() {};
    
}
