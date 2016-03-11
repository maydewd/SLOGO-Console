package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.AbstractMap.SimpleEntry;

public class AdvancedOptionsModel extends BasicOptionsModel {
	
	private static final Double[] LINE_THICKNESSES = {1.0, 3.0, 5.0};
	private static final Map<Integer, String> LINE_TYPE_STRING_NAMES = new HashMap<Integer, String>() {{
		put(0, "Solid");
		put(1, "Dashed");
		put(2, "Dotted");
	}};
	
	private ListProperty<Double> myLineThicknessOptionsProperty = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<Entry<Double, Double>> myLineTypeOptions = new SimpleListProperty<>(FXCollections.observableArrayList());
    
	public AdvancedOptionsModel () {
        super();
        initializeLineTypes();
        initializeLineThicknesses();
    }

	public void initializeLineTypes () {
		myLineTypeOptions.add(new SimpleEntry(0,0));
		myLineTypeOptions.add(new SimpleEntry(20,15));
		myLineTypeOptions.add(new SimpleEntry(5,15));
	}
	
	public void initializeLineThicknesses () {
		ObservableList<Double> thicknesses = FXCollections.observableArrayList(Arrays.asList(LINE_THICKNESSES));
		myLineThicknessOptionsProperty = new SimpleListProperty<Double>(thicknesses);
	}
	
	public ListProperty<Entry<Double, Double>> lineTypeOptionsProperty() {
		return myLineTypeOptions;
	}
	
	public ListProperty<Double> lineThicknessOptionsProperty() {
		return myLineThicknessOptionsProperty;
	}
	
	public Map<Integer, String> getLineTypeMap() {
		return LINE_TYPE_STRING_NAMES;
	}
	
}
