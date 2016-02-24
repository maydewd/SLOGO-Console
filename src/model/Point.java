package model;

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

    public void setX (double x) {
        myX = x;
    }

    public double getY () {
        return myY;
    }

    public void setY (double y) {
        myY = y;
    };
    

}
