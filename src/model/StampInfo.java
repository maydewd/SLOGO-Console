package model;

public class StampInfo {
    private Point myLocation;
    private int myImageIndex;
    private double myRotation;

    public StampInfo (Point location, int imageIndex, double rotation) {
        myLocation = location;
        myImageIndex = imageIndex;
        myRotation = rotation;
    }

    public Point getLocation () {
        return myLocation;
    }

    public int getImageIndex () {
        return myImageIndex;
    }

    public double getRotation () {
        return myRotation;
    }

}
