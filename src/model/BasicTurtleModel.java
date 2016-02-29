package model;

import java.util.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;

public class BasicTurtleModel extends Observable {
    
    private Turtle myTurtle;
    private ListProperty<Line> myLines = new SimpleListProperty<Line>();

    public BasicTurtleModel () {
        setMyTurtle(new Turtle(0, 0));
    }
    
    public void moveTurtleForward (double pixels) {
        getMyTurtle().moveForward(pixels);
    }

    public void setTurtleCoordinates (Point newPoint) {
        getMyTurtle().setLocation(newPoint);
    }

    public Point getTurtleCoordinates () {
        return getMyTurtle().getLocation();
    }

    public double getTurtleHeading () {
        return getMyTurtle().getHeading();
    }

    public void setTurtleHeading (double heading) {
        getMyTurtle().setHeading(heading);
    }

    public void setPenDown (boolean penDown) {
        getMyTurtle().setPenDown(penDown);
    }

    public boolean getPenDown () {
        return getMyTurtle().isPenDown();
    }

    public void setTurtleVisibility (boolean isVisible) {
        getMyTurtle().setVisible(isVisible);
    }

    public boolean getTurtleVisibility () {
        return getMyTurtle().isVisible();
    }

    public void clearLines () {
        linesProperty().clear();
    }

    public ReadOnlyListProperty<Line> getReadOnlyLines () {
        return linesProperty();
    }
    
    public int getActivePenColorIndex () {
        return getMyTurtle().getPenColorIndex();
    }
    
    public int getActiveTurtleImageIndex () {
        return getMyTurtle().getImageIndex();
    }

    private Turtle getMyTurtle () {
        return myTurtle;
    }

    private void setMyTurtle (Turtle myTurtle) {
        this.myTurtle = myTurtle;
    }
    
    private ListProperty<Line> linesProperty() {
        return myLines;
    }

}
