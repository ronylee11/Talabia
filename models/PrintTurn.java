package models;

public class PrintTurn {
    public static void printCurrentPlayerTurn() {
        System.out.println("Current player's turn: " + Game.getCurrentPlayer().getPlayerColor());
    }
}
