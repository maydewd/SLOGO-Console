package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Observer;
import app.Main;
import controller.commands.AbstractExpressionNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.scene.image.Image;
import view.UIView;

public class BasicModel extends Model implements IBasicModel {
	
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
    public void moveTurtleForward (double pixels) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ReadOnlyListProperty<Line> getLines () {
        // TODO Auto-generated method stub
        return null;
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



}
