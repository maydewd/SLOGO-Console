package model;


import java.util.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;


public class BasicTurtleModel extends Observable {
    
    
    private static final int DEFAULT_PEN_COLOR = 1;
    private static final int DEFAULT_IMAGE_INDEX = 0;

    private Turtle myTurtle;
    private ListProperty<LineInfo> myLines = new SimpleListProperty<>(FXCollections.observableArrayList());
    private IntegerProperty myBackgroundColorIndexProperty = new SimpleIntegerProperty(0);

    public BasicTurtleModel () {
        myTurtle = new Turtle(DEFAULT_PEN_COLOR, DEFAULT_IMAGE_INDEX);
    }

    public void moveTurtleForward (double pixels) {
        linesProperty().addAll(getActiveTurtle().moveForward(pixels));
        setChanged();
        notifyObservers();
    }

    public void setTurtleCoordinates (Point newPoint) {
        getActiveTurtle().setLocation(newPoint);
        setChanged();
        notifyObservers();
    }

    public Point getTurtleCoordinates () {
        return getActiveTurtle().getLocation();
    }

    public double getTurtleHeading () {
        return getActiveTurtle().getHeading();
    }

    public void setTurtleHeading (double heading) {
        getActiveTurtle().setHeading(heading);
        setChanged();
        notifyObservers();
    }

    public void setPenDown (boolean penDown) {
        getActiveTurtle().setPenDown(penDown);
    }

    public boolean getPenDown () {
        return getActiveTurtle().isPenDown();
    }

    public void setTurtleVisibility (boolean isVisible) {
        getActiveTurtle().setVisible(isVisible);
        setChanged();
        notifyObservers();
    }

    public boolean getTurtleVisibility () {
        return getActiveTurtle().isVisible();
    }

    public void clearLines () {
        linesProperty().clear();
    }

    public ReadOnlyListProperty<LineInfo> getReadOnlyLines () {
        return linesProperty();
    }

    public IntegerProperty getActivePenColorIndex () {
        return getActiveTurtle().getPenColorIndexProperty();
    }

    public IntegerProperty getActiveTurtleImageIndex () {
        return getActiveTurtle().getImageIndexProperty();
    }

    protected Turtle getActiveTurtle () {
        return myTurtle;
    }

    protected void setActiveTurtle (Turtle myTurtle) {
        this.myTurtle = myTurtle;
    }

    private ListProperty<LineInfo> linesProperty () {
        return myLines;
    }

    public IntegerProperty backgroundColorIndexProperty () {
        return myBackgroundColorIndexProperty;
    }
    
}