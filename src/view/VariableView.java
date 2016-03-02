package view;

import controller.VariableViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.IBasicModel;
import model.Variable;

/**
 * Created by Tim on 29/02/16.
 */
public class VariableView extends BaseListView {

	public static final int DEFAULT_HEIGHT = 100;
	public static final int DEFAULT_WIDTH = 200;


	private TableView<Variable> tableView;
	private IBasicModel myModel;
	private Pane uiNode;
	private VariableViewController myController;

	private ObservableList<Variable> variableOL;


	public VariableView(IBasicModel model){
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myModel = model;
		initialize();
	}

	private void initialize(){
		myController = new VariableViewController(this, myModel);

		tableView = new TableView();
		tableView.setPrefSize(getWidth(), getHeight());

		variableOL = FXCollections.observableArrayList();

		TableColumn<Variable, String> variableName = new TableColumn<>("Name");
		TableColumn<Variable, Double> variableValue = new TableColumn<>("Value");

		variableName.setCellValueFactory(new PropertyValueFactory<>("name"));
		variableValue.setCellValueFactory(new PropertyValueFactory<>("value"));

		tableView.getColumns().addAll(variableName, variableValue);
		tableView.setItems(variableOL);


		this.setNode(tableView);
	}

	@Override
	public void setOLData(ObservableList newList){
		variableOL.clear();
		variableOL.addAll(newList);
		tableView.setItems(variableOL);
	}



}
