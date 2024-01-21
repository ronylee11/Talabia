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
    }

    @Override
    public void checkPossibleMove() {
        plus.setBlock(false);
        String currentCoordinate = plus.getCoordinate();
        int currentRow = Integer.parseInt(currentCoordinate.substring(1));
        char currentCol = currentCoordinate.charAt(0);

        // Clear the possible moves list before recalculating
        plus.clearPossibleMovesList();

        // move left (-)
        checkMoveInLeft(currentCol, currentRow);
        plus.setBlock(false);

        // move right (+)
        checkMoveInRight(currentCol, currentRow);
        plus.setBlock(false);

        // move down (-)
        checkMoveInDown(currentCol, currentRow);
        plus.setBlock(false);

        // move up (+)
        checkMoveInUp(currentCol, currentRow);
    }

    private void checkMoveInLeft(char currentCol, int currentRow) {
        for (int left = 1; left < 7; left++) {
            char col = (char) (currentCol - left);
            String newCoordinate = col + Integer.toString(currentRow);
            if (isMoveValid(newCoordinate, pieces, plus)) {
                plus.addToPossibleMovesList(newCoordinate);
            }
            if (plus.isBlocking())
                left = 7;
        }
    }

    private void checkMoveInRight(char currentCol, int currentRow) {
        for (int right = 1; right < 7; right++) {
            char col = (char) (currentCol + right);
            String newCoordinate = col + Integer.toString(currentRow);
            if (isMoveValid(newCoordinate, pieces, plus)) {
                plus.addToPossibleMovesList(newCoordinate);
            }
            if (plus.isBlocking())
                right = 7;
        }
    }

    private void checkMoveInDown(char currentCol, int currentRow) {
        for (int down = 1; down < 6; down++) {
            String newCoordinate = currentCol + Integer.toString(currentRow-down);
            if (isMoveValid(newCoordinate, pieces, plus)) {
                plus.addToPossibleMovesList(newCoordinate);
            }
            if (plus.isBlocking())
                down = 6;
        }
    }

    private void checkMoveInUp(char currentCol, int currentRow) {
        for (int up = 1; up < 6; up++) {
            String newCoordinate = currentCol + Integer.toString(currentRow+up);
            if (isMoveValid(newCoordinate, pieces, plus)) {
                plus.addToPossibleMovesList(newCoordinate);
            }
            if (plus.isBlocking())
                up = 6;
        }
    }

}