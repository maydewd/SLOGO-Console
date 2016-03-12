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
    private ListProperty<LineInfo> myLines = new SimpleListProperty<>(FXCollections.observableArrayList());
    private IntegerProperty myBackgroundColorIndexProperty = new SimpleIntegerProperty(0);

    public BasicTurtleModel () {
        myTurtle = new Turtle();
    }

    public void moveTurtleForward (double pixels) {
        linesProperty().addAll(getActiveTurtle().moveForward(pixels));
        changeAndNotify();
    }

    public void setTurtleCoordinates (Point newPoint) {
        getActiveTurtle().setLocation(newPoint);
        changeAndNotify();
    }

    public Point getTurtleCoordinates () {
        return getActiveTurtle().getLocation();
    }

    public double getTurtleHeading () {
        return getActiveTurtle().getHeading();
    }

    public void setTurtleHeading (double heading) {
        getActiveTurtle().setHeading(heading);
        changeAndNotify();
    }

    public void setPenDown (boolean penDown) {
        getActiveTurtle().setPenDown(penDown);
    }

    public boolean getPenDown () {
        return getActiveTurtle().isPenDown();
    }

    public void setTurtleVisibility (boolean isVisible) {
        getActiveTurtle().setVisible(isVisible);
        changeAndNotify();
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
    
    public void setPenColor (int index) {
        getActiveTurtle().getPenColorIndexProperty().set(index);
    }

    public IntegerProperty getActiveTurtleImageIndex () {
        return getActiveTurtle().getImageIndexProperty();
    }
    
    public void setImageIndex (int index) {
        getActiveTurtle().getImageIndexProperty().set(index);
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
    
    protected void changeAndNotify () {
        setChanged();
        notifyObservers();
    }
    
}