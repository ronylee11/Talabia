package controllers;

import models.Piece;
import views.PieceView;
import models.PieceCoordinate;
import models.Point;

public class PointController extends PieceController{
    private Point point;
    private PieceCoordinate pieces;
    
    public PointController (Piece point, PieceView view) {
        super(point, view);
        this.point = (Point) point;
        this.pieces = PieceCoordinate.getPieceCoordinate();
        
        checkPossibleMove();
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        point.clearPossibleMovesList();
        String currentCoordinate = point.getCoordinate();
        if (currentCoordinate.charAt(1) == '6') 
            point.setToBackward();
        else if (currentCoordinate.charAt(0) == '0') 
            point.setToForward();

        String targetCoordinate;
        for (int i = 1; i < 3; i++) {
            if (point.isForward()) {
                targetCoordinate = "" + currentCoordinate.charAt(0) + (Character.getNumericValue(currentCoordinate.charAt(1))+i);
            }
            else {
                targetCoordinate = "" + currentCoordinate.charAt(0) + (Character.getNumericValue(currentCoordinate.charAt(1))-i);
            }
            if (isMoveValid(targetCoordinate, pieces, point)) {
                point.addToPossibleMovesList(targetCoordinate);
            }
        }
    }

}