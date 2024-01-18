package controllers;

import models.Piece;
import views.PieceView;
import models.PieceCoordinate;

public class PointController extends PieceController{
    private Piece point;
    private PieceCoordinate pieces;
    
    public PointController (Piece point, PieceView view) {
        super(point, view);
        this.point = point;
        this.pieces = PieceCoordinate.getPieceCoordinate();
        
        checkPossibleMove();
    }

    // check all the possible move
    @Override
    public void checkPossibleMove() {
        point.clearPossibleMovesList();
        String currentCoordinate = point.getCoordinate();
        String targetCoordinate;
        for (int i = 1; i < 3; i++) {
            targetCoordinate = "" + currentCoordinate.charAt(0) + (Character.getNumericValue(currentCoordinate.charAt(1))+i);
            if (checkValidMove(targetCoordinate)) {
                point.addToPossibleMovesList(targetCoordinate);
            }
        }
    }

    @Override
    public void getPossibleMove() {
        checkPossibleMove();
        System.out.println("Possible move : ");
        for (String mv : point.getPossibleMovesList()) {
            System.out.println(mv);
        }
        System.out.println();
    }


    public boolean checkValidMove(String targetCoordinate) {
        // check if on the board
        if (targetCoordinate.charAt(1) >= '1' && targetCoordinate.charAt(1) <= '6') {
            // check is there any obstacles
            if (pieces.isOccupied(targetCoordinate)) {
                // check if having different color
                if (!point.getColor().equals(pieces.getPiece(targetCoordinate).getColor()))
                    return true;
            }
            else
                return true;
        }
        return false;
    }

    public void movePiece(String targetCoordinate) {
        // String coordinate = point.getCoordinate();
    }

}