package controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.MapProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import model.IBasicModel;
import model.Variable;
import view.BaseListView;
import view.UIView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 01/03/16.
 */
public class VariableViewController implements IListDataController{

	private IBasicModel myModel;
	private BaseListView variableView;

	private ObservableList<Variable> variableOL;
	private MapProperty<String, Double> variableMapProperty;
	private List<Variable> variableList;

	public VariableViewController(BaseListView varView, IBasicModel model) {
		this.variableView = varView;
		this.myModel = model;
		initDataIntoOL();
	}

	@Override
	public void initDataIntoOL() {
		variableMapProperty = myModel.variableMapProperty();
		variableList = new ArrayList<>();
		variableOL = FXCollections.observableArrayList(variableList);

		// Set up binding between this observableList and property
		myModel.variableMapProperty().addListener(new MapChangeListener<String, Double>() {
			@Override
			public void onChanged(Change<? extends String, ? extends Double> change) {
				updateOLData();
			}
		});
	}

	@Override
	public void updateOLData() {
		variableOL.clear();
		for (String s : variableMapProperty.keySet()) {
			Variable newV = new Variable(s, variableMapProperty.get(s));
			variableOL.add(newV);
		}

		variableView.setOLData(variableOL);
	}


}
