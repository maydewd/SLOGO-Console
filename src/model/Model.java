package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import controller.commands.AbstractCommandNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import view.UIView;

public abstract class Model extends Observable {

	private String myLanguage;
	private MapProperty<String, Object> myVariables;
	private ListProperty<String> myCommandHistory;
	private MapProperty<String, AbstractCommandNode> myUserCommands;
	private ListProperty<Line> myLines;
	
	public Model(String lang) {
		// TODO Auto-generated constructor stub
		this.myLanguage = lang;
		this.myCommandHistory = new SimpleListProperty<String>();
		this.myUserCommands = new SimpleMapProperty<String, AbstractCommandNode>();
	}
	
	public String getLanguage() {
		// TODO Auto-generated method stub
		return myLanguage;
	}

	public void addCommandToHistory(String command) {
		// TODO Auto-generated method stub
		myCommandHistory.get().add(command);	
	}
	
	public ListProperty<String> getCommandHistoryProperty() {
		// TODO Auto-generated method stub
		return myCommandHistory;
	}

	public AbstractCommandNode getUserCommand(String name) {
		// TODO Auto-generated method stub
		return myUserCommands.get(name);
	}

	public void setUserCommand(String name, AbstractCommandNode commandRoot) {
		// TODO Auto-generated method stub
		myUserCommands.put(name, commandRoot);
	}
	
	public MapProperty<String, AbstractCommandNode> getUserCommandsProperty() {
		// TODO Auto-generated method stub
		return myUserCommands;
	}
	

	public void setLanguage(String language) {
		// TODO Auto-generated method stub
		myLanguage = language;
	}

	public ListProperty<String> getVariableListProperty() {
		// TODO Auto-generated method stub
		ListProperty<String> variables = new SimpleListProperty<String>();
		variables.get().addAll(myVariables.keySet());
		return variables;
		
	}

	public void setVariable(String name, Object value) {
		// TODO Auto-generated method stub
		myVariables.put(name, value);
	}

	public Object getVariable(String name) {
		// TODO Auto-generated method stub
		return myVariables.get(name);
	}
	
	 public void clearLines () {
	        // TODO Auto-generated method stub
	    	myLines.clear();
	  }


	    public List<Line> getLines () {
	        // TODO Auto-generated method stub
	        return myLines;
	    }	
	
	  public void addLine (Line l) {
		  myLines.add(l);
	  }

	


}
