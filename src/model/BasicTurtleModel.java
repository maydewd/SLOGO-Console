package model;


import java.util.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;


public class BasicTurtleModel extends Observable {

    private Turtle myTurtle;
    private ListProperty<TurtleInfo> myTurtles = new SimpleListProperty<>(FXCollections.observableArrayList());
    private ListProperty<LineInfo> myLines = new SimpleListProperty<>(FXCollections.observableArrayList());
    private IntegerProperty myBackgroundColorIndexProperty = new SimpleIntegerProperty(0);

    public BasicTurtleModel () {
        myTurtles.add(new Turtle(1,0));
    	setMyTurtle((Turtle) myTurtles.get(0));
    }

    public void moveTurtleForward (double pixels) {
        linesProperty().addAll(getMyTurtle().moveForward(pixels));
        setChanged();
        notifyObservers();
    }

    public void setTurtleCoordinates (Point newPoint) {
        getMyTurtle().setLocation(newPoint);
        setChanged();
        notifyObservers();
    }

    public Point getTurtleCoordinates () {
        return getMyTurtle().getLocation();
    }

    public double getTurtleHeading () {
        return getMyTurtle().getHeading();
    }

    public void setTurtleHeading (double heading) {
        getMyTurtle().setHeading(heading);
        setChanged();
        notifyObservers();
    }

    public void setPenDown (boolean penDown) {
        getMyTurtle().setPenDown(penDown);
    }

    public boolean getPenDown () {
        return getMyTurtle().isPenDown();
    }

    public void setTurtleVisibility (boolean isVisible) {
        getMyTurtle().setVisible(isVisible);
        setChanged();
        notifyObservers();
    }

    public boolean getTurtleVisibility () {
        return getMyTurtle().isVisible();
    }

    public void clearLines () {
        linesProperty().clear();
    }

    public ReadOnlyListProperty<LineInfo> getReadOnlyLines () {
        return linesProperty();
    }

    public IntegerProperty getActivePenColorIndex () {
        return getMyTurtle().getPenColorIndexProperty();
    }

    public IntegerProperty getActiveTurtleImageIndex () {
        return getMyTurtle().getImageIndexProperty();
    }

    private Turtle getMyTurtle () {
        return myTurtle;
    }

    private void setMyTurtle (Turtle myTurtle) {
        this.myTurtle = myTurtle;
    }

    private ListProperty<LineInfo> linesProperty () {
        return myLines;
    }

    public IntegerProperty backgroundColorIndexProperty () {
        return myBackgroundColorIndexProperty;
    }
    public ListProperty<TurtleInfo> getMyTurtlesProperty() {
    	return myTurtles;
    }
    
    public Turtle getActiveTurtle () {
    	return myTurtle;
    }
}