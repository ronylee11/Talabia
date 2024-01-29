package models;

public class Player {
    private PieceColor color;

    Player(PieceColor c) {
        color = c;
    }

    public PieceColor getPlayerColor() {
        return color;
    }
}
