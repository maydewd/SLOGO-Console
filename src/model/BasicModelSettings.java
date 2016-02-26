package model;

import controller.commands.AbstractCommandNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.scene.image.Image;


public interface BasicModelSettings {

    public RGBColor getBackgroundColor ();

    public void setBackgroundColor (RGBColor color);

    public String getTurtleImage ();

    public void setTurtleImage (String image);

    public RGBColor getPenColor ();

    public void setPenColor (RGBColor color);

    public String getLanguage ();

    public void setLanguage (String language);

    public ListProperty<String> getVariableListProperty ();

    public ListProperty<String> getCommandHistoryProperty ();

    public MapProperty<String, AbstractCommandNode> getUserCommandsProperty ();

}