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
public class VariableViewController {

	private IBasicModel myModel;
	private UIView variableView;

	private ObservableList<Variable> variableOL;
	private MapProperty<String, Double> variableMapProperty;
	private List<Variable> variableList;

	public VariableViewController(UIView varView, IBasicModel model) {
		this.variableView = varView;
		this.myModel = model;
		variableMapProperty = model.variableMapProperty();
		variableList = new ArrayList<>();
		variableOL = FXCollections.observableArrayList(variableList);

		// Set up binding between this observableList and property
		variableMapProperty.addListener(new ChangeListener<ObservableMap<String, Double>>() {
			@Override
			public void changed(ObservableValue<? extends ObservableMap<String, Double>> observable, ObservableMap<String, Double> oldValue, ObservableMap<String, Double> newValue) {
				updateVariableOL();
			}
		});
	}

	public ObservableList<Variable> getVariableOL(){
		return variableOL;
	}

	private void updateVariableOL() {
		for (String s : variableMapProperty.keySet()) {
			for (Variable v : variableOL) {
				if (v.getName().equals(s)) {
					v.setValue(variableMapProperty.get(s));
				}
			}
		}
	}

}
