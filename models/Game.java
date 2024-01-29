package models;

import views.BoardView;

public class Game {
    private static Player[] players;
    private static Player currentPlayer;
    private static int currentPlayerIndex = 0;
    private static int roundCount = 0; // calculate number of round (each player play 1 time, round + 1)
    private static int playCount = 0; // calculate number of time ( one player play 1 time, time + 1)

    private static BoardView boardView;

    public Game() {
        players = new Player[2];
        createPlayer();
        setCurrentPlayer(0);    // set index to 0, first player
        // Create a single instance of BoardView
        boardView = new BoardView(new Board(500, 500));
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(int index) {
        currentPlayer = players[index];
        currentPlayerIndex = index;
    }

    public static int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public static PieceColor getCurrentColor() {
        return currentPlayer.getPlayerColor();
    }

    private void createPlayer() {
        players[0] = new Player(PieceColor.YELLOW);
        players[1] = new Player(PieceColor.BLUE);
    }

    public static int getRound() {
        return roundCount + 1;
    }

    public static int getPlayerTurn() {
        return currentPlayerIndex + 1;
    }

    public static int getRoundCount() {
        return roundCount;
    }

    public static void setRoundCount(int count) {
        roundCount = count;
    }

    public static int getPlayCount() {
        return playCount;
    }

    public static void setPlayCount(int count) {
        playCount = count;
    }

    public static void printCurrentRound() {
        System.out.println("Total play count: " + playCount);
        System.out.println("Current round: " + (roundCount + 1));
    }

    public static void printCurrentPlayerTurn() {
        System.out.println("Current player's turn: " + Game.getCurrentPlayer().getPlayerColor());
    }

    public static void RoundCountCalculate() {
        if (playCount % 2 == 0) { // if both players have played
            roundCount++; // 1 round has completed
        }
        if (roundCount % 2 == 0) { // every 2 rounds,
            TimePlusConverter.replaceTimeAndPlus(); // Replace Time and Plus every two rounds
        }
    }

    public static void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length; // 0 - 1,  1 - 0
        setCurrentPlayer(currentPlayerIndex);

        playCount++;

        RoundCountCalculate();
        printCurrentRound();
        printCurrentPlayerTurn();

        // Update labels using the single instance of BoardView
        boardView.updateRoundAndPlayerLabels();
    }
}
