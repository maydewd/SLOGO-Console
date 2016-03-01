package controller;

import javafx.beans.property.ListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.IBasicModel;

/**
 * Created by Tim on 01/03/16.
 */
public class CommandHistoryController {

	private IBasicModel myModel;
	ListProperty<String> commandHistoryProperty;

	public CommandHistoryController(IBasicModel model){
		myModel = model;
		commandHistoryProperty = myModel.commandHistoryProperty();
		commandHistoryProperty.addListener(new ChangeListener<ObservableList<String>>() {
			@Override
			public void changed(ObservableValue<? extends ObservableList<String>> observable,
			                    ObservableList<String> oldValue,
			                    ObservableList<String> newValue) {

			}
		});


		ListView commandHistory = new ListView();
	}
}
