package model;

import java.util.List;


public class Turtle {

    private double myHeading = 0;
    private Point myLocation = new Point(0, 0);
    private boolean isPenDown = true;
    private int myPenColorIndex;
    private boolean isVisible = true;
    private int myImageIndex;

    public Turtle (int penColorIndex, int imageIndex) {
        setMyPenColorIndex(penColorIndex);
        setMyImageIndex(imageIndex);
    }

    public Turtle (double heading,
                   Point location,
                   boolean penDown,
                   int penColorIndex,
                   boolean visible,
                   int imageIndex) {
        setHeading(heading);
        setLocation(location);
        setPenDown(penDown);
        setMyPenColorIndex(penColorIndex);
        setVisible(visible);
        setMyImageIndex(imageIndex);
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

    public List<Line> setLocation (Point location) {
        myLocation = location;
        // TODO Add in line creation
        return null;
    }
    
    public List<Line> moveForward (double pixels) {
        // TODO implement and add line creation
        return null;
    }

    public boolean isPenDown () {
        return isPenDown;
    }

    public void setPenDown (boolean penDown) {
        isPenDown = penDown;
    }

    public int getPenColorIndex () {
        return myPenColorIndex;
    }

    public void setMyPenColorIndex (int penColorIndex) {
        myPenColorIndex = penColorIndex;
    }

    public boolean isVisible () {
        return isVisible;
    }

    public void setVisible (boolean isVisible) {
        this.isVisible = isVisible;
    }

    public int getImageIndex () {
        return myImageIndex;
    }

    public void setMyImageIndex (int imageIndex) {
        myImageIndex = imageIndex;
    }

}
