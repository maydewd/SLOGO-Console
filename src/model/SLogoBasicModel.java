package model;

import java.util.List;
import controller.commands.AbstractCommandNode;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.scene.image.Image;


public class SLogoBasicModel implements IBasicModel {

    @Override
    public void setTurtleCoordinates (Point newPoint) {
        // TODO Auto-generated method stub

    }

    @Override
    public Point getTurtleCoordinates () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void getTurtleHeading () {
        // TODO Auto-generated method stub

    }

    @Override
    public double setTurtleHeading () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setPenDown (boolean penDown) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getPenDown () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setTurtleVisibility (boolean visible) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getTurtleVisibility () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clearLines () {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Line> getLines () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setVariable (String name, double value) {
        // TODO Auto-generated method stub

    }

    @Override
    public double getVariable (String name) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public AbstractCommandNode getUserCommand (String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUserCommand (String name, AbstractCommandNode commandRoot) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getLanguage () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addCommandToHistory (String command) {
        // TODO Auto-generated method stub

    }

    @Override
    public RGBColor getBackgroundColor () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBackgroundColor (RGBColor color) {
        // TODO Auto-generated method stub

    }

    @Override
    public Image getTurtleImage () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTurtleImage (Image image) {
        // TODO Auto-generated method stub

    }

    @Override
    public RGBColor getPenColor () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setPenColor (RGBColor color) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLanguage (String language) {
        // TODO Auto-generated method stub

    }

    @Override
    public ListProperty<String> getVariableListProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListProperty<String> getCommandHistoryProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MapProperty<String, AbstractCommandNode> getUserCommandsProperty () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addListener (InvalidationListener listener) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeListener (InvalidationListener listener) {
        // TODO Auto-generated method stub

    }

}
