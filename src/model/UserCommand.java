package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

/**
 * Created by Tim on 01/03/16.
 */
public class UserCommand {

	private StringProperty command;
	private ListProperty<String> parameterList;

	public UserCommand(){
		command = new SimpleStringProperty();
		parameterList = new SimpleListProperty<>();
	}

	public String getCommand(){
		return command.get();
	}

	public List<String> getParameterList(){
		return parameterList.getValue();
	}

	public void setCommand(String newCommand){
		this.command.set(newCommand);
	}

	public void setParameterList(List<String> parameterList){
		this.parameterList.setAll(parameterList);
	}

}
