package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Tim on 01/03/16.
 */
public class Variable {

	private final StringProperty name;
	private final DoubleProperty value;

	public Variable(String name, double value){
		this.name = new SimpleStringProperty(name);
		this.value = new SimpleDoubleProperty(value);
	}

	public String getName(){
		return name.get();
	}

	public void setValue(String newValue){
		name.set(newValue);
	}

	public double getValue(){
		return value.get();
	}

	public void setValue(double newValue){
		value.set(newValue);
	}
}
