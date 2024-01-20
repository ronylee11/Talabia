package controllers;

import models.Piece;
import models.PieceCoordinate;
import models.Plus;
import views.BoardView;
import views.PieceView;

public class PlusController extends PieceController {
    private Plus plus;
    private PieceCoordinate pieces;
    private BoardView boardView;  // Reference to the BoardView

    public PlusController(Piece plus, PieceView view, BoardView boardView) {
        super(plus, view);
        this.plus = (Plus) plus;
        this.pieces = PieceCoordinate.getPieceCoordinate();
        this.boardView = boardView;  // Initialize the reference to the BoardView

        checkPossibleMove();
    }

    @Override
    public void checkPossibleMove() {
        String currentCoordinate = plus.getCoordinate();
        int currentRow = currentCoordinate.charAt(0) - 'A';
        int currentCol = Integer.parseInt(currentCoordinate.substring(1));

        // Clear the possible moves list before recalculating
        plus.clearPossibleMovesList();

        // Move horizontally
        for (int col = 1; col <= 7; col++) {
            if (col != currentCol) {
                plus.addToPossibleMovesList((char) ('A' + currentRow) + Integer.toString(col));
            }
        }

        // Move vertically
        for (char row = 'A'; row <= 'F'; row++) {
            if (row != currentCoordinate.charAt(0)) {
                plus.addToPossibleMovesList(row + Integer.toString(currentCol));
            }
        }
    }
}

