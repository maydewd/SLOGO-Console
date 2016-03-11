package model;

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

    public AdvancedTurtleModel () {
        super();
        selectTurtle(STARTING_INDEX);
    }

    public void setSelectedLineThickness (int i) {
        getActiveTurtle().setLineThickness(i);

    }

    public void setSelectedLineType (int i) {
        getActiveTurtle().setLineThickness(i);
    }

    public ReadOnlyListProperty<StampInfo> stampsProperty () {
        return myStamps;
    }

    public void drawStamp () {
        myStamps.add(new StampInfo(getActiveTurtle().getLocation(),
                                   getActiveTurtleImageIndex().getValue()));
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
            allTurtlesProperty().put(index, new Turtle(index));
        }
        selectedTurtlesProperty().add(index);
        setActiveTurtle(allTurtlesProperty().get(index));
    }

}
