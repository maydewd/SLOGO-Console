package controller;

import javafx.beans.property.MapProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import model.IBasicModel;
import model.Variable;
import view.UIView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 01/03/16.
 */
public class VariableViewController implements IListDataController{

	private IBasicModel myModel;
	private UIView variableView;

	private ObservableList<Variable> variableOL;
	private MapProperty<String, Double> variableMapProperty;
	private List<Variable> variableList;

	public VariableViewController(UIView varView, IBasicModel model) {
		this.variableView = varView;
		this.myModel = model;
	}

	@Override
	public void initDataIntoOL() {
		variableMapProperty = myModel.variableMapProperty();
		variableList = new ArrayList<>();
		variableOL = FXCollections.observableArrayList(variableList);

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

	@Override
	public ObservableList getDataOL() {
		return variableOL;
	}

}
