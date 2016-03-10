package model;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import controller.commands.AbstractExpressionNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyListProperty;


public interface IBasicModel {

    public void moveTurtleForward (double pixels);

    public void setTurtleCoordinates (Point newPoint);

    public Point getTurtleCoordinates ();

    public double getTurtleHeading ();

    public void setTurtleHeading (double heading);

    public void setPenDown (boolean penDown);

    public boolean getPenDown ();

    public void setTurtleVisibility (boolean visible);

    public boolean getTurtleVisibility ();

    public void clearLines ();

    public ReadOnlyListProperty<LineInfo> getLines ();

    public MapProperty<String, Double> variableMapProperty();

    public MapProperty<String, List<String>> definedCommandsProperty ();

    public Map<String, AbstractExpressionNode> userCommandsBodies ();

    public ListProperty<String> commandHistoryProperty();

    public ReadOnlyListProperty<String> languageOptionsProperty ();

    public ReadOnlyIntegerProperty getActiveLanguageIndex ();
    
    public void setActiveLanguageIndex (int languageIndex);

    public ListProperty<RGBColor> colorOptionsProperty ();

    public ReadOnlyIntegerProperty getActiveBackgroundColorIndex ();

    public void setActiveBackgroundColorIndex (int backgroundColorIndex);

    public ReadOnlyIntegerProperty getActivePenColorIndex ();

    public void setActivePenColorIndex (int penColorIndex);

    public ListProperty<String> turtleImageOptionsProperty ();

    public ReadOnlyIntegerProperty getActiveTurtleImageIndex ();

    public void setActiveTurtleImageIndex (int turtleImageIndex);

    public void addCoreTurtleObserver (Observer observer);

    public Turtle getActiveTurtle ();
}
