package model;

import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class AdvancedOptionsModel extends BasicOptionsModel {
	
	private static final List<LineThickness> INITIAL_LINE_THICKNESSES = Arrays.asList(new LineThickness("Small", 0.5),
	                                                                                  new LineThickness("Medium", 1.0),
	                                                                                  new LineThickness("Large", 2.0));
	private static final List<LineType> INITIAL_LINE_TYPES = Arrays.asList(LineType.SOLID,
	                                                                       LineType.DASHED,
	                                                                       LineType.DOTTED);
	
	private ListProperty<LineThickness> myLineThicknessOptionsProperty = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<LineType> myLineTypeOptions = new SimpleListProperty<>(FXCollections.observableArrayList());
    
	public AdvancedOptionsModel () {
        super();
        initializeLineTypes();
        initializeLineThicknesses();
    }

	public void initializeLineTypes () {
		myLineTypeOptions.addAll(INITIAL_LINE_TYPES);
	}
	
	public void initializeLineThicknesses () {
	    myLineThicknessOptionsProperty.addAll(INITIAL_LINE_THICKNESSES);
	}
	
	public ListProperty<LineType> lineTypeOptionsProperty() {
		return myLineTypeOptions;
	}
	
	public ListProperty<LineThickness> lineThicknessOptionsProperty() {
		return myLineThicknessOptionsProperty;
	}
	
}
