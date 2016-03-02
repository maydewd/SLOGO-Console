package controller;

import javafx.beans.property.MapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.IBasicModel;
import model.Variable;
import view.UIView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 01/03/16.
 */
public class UserCommandController implements IListDataController {

	private IBasicModel myModel;
	private UIView userCommandView;

	private ObservableList<Variable> variableOL;
	private MapProperty<String, Double> variableMapProperty;
	private List<Variable> userCommandList;

	public UserCommandController(UIView varView, IBasicModel model) {
		this.userCommandView = varView;
		this.myModel = model;
	}

	@Override
	public void initDataIntoOL() {
		variableMapProperty = myModel.variableMapProperty();
		userCommandList = new ArrayList<>();
		variableOL = FXCollections.observableArrayList(userCommandList);

		// Set up binding between this observableList and property
		variableMapProperty.addListener((observable, oldValue, newValue) -> {
			updateOLData();
		});
	}

	@Override
	public void updateOLData() {
		for (String s : variableMapProperty.keySet()) {
			for (Variable v : variableOL) {
				if (v.getName().equals(s)) {
					v.setValue(variableMapProperty.get(s));
				}
			}
		}
	}


}
