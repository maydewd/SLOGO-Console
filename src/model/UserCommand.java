package model;

import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;


/**
 * Created by Tim on 01/03/16.
 */
public class UserCommand {

    private StringProperty command;
    private ListProperty<String> parameterList;

    public UserCommand (String s, List<String> list) {
        command = new SimpleStringProperty(s);
        parameterList = new SimpleListProperty<>();
        parameterList.set(FXCollections.observableList(list));
    }

    public String getCommand () {
        return command.get();
    }

    public List<String> getParameterList () {
        return parameterList.getValue();
    }

    public void setCommand (String newCommand) {
        command.set(newCommand);
    }

    public void setParameterList (List<String> parameterList) {
        this.parameterList.setAll(parameterList);
    }

}
