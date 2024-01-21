package models;

import controllers.PieceController;
import controllers.PointController;
import views.PieceView;

public class Point extends Piece {
    private boolean forward = true;
    private String imageUrl2; // in opposite direction
    private boolean switchDone = false;

    public Point(String imageUrl, String coordinate, PieceColor color) {
        super(imageUrl, coordinate, color);
    }

    @Override
    public PieceController createController(Piece piece, PieceView view) {
        return new PointController(piece, view);
    }

    public boolean isForward() {
        return forward;
    }

    public void setToForward() {
        forward = true;
    }

    public void setToBackward() {
        forward = false;
    }

    public void setImageUrl2(String url) {
        imageUrl2 = url;
    }

    public boolean isSwitchDone() {
        return switchDone;
    }

    public void setSwitchDone(boolean b) {
        switchDone = b;
    }

    @Override
    public void switchUrl() {
        String temp = getImageUrl();
        setImageUrl(imageUrl2);
        imageUrl2 = temp;
    }
}
