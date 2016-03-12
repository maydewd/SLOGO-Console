package model;

/**
 * Read-only interface for looking at the state of a turtle
 *
 * @author David Maydew
 *
 */
public interface TurtleInfo {

    double getHeading ();

    Point getLocation ();

    boolean isPenDown ();

    boolean isVisible ();

    int getPenColorIndex ();

    int getImageIndex ();

    int getID ();
}
