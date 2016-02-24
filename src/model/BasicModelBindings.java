package model;

import controller.commands.AbstractCommandNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;


public interface BasicModelBindings {

    public ListProperty<String> getVariableListProperty ();

    public ListProperty<String> getCommandHistoryProperty ();

    public MapProperty<String, AbstractCommandNode> getUserCommandsProperty ();

}
