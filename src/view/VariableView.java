package view;

import controller.IListDataController;
import controller.VariableViewController;
import javafx.beans.property.MapProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
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
public class VariableView extends BaseUIView {

	public static final int DEFAULT_HEIGHT = 200;
	public static final int DEFAULT_WIDTH = 200;


	private MapProperty<String, Double> variableProperty;

	private IBasicModel myModel;
	private TableView variableTable;
	private IListDataController myController;

	private ObservableList<Double> varValueOL;
	private ObservableList<String> varNameOL;


	public VariableView(IBasicModel model){
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myModel = model;
		initialize();
	}

	public VariableView(int width, int height, IBasicModel model){
		super(width, height);
		myModel = model;
		initialize();
	}

	private void initialize(){
		variableProperty = myModel.variableMapProperty();
		myController = new VariableViewController(this, myModel);

		variableTable = new TableView();
		variableTable.setPrefSize(getWidth(), getHeight());

		TableColumn<Variable, String> variableName = new TableColumn<>("Name");
		TableColumn<Variable, Double> variableValue = new TableColumn<>("Value");

		variableName.setCellValueFactory(new PropertyValueFactory<>("name"));
		variableValue.setCellValueFactory(new PropertyValueFactory<>("value"));

		variableTable.getColumns().addAll(variableName, variableValue);

		this.setNode(variableTable);
	}

}
