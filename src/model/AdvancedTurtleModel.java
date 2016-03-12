package model;

import java.util.List;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;


public class AdvancedTurtleModel extends BasicTurtleModel {

    private static final int STARTING_INDEX = 1;

    private ListProperty<StampInfo> myStamps =
            new SimpleListProperty<>(FXCollections.observableArrayList());
    private MapProperty<Integer, Turtle> myTurtles =
            new SimpleMapProperty<>(FXCollections.observableHashMap());
    private ListProperty<Integer> mySelectedTurtleIndexes =
            new SimpleListProperty<>(FXCollections.observableArrayList());
    private double myThickness = Turtle.DEFAULT_LINE_THICKNESS;
    private LineType myLineType = Turtle.DEFAULT_LINE_TYPE;

    public AdvancedTurtleModel () {
        super();
        selectTurtle(STARTING_INDEX);
    }

    public ReadOnlyListProperty<StampInfo> stampsProperty () {
        return myStamps;
    }
    
    public void clearStamps () {
        stampsProperty().clear();
        changeAndNotify();
    }

    public void drawStamp () {
        myStamps.add(new StampInfo(getActiveTurtle().getLocation(),
                                   getActiveTurtleImageIndex().getValue(), getActiveTurtle().getHeading()));
        changeAndNotify();
    }

    public ReadOnlyListProperty<Integer> selectedTurtlesProperty () {
        return mySelectedTurtleIndexes;
    }

    public MapProperty<Integer, Turtle> allTurtlesProperty () {
        return myTurtles;
    }

    public TurtleInfo getTurtle (int id) {
        return myTurtles.get(id);
    }

    public void selectTurtle (int index) {
        if (!allTurtlesProperty().containsKey(index)) {
            Turtle turtle =
                    new Turtle(index, getActivePenColorIndex().getValue(),
                               getActiveTurtleImageIndex().getValue(), getThickness(),
                               getLineType());
            allTurtlesProperty().put(index, turtle);
        }
        if (!selectedTurtlesProperty().contains(index)) {
            selectedTurtlesProperty().add(index);
        }
        setActiveTurtle(allTurtlesProperty().get(index));
        changeAndNotify();
    }

    @Override
    public void setPenColor (int index) {
        forAllTurtles(turtle -> turtle.setMyPenColorIndex(index));
    }

    @Override
    public void setImageIndex (int index) {
        forAllTurtles(turtle -> turtle.setMyImageIndex(index));
        changeAndNotify();
    }

    @Override
    public void setPenDown (boolean penDown) {
        forSelectedTurtles(turtle -> turtle.setPenDown(penDown));
    }

    public void setLineThickness (double thickness) {
        setThickness(thickness);
        forAllTurtles(turtle -> turtle.setLineThickness(thickness));
    }

    public void setSelectedLineType (LineType lineType) {
        setLineType(lineType);
        forAllTurtles(turtle -> turtle.setLineType(lineType));
    }

    private void forAllTurtles (Consumer<? super Turtle> action) {
        allTurtlesProperty().values().forEach(action);
    }

    private void forSelectedTurtles (Consumer<? super Turtle> action) {
        List<Turtle> selectedTurtles = allTurtlesProperty().entrySet().stream()
                                       .filter(entry -> selectedTurtlesProperty().contains(entry.getKey()))
                                       .map(entry -> entry.getValue())
                                       .collect(Collectors.toList());
        selectedTurtles.forEach(action);
    }

    private LineType getLineType () {
        return myLineType;
    }

    private void setLineType (LineType myLineType) {
        this.myLineType = myLineType;
    }

    private double getThickness () {
        return myThickness;
    }

    private void setThickness (double myThickness) {
        this.myThickness = myThickness;
    }

}
