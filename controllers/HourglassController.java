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
            if (isMoveValid(targetCoordinate, pieces, hourglass)) {
                hourglass.addToPossibleMovesList(targetCoordinate);
            }
        }
    }

}
