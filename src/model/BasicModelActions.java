package model;

import java.util.List;
import controller.commands.AbstractExpressionNode;


public interface BasicModelActions {

    public void setTurtleCoordinates (Point newPoint);

    public Point getTurtleCoordinates ();

    public void getTurtleHeading ();

    public double setTurtleHeading ();

    public void setPenDown (boolean penDown);

    public boolean getPenDown ();

    public void setTurtleVisibility (boolean visible);

    public boolean getTurtleVisibility ();

    public void clearLines ();

    public List<Line> getLines ();

    public void setVariable (String name, double value);

    public double getVariable (String name);

    public AbstractExpressionNode getUserCommand (String name);

    public void setUserCommand (String name, AbstractExpressionNode commandRoot);

    public String getLanguage ();

    public void addCommandToHistory (String command);

}
