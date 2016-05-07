package model;

/**
 * This class manages the location and heading for an object, as well as implementing basic movement
 * functionality
 * 
 * @author David Maydew
 *
 */
public class WindowMovementModule {

    private double myHeading = 0;
    private Point myLocation = new Point(0, 0);

    public WindowMovementModule () {
    }
    
    public WindowMovementModule (WindowMovementModule previousModule) {
        myHeading = previousModule.getHeading();
        myLocation = previousModule.getLocation();
    }

    public double getHeading () {
        return myHeading;
    }

    public void setHeading (double heading) {
        myHeading = heading;
    }

    public Point getLocation () {
        return myLocation;
    }

    public void setLocation (Point point) {
        myLocation = point;
    }

    /**
     * Moves the current location forward by a specified number of pixels, limited by the current
     * window border behavior.
     * 
     * @param pixels to move forward by
     */
    public void moveForward (double pixels) {
        double newX = myLocation.getX() + Math.cos(Math.toRadians(myHeading)) * pixels;
        double newY = myLocation.getY() + Math.sin(Math.toRadians(myHeading)) * pixels;
        Point newLoc = new Point(newX, newY);
        setLocation(newLoc);
    }
}
