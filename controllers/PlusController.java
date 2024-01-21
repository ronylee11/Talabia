package controllers;

import models.Piece;
import models.PieceCoordinate;
import models.Plus;
import views.PieceView;

public class PlusController extends PieceController {
    private Plus plus;
    private PieceCoordinate pieces;

    public PlusController(Piece plus, PieceView view) {
        super(plus, view);
        this.plus = (Plus) plus;
        this.pieces = PieceCoordinate.getPieceCoordinate();
        checkPossibleMove();
    }

    @Override
    public void checkPossibleMove() {
        plus.setBlock(false);
        String currentCoordinate = plus.getCoordinate();
        int currentRow = Integer.parseInt(currentCoordinate.substring(1));
        char currentCol = currentCoordinate.charAt(0);

        // Clear the possible moves list before recalculating
        plus.clearPossibleMovesList();

        // Move horizontally
        for (char col = 'a'; col <= 'g'; col++) {
            if (col != currentCol) {
                String newCoordinate = col + Integer.toString(currentRow);
                if (isMoveValid(newCoordinate)) {
                    plus.addToPossibleMovesList(newCoordinate);
                }
            }
        }

        // Move vertically
        for (int row = 1; row <= 6; row++) {
            if (row != currentRow) {
                String newCoordinate = currentCol + Integer.toString(row);
                if (isMoveValid(newCoordinate)) {
                    plus.addToPossibleMovesList(newCoordinate);
                }
            }
        }
    }

    // Check if the move is valid (no piece at the target coordinate)
    private boolean isMoveValid(String targetCoordinate) {
        if (!pieces.isOccupied(targetCoordinate)) {
            return true;
        } else {
            plus.setBlock(true);
            Piece targetPiece = pieces.getPiece(targetCoordinate);
            return targetPiece.getColor() != plus.getColor();
        }
    }
}
