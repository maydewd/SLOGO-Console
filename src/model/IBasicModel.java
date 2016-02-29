package model;

import java.util.List;
import java.util.Observer;
import controller.commands.AbstractExpressionNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
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

    public ReadOnlyListProperty<Line> getLines ();

    public MapProperty<String, Double> variableMapProperty ();

    public MapProperty<String, List<String>> definedCommandsProperty ();

    public MapProperty<String, AbstractExpressionNode> userCommandsBodiesProperty ();

    public ListProperty<String> commandHistoryProperty ();

    public ReadOnlyListProperty<String> languageOptionsProperty ();

    public int getActiveLanguageIndex ();

    public ListProperty<RGBColor> colorOptionsProperty ();

    public int getActiveBackgroundColorIndex ();

    public void setActiveBackgroundColorIndex (int backgroundColorIndex);

    public int getActivePenColorIndex ();

    public void setActivePenColorIndex (int penColorIndex);

    public ListProperty<String> turtleImageOptionsProperty ();

    public int getActiveTurtleImageIndex ();

    public void setActiveTurtleImageIndex (int turtleImageIndex);

    public void addCoreTurtleObserver (Observer observer);

}
