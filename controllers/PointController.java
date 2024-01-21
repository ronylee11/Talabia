package controllers;

import models.Game;
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
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        point.clearPossibleMovesList();
        point.setBlock(false); 
        String currentCoordinate = point.getCoordinate();

        checkReachEnd(currentCoordinate);

        String targetCoordinate;
        for (int i = 1; i < 3; i++) {
            char char1 = currentCoordinate.charAt(0);
            int char2 = Character.getNumericValue(currentCoordinate.charAt(1));
            if (point.isForward()) {
                targetCoordinate = "" + char1 + (char2 + i);
            }
            else {
                targetCoordinate = "" + char1 + (char2 - i);
            }

            if (isMoveValid(targetCoordinate, pieces, point)) {
                point.addToPossibleMovesList(targetCoordinate);
            }
            
            // stop when have obstacles
            if (point.isBlocking())
                i = 3;
        }
    }

    // change direction when reach end
    private void checkReachEnd(String coordinate) {
        if (Game.getCurrentColor().equals(point.getColor())) {
            if (!point.isSwitchDone()) {
                if (coordinate.charAt(1) == '6' || coordinate.charAt(1) == '1') {
                    point.setToBackward();
                    point.switchUrl();
                    point.setSwitchDone(true);
                    if (coordinate.charAt(1) == '6')
                        point.setToBackward();
                    else
                        point.setToForward();
                } 
                else {
                    point.setSwitchDone(false);
                }
                
            }
        }
    }

}