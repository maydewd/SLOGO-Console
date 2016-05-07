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

    private boolean isPenDown = true;
    private IntegerProperty myPenColorIndexProperty = new SimpleIntegerProperty(DEFAULT_PEN_INDEX);
    private boolean isVisible = true;
    private IntegerProperty myImageIndexProperty = new SimpleIntegerProperty(DEFAULT_IMAGE_INDEX);
    private int myID;
    private boolean isSelected = true;
    private double myLineThickness;
    private LineType myLineType;
    private MovementModule myMovementModule = new MovementModule();

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
        return myMovementModule.getHeading();
    }

    public void setHeading (double heading) {
        myMovementModule.setHeading(heading);
    }

    @Override
    public Point getLocation () {
        return myMovementModule.getLocation();
    }

    public void setLocation (Point location) {
        myMovementModule.setLocation(location);
    }

    public List<LineInfo> moveForward (double pixels) {
        Point newLoc = myMovementModule.moveForward(pixels);

        ArrayList<LineInfo> myLines = new ArrayList<>();
        myLines.add(new LineInfo(getLocation(), newLoc, isPenDown, myPenColorIndexProperty.get(),
                                 getLineThickness(), getLineType()));

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

    public MovementModule getMovementModule () {
        return myMovementModule;
    }

    public void setMovementModule (MovementModule module) {
        myMovementModule = module;
    }

}
