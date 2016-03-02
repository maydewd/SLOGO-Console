package controller;

import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import model.IBasicModel;
import view.UIView;

/**
 * Created by Tim on 01/03/16.
 */
public class CommandHistoryController implements IListDataController{

	private UIView myView;
	private IBasicModel myModel;
	ListProperty<String> commandHistoryProperty;

	public CommandHistoryController(UIView view, IBasicModel model){
		myView = view;
		myModel = model;

		initialize();
	}

	private void initialize(){
		commandHistoryProperty = myModel.commandHistoryProperty();
		commandHistoryProperty.addListener((observable, oldValue, newValue) -> {
			updateOLData();
		});
	}

	@Override
	public void initDataIntoOL() {
	}

	@Override
	public ObservableList getDataOL() {
		return commandHistoryProperty;
	}

	@Override
	public void updateOLData() {

	}
}
