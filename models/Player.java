package models;

public class Player {
    private int score;
    private PieceColor color;

    Player(PieceColor c) {
        this.score = 0;
        color = c;
    }

    public int getPlayerScore() {
        return score;
    }

    public void setPlayerScore(int score) {
        this.score = score;
    }

    public PieceColor getPlayerColor() {
        return color;
    }
}
