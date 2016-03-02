package controller;

import javafx.beans.property.MapProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import model.IBasicModel;
import model.UserCommand;
import view.BaseListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 01/03/16.
 */
public class UserCommandController implements IListDataController {

	private IBasicModel myModel;
	private BaseListView userCommandView;

	private ObservableList<UserCommand> userCommandOL;
	private MapProperty<String, List<String>> userCommandProperty;
	private List<UserCommand> userCommandList;

	public UserCommandController(BaseListView varView, IBasicModel model) {
		this.userCommandView = varView;
		this.myModel = model;
		initDataIntoOL();
	}

	@Override
	public void initDataIntoOL() {
		userCommandProperty = myModel.definedCommandsProperty();
		userCommandList = new ArrayList<>();
		userCommandOL = FXCollections.observableArrayList(userCommandList);

		// Set up binding between this observableList and property
		myModel.definedCommandsProperty().addListener((MapChangeListener<String, List<String>>) change -> {
			updateOLData();
		});
	}

	@Override
	public void updateOLData() {
		for (String s : userCommandProperty.keySet()) {
			UserCommand newCommand = new UserCommand(s, userCommandProperty.get(s));
			userCommandOL.add(newCommand);
		}

		userCommandView.setOLData(userCommandOL);
	}


}
