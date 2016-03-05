package controller;

import javafx.beans.property.ListProperty;
import model.IBasicModel;
import view.BaseUIView;

/**
 * Created by Tim on 01/03/16.
 */
public class CommandHistoryController implements IListDataController{

	private BaseUIView myView;
	private IBasicModel myModel;
	ListProperty<String> commandHistoryProperty;

	public CommandHistoryController(BaseUIView view, IBasicModel model){
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
	public void updateOLData() {

	}
}
