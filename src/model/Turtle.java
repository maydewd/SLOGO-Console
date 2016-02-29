package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Turtle {
	
	private DoubleProperty myHeading;
	private Point myLocation;
	private BooleanProperty myPenDown;
	private BooleanProperty myVisibility;
	private StringProperty myImage;
	
	public Turtle(double h, Point l, boolean pd, boolean v, String i){
		this.myHeading = new SimpleDoubleProperty(h);
		this.myLocation = l;
		this.myPenDown = new SimpleBooleanProperty(pd);
		this.myVisibility = new SimpleBooleanProperty(v);
		this.myImage = new SimpleStringProperty(i);
	}
	
	public DoubleProperty getHeading() {
		return myHeading;
	}
	
	public Point getLocation(){
		return myLocation;
	}

	public BooleanProperty getPenDown() {
		return myPenDown;
	}
	
	public BooleanProperty getVisibility() {
		return myVisibility;
	}
	
	public StringProperty getImage(){
		return myImage;
	}
}
