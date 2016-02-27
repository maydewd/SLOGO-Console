package model;

import java.util.List;
import java.util.Observer;
import controller.commands.AbstractExpressionNode;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyListProperty;
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
	private MapProperty<String, Double> myVariables;
	private ListProperty<String> myCommandHistory;
	private MapProperty<String, AbstractExpressionNode> myUserCommands;
	private ListProperty<Line> myLines;
	
	public SLogoBasicModel () {
		this.myTurtles = new SimpleListProperty<Turtle>();
		myTurtles.add(new Turtle(DEFAULT_HEADING, DEFAULT_LOCATION, DEFAULT_PENDOWN, DEFAULT_VISIBILITY, DEFAULT_IMAGE));
		setCurrentTurtle();
		this.myVariables = new SimpleMapProperty<String, Double>();
		this.myCommandHistory = new SimpleListProperty<String>();
		this.myUserCommands = new SimpleMapProperty<String, AbstractExpressionNode>();
		this.myLines = new SimpleListProperty<Line>();
	}
	
    private void setCurrentTurtle () {
        // TODO Auto-generated method stub
        
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
    public MapProperty<String, Double> variableMapProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MapProperty<String, List<String>> definedCommandsProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MapProperty<String, AbstractExpressionNode> userCommandsBodiesProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListProperty<String> commandHistoryProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReadOnlyListProperty<String> languageOptionsProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getActiveLanguageIndex () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListProperty<RGBColor> colorOptionsProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getActiveBackgroundColorIndex () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getActivePenColorIndex () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListProperty<String> turtleImageOptionsProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getActiveTurtleImageIndex () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addCoreTurtleObserver (Observer observer) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void moveTurtleForward (double pixels) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ReadOnlyListProperty<Line> getLines () {
        // TODO Auto-generated method stub
        return null;
    }


}
