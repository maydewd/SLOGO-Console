package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class AdvancedTurtleModel extends BasicTurtleModel {

	private ListProperty<StampInfo> myStamps = new SimpleListProperty<>(FXCollections.observableArrayList());
	
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

}
