package models;

import java.util.HashSet;
import java.util.Set;

import controllers.PieceController;
import views.PieceView;

public abstract class Piece {
    private String imageUrl;
    private String coordinate;
    private PieceColor color;
    private static Set<String> possibleMoves;
    private boolean block = false;

    public Piece(String imageUrl, String coordinate, PieceColor color) {
        this.imageUrl = imageUrl;
        this.coordinate = coordinate;
        this.color = color;
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

    public static Set<String> getPossibleMovesList() {
        return possibleMoves;
    }

    public static void clearPossibleList () {
        possibleMoves.clear();
    }

    public void addToPossibleMovesList(String coordinate) {
        possibleMoves.add(coordinate);
    }

    public void clearPossibleMovesList() {
        possibleMoves.clear();
    }

    public void switchUrl(){};

    
}
