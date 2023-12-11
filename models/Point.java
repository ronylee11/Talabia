package models;

public class Point extends Piece {
    private String imageUrl;
    private int step;

    public Point(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getStep() {
        return step;
    }

    public void setImageUrl(String url) {
        imageUrl = url;
    }

    public void setStep(int st) {
        step = st;
    }
}
