package model;

public interface TurtleInfo {

    double getHeading ();

    Point getLocation ();

    boolean isPenDown ();

    boolean isVisible ();

    int getPenColorIndex ();

    int getImageIndex ();

    int getID ();
}
