package controllers;

import models.Piece;
import models.PieceCoordinate;
import views.PieceView;

public class HourglassController extends PieceController{
    private Piece hourglass;
    private PieceCoordinate pieces;

    public HourglassController (Piece hourglass, PieceView view) {
        super(hourglass, view);
        this.hourglass = hourglass;
        this.pieces = PieceCoordinate.getPieceCoordinate();

        checkPossibleMove();
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        hourglass.clearPossibleMovesList();
        String currentCoordinate = hourglass.getCoordinate();

        int[] columns = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] rows = {2, -2, 2, -2, 1, -1, 1, -1};

        String targetCoordinate;
        for (int i = 0; i < columns.length; i++) {
            char newColumn = (char) (currentCoordinate.charAt(0) + columns[i]);
            int newRow = (Character.getNumericValue(currentCoordinate.charAt(1)) + rows[i]);
            targetCoordinate = "" + newColumn + newRow;
            if (isMoveValid(targetCoordinate)) {
                hourglass.addToPossibleMovesList(targetCoordinate);
            }
        }
    }

    private boolean isMoveValid(String targetCoordinate) {
        // check if on the board
        if (targetCoordinate.charAt(1) >= '1' && targetCoordinate.charAt(1) <= '6'
            && targetCoordinate.charAt(0) >= 'a' && targetCoordinate.charAt(0) <= 'g') {
            // check is there any obstacles
            if (pieces.isOccupied(targetCoordinate)) {
                // check if having different color
                if (!hourglass.getColor().equals(pieces.getPiece(targetCoordinate).getColor()))
                    return true;
            }
            else
                return true;
        }
        return false;
    }

}
