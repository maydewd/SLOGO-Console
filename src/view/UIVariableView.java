package view;

import controller.VariableViewController;
import javafx.beans.property.MapProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.IBasicModel;
import model.Variable;

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
	private VariableViewController myController;

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
		variableProperty = myModel.variableMapProperty();
		myController = new VariableViewController(this, myModel);

		TableView variableTable = new TableView();

		TableColumn<Variable, String> variableName = new TableColumn<>("Name");
		TableColumn<Variable, Double> variableValue = new TableColumn<>("Value");

		variableName.setCellValueFactory(new PropertyValueFactory<>("name"));
		variableValue.setCellValueFactory(new PropertyValueFactory<>("value"));

		variableProperty = myModel.variableMapProperty();

		updateView();

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
