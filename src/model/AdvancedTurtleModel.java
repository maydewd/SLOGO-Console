package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;

public class AdvancedTurtleModel extends BasicTurtleModel {

	private ListProperty<StampInfo> myStamps = new SimpleListProperty<>(FXCollections.observableArrayList());
	private MapProperty<Integer, TurtleInfo> myTurtles = new SimpleMapProperty<>(FXCollections.observableHashMap());
	private MapProperty<Integer, TurtleInfo> mySelectedTurtles = new SimpleMapProperty<>(FXCollections.observableHashMap());

	public AdvancedTurtleModel () {
		super();
	}

	public void setSelectedLineThickness(int i) {
		getActiveTurtle().setLineThickness(i);

	}

	public void setSelectedLineType(int i) {
		getActiveTurtle().setLineThickness(i);
	}

	public ReadOnlyListProperty<StampInfo> stampsProperty() {
		return myStamps;
	}

	public void drawStamp() {
		myStamps.add(new StampInfo(getActiveTurtle().getLocation()));	
	}

	public MapProperty<Integer, TurtleInfo> selectedTurtlesProperty() {
		return mySelectedTurtles;
	}

	public MapProperty<Integer, TurtleInfo> allTurtlesProperty() {
		return myTurtles;
	}

	public TurtleInfo getTurtle (int id) {
		return myTurtles.get(id);
	}


}