package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Point {

    private DoubleProperty myX;
    private DoubleProperty myY;

    public Point (double x, double y) {
    	myX = new SimpleDoubleProperty(x);
    	myY = new SimpleDoubleProperty(y);
    }

    public void reset(Point newPoint) {
    	myX.set(newPoint.getX().get());
    	myY.set(newPoint.getY().get());
    }
    
    public DoubleProperty getX () {
        return myX;
    }

    public DoubleProperty getY () {
        return myY;
    }
}
