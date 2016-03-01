package view;

import javafx.beans.property.MapProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.IBasicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tim on 29/02/16.
 */
public class UIVariableView extends BaseUIView {

	public static final int DEFAULT_HEIGHT = 100;
	public static final int DEFAULT_WIDTH = 200;


	private MapProperty<String, Double> variableProperty;
	private ListView varNameListView;
	private ListView varValueListView;
	private IBasicModel myModel;
	private Pane uiNode;

	private ObservableList<Double> varValueOL;
	private ObservableList<String> varNameOL;


	public UIVariableView(IBasicModel model){
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myModel = model;
		initialize();
	}

	public UIVariableView(int width, int height, IBasicModel model){
		super(width, height);
		myModel = model;
		initialize();
	}

	private void initialize(){
		variableProperty = myModel.getVariableMapProperty();
		variableProperty.addListener(new ChangeListener<ObservableMap<String, Double>>() {
			@Override
			public void changed(ObservableValue<? extends ObservableMap<String, Double>> observable, ObservableMap<String, Double> oldValue, ObservableMap<String, Double> newValue) {
				varValueOL.clear();
				varNameOL.clear();
				for (String s: newValue.keySet()){
					varNameOL.add(s);
					varValueOL.add(newValue.get(s));
				}
			}
		});
		uiNode = new VBox();
		Pane varListPaneContainer = new HBox();
		Label varListLabel = new Label("Variable List");


		// Initialize var display UI
		List<String> variableNames = new ArrayList<>();
		List<Double> variableValues = new ArrayList<>();

		varValueOL = FXCollections.observableList(variableValues);
		varNameOL = FXCollections.observableList(variableNames);

		varNameListView = new ListView<>(varNameOL);
		varValueListView = new ListView<>(varValueOL);
		varNameListView.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		varValueListView.setPrefSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		updateView();

		// Populate Pane containers and return correct Node
		varListPaneContainer.getChildren().addAll(varNameListView, varValueListView);
		uiNode.getChildren().addAll(varListLabel, varListPaneContainer);
		this.setNode(uiNode);
	}


	private void updateView(){
		// Populate UI
		for (String s: variableProperty.keySet()) {
			varNameOL.add(s);
			varValueOL.add(variableProperty.get(s));
		}
	}



}
