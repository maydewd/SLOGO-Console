package model;

import java.util.List;
import controller.commands.AbstractCommandNode;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.scene.image.Image;


public class SLogoBasicModel implements IBasicModel {

	private static final double DEFAULT_HEADING = 0.0;
	private static final Point DEFAULT_LOCATION = new Point(0,0);
	private static final boolean DEFAULT_PENDOWN = false;
	private static final boolean DEFAULT_VISIBILITY = true;
	private static final String DEFAULT_IMAGE = "";

	private ListProperty<Turtle> myTurtles;
	private Turtle myTurtle;
	private RGBColor myPenColor;
	private RGBColor myBackgroundColor;
	private String myLanguage;
	private MapProperty<String, Object> myVariables;
	private ListProperty<String> myCommandHistory;
	private MapProperty<String, AbstractCommandNode> myUserCommands;
	private ListProperty<Line> myLines;
	
	public SLogoBasicModel () {
		this.myTurtles = new SimpleListProperty<Turtle>();
		myTurtles.add(new Turtle(DEFAULT_HEADING, DEFAULT_LOCATION, DEFAULT_PENDOWN, DEFAULT_VISIBILITY, DEFAULT_IMAGE));
		setCurrentTurtle();
		this.myVariables = new SimpleMapProperty<String, Object>();
		this.myCommandHistory = new SimpleListProperty<String>();
		this.myUserCommands = new SimpleMapProperty<String, AbstractCommandNode>();
		this.myLines = new SimpleListProperty<Line>();
	}
	
    @Override
    public void setTurtleCoordinates (Point newPoint) {
        // TODO Auto-generated method stub
    	myLines.add(new Line(myTurtle.getLocation(), newPoint, myTurtle.getPenDown().get()));
    	myTurtle.getLocation().reset(newPoint);
    	/*
    	 * setChanged();
    	 * notifyObservers();
    	 */
    }

    @Override
    public Point getTurtleCoordinates () {
        // TODO Auto-generated method stub
    	return myTurtle.getLocation();
    }

    @Override
    public double getTurtleHeading () {
        // TODO Auto-generated method stub
    	return myTurtle.getHeading().get();
    }

	@Override
	public void setTurtleHeading(double heading) {
		// TODO Auto-generated method stub
		myTurtle.getHeading().set(heading);
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
	}

	@Override
	public boolean getTurtleVisibility() {
		// TODO Auto-generated method stub
		return myTurtle.getVisibility().get();
	}

    @Override
    public void clearLines () {
        // TODO Auto-generated method stub
    	myLines.clear();
    }

    @Override
    public List<Line> getLines () {
        // TODO Auto-generated method stub
        return myLines;
    }

    @Override
    public void setVariable(String name, Object value) {
		// TODO Auto-generated method stub
		myVariables.put(name, value);
	}

    @Override
	public Object getVariable(String name) {
		// TODO Auto-generated method stub
		return myVariables.get(name);
	}

    @Override
    public AbstractCommandNode getUserCommand (String name) {
        // TODO Auto-generated method stub
    	return myUserCommands.get(name);
    }

    @Override
    public void setUserCommand (String name, AbstractCommandNode commandRoot) {
        // TODO Auto-generated method stub
    	myUserCommands.put(name, commandRoot);
    }

    @Override
    public String getLanguage () {
        // TODO Auto-generated method stub
        return myLanguage;
    }

    @Override
    public void addCommandToHistory (String command) {
        // TODO Auto-generated method stub
    	myCommandHistory.get().add(command);
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

    @Override
    public void setLanguage (String language) {
        // TODO Auto-generated method stub
    	myLanguage = language;
    }

    @Override
    public ListProperty<String> getVariableListProperty () {
        // TODO Auto-generated method stub
    	ListProperty<String> variables = new SimpleListProperty<String>();
		variables.get().addAll(myVariables.keySet());
		return variables;
    }

    @Override
    public ListProperty<String> getCommandHistoryProperty () {
        // TODO Auto-generated method stub
    	return myCommandHistory;
    }

    @Override
    public MapProperty<String, AbstractCommandNode> getUserCommandsProperty () {
        // TODO Auto-generated method stub
    	return myUserCommands;
    }

    @Override
    public void addListener (InvalidationListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeListener (InvalidationListener listener) {
        // TODO Auto-generated method stub

    }

	@Override
	public void setCurrentTurtle() {
		// TODO Auto-generated method stub
		myTurtle = myTurtles.get(0);
	}


}
