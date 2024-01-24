package models;

import views.BoardView;

public class Game {
    private static Player[] players;
    private static Player currentPlayer;
    private static int currentPlayerIndex = 0;
    
    public Game() {
        players = new Player[2];
        createPlayer();
        currentPlayerIndex = 0;
        currentPlayer = players[currentPlayerIndex];
        new BoardView(new Board(500, 500));
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static PieceColor getCurrentColor() {
        return currentPlayer.getPlayerColor();
    }

    private void createPlayer() {
        players[0] = new Player(PieceColor.YELLOW);
        players[1] = new Player(PieceColor.BLUE);
    }

    public static void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length; // 0 - 1,  1 - 0
        currentPlayer = players[currentPlayerIndex];

        RoundCount.RoundCountCalculate();
    }


}
