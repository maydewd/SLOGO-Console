package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import app.Main;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.scene.image.Image;
import view.UIView;

public class BasicModel extends Model implements BasicModelActions, BasicModelSettings {
	
	private static final double DEFAULT_HEADING = 0.0;
	private static final Point DEFAULT_LOCATION = new Point(0,0);
	private static final boolean DEFAULT_PENDOWN = false;
	private static final boolean DEFAULT_VISIBILITY = true;
	private static final String DEFAULT_IMAGE = "";

	private Turtle myTurtle;
	private RGBColor myPenColor;
	private RGBColor myBackgroundColor;
	
	
	public BasicModel(String lang) {
		super(lang);
		// TODO Auto-generated constructor stub
		this.myTurtle = new Turtle(DEFAULT_HEADING, DEFAULT_LOCATION, DEFAULT_PENDOWN, DEFAULT_VISIBILITY, DEFAULT_IMAGE);
	}

	@Override
	public void setTurtleCoordinates(Point newPoint) {
		// TODO Auto-generated method stub
		addLine(new Line(myTurtle.getLocation(), newPoint, myTurtle.getPenDown().get()));
		myTurtle.getLocation().reset(newPoint);
		setChanged();
		notifyObservers();
	}

	@Override
	public Point getTurtleCoordinates() {
		// TODO Auto-generated method stub
		return myTurtle.getLocation();
	}

	@Override
	public double getTurtleHeading() {
		// TODO Auto-generated method stub
		return myTurtle.getHeading().get();
	}

	@Override
	public void setTurtleHeading(double heading) {
		// TODO Auto-generated method stub
		myTurtle.getHeading().set(heading);
		setChanged();
		notifyObservers();
	}

	@Override
	public void setPenDown(boolean penDown) {
		// TODO Auto-generated method stub
		myTurtle.getPenDown().set(penDown);
	}

	@Override
	public boolean getPenDown() {
		// TODO Auto-generated method stub
		return myTurtle.getPenDown().get();
	}

	@Override
	public void setTurtleVisibility(boolean visible) {
		// TODO Auto-generated method stub
		myTurtle.getVisibility().set(visible);
		setChanged();
		notifyObservers();
	}

	@Override
	public boolean getTurtleVisibility() {
		// TODO Auto-generated method stub
		return myTurtle.getVisibility().get();
	}

	@Override
	public RGBColor getBackgroundColor() {
		// TODO Auto-generated method stub
		return myBackgroundColor;
	}

	@Override
	public void setBackgroundColor(RGBColor color) {
		// TODO Auto-generated method stub
		myBackgroundColor = color;
		setChanged();
		notifyObservers();
	}

	@Override
	public String getTurtleImage() {
		// TODO Auto-generated method stub
		return myTurtle.getImage().get();
	}

	@Override
	public void setTurtleImage(String image) {
		// TODO Auto-generated method stub
		myTurtle.getImage().set(image);
		setChanged();
		notifyObservers();
	}

	@Override
	public RGBColor getPenColor() {
		// TODO Auto-generated method stub
		return myPenColor;
	}

	@Override
	public void setPenColor(RGBColor color) {
		// TODO Auto-generated method stub
		myPenColor = color;
		
	}



}
