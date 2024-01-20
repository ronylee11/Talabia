package controllers;

import models.Piece;
import models.PieceCoordinate;
import views.PieceView;

public class SunController extends PieceController{
    private Piece sun;
    private PieceCoordinate pieces;

    public SunController (Piece sun, PieceView view) {
        super(sun, view);
        this.sun = sun;
        this.pieces = PieceCoordinate.getPieceCoordinate();

        checkPossibleMove();
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        sun.clearPossibleMovesList();
        String currentCoordinate = sun.getCoordinate();

        int[] columns = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] rows = {1, 1, 0, -1, -1, -1, 0, 1};

        String targetCoordinate;
        for (int i = 0; i < columns.length; i++) {
            char newColumn = (char) (currentCoordinate.charAt(0) + columns[i]);
            int newRow = (Character.getNumericValue(currentCoordinate.charAt(1)) + rows[i]);
            targetCoordinate = "" + newColumn + newRow;
            if (isMoveValid(targetCoordinate, pieces, sun)) {
                sun.addToPossibleMovesList(targetCoordinate);
            }
        }
    }

    
}
