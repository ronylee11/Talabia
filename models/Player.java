package models;

public class Player {
    private int score;

    Player(int score) {
        this.score = score;
    }

    int getPlayerScore() {
        return score;
    }

    void setPlayerScore(int score) {
        this.score = score;
    }
}
