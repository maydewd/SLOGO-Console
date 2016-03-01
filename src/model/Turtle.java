package model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Turtle {

    private double myHeading = 0;
    private Point myLocation = new Point(0, 0);
    private boolean isPenDown = true;
    private IntegerProperty myPenColorIndexProperty = new SimpleIntegerProperty();
    private boolean isVisible = true;
    private IntegerProperty myImageIndexProperty = new SimpleIntegerProperty();

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


    public void setLocation (Point location) {
        myLocation = location;
        // TODO Add in line creation
    }

    public List<LineInfo> moveForward (double pixels) {
        // TODO implement and add line creation
    	return null;
    }

    public boolean isPenDown () {
        return isPenDown;
    }

    public void setPenDown (boolean penDown) {
        isPenDown = penDown;
    }

    public IntegerProperty getPenColorIndexProperty () {
        return myPenColorIndexProperty;
    }

    public void setMyPenColorIndex (int penColorIndex) {
        myPenColorIndexProperty.set(penColorIndex);
    }

    public boolean isVisible () {
        return isVisible;
    }

    public void setVisible (boolean isVisible) {
        this.isVisible = isVisible;
    }

    public IntegerProperty getImageIndexProperty () {
        return myImageIndexProperty;
    }

    public void setMyImageIndex (int imageIndex) {
        myImageIndexProperty.set(imageIndex);
    }

}
