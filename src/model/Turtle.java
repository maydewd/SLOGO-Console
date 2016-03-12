package model;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Turtle implements TurtleInfo {

    private static final int DEFAULT_ID = 1;
    private static final int DEFAULT_PEN_INDEX = 1;
    private static final int DEFAULT_IMAGE_INDEX = 0;
    public static final double DEFAULT_LINE_THICKNESS = 1.0d;
    public static final LineType DEFAULT_LINE_TYPE = LineType.SOLID;

    private double myHeading = 0;
    private Point myLocation = new Point(0, 0);
    private boolean isPenDown = true;
    private IntegerProperty myPenColorIndexProperty = new SimpleIntegerProperty(DEFAULT_PEN_INDEX);
    private boolean isVisible = true;
    private IntegerProperty myImageIndexProperty = new SimpleIntegerProperty(DEFAULT_IMAGE_INDEX);
    private int myID;
    private boolean isSelected = true;
    private double myLineThickness;
    private LineType myLineType;

    public Turtle () {
        this(DEFAULT_ID);
    }

    public Turtle (int ID) {
        this(ID, DEFAULT_PEN_INDEX, DEFAULT_IMAGE_INDEX, DEFAULT_LINE_THICKNESS, DEFAULT_LINE_TYPE);
    }

    public Turtle (int ID, int penColorIndex, int imageIndex, double thickness, LineType lineType) {
        setMyPenColorIndex(penColorIndex);
        setMyImageIndex(imageIndex);
        setID(ID);
        setLineThickness(thickness);
        setLineType(lineType);
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

    @Override
    public double getHeading () {
        return myHeading;
    }

    public void setHeading (double heading) {
        myHeading = heading;
    }

    @Override
    public Point getLocation () {
        return myLocation;
    }

    public void setLocation (Point location) {
        myLocation = location;
    }

    public List<LineInfo> moveForward (double pixels) {
        double newX = myLocation.getX() + Math.cos(Math.toRadians(myHeading)) * pixels;
        double newY = myLocation.getY() + Math.sin(Math.toRadians(myHeading)) * pixels;
        Point newLoc = new Point(newX, newY);

        ArrayList<LineInfo> myLines = new ArrayList<>();
        myLines.add(new LineInfo(myLocation, newLoc, isPenDown, myPenColorIndexProperty.get(),
                                 getLineThickness(), getLineType()));

        setLocation(newLoc);

        return myLines;
    }

    @Override
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

    @Override
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

    @Override
    public int getPenColorIndex () {
        return getPenColorIndexProperty().getValue();
    }

    @Override
    public int getImageIndex () {
        return getImageIndexProperty().getValue();
    }

    @Override
    public int getID () {
        return myID;
    }

    private void setID (int ID) {
        myID = ID;
    }

    public boolean getSelected () {
        return isSelected;
    }

    public void setSelected (boolean select) {
        isSelected = select;
    }

    public void setLineType (LineType lineType) {
        myLineType = lineType;
    }

    public LineType getLineType () {
        return myLineType;
    }

    public void setLineThickness (double thickness) {
        myLineThickness = thickness;
    }

    public double getLineThickness () {
        return myLineThickness;
    }

}
