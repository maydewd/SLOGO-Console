package model;

/**
 * Immutable representation of a 2-d position
 *
 * @author David Maydew
 *
 */
public class Point {

    private double myX;
    private double myY;

    public Point (double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX () {
        return myX;
    }

    private void setX (double x) {
        myX = x;
    }

    public double getY () {
        return myY;
    }

    private void setY (double y) {
        myY = y;
    }
}
