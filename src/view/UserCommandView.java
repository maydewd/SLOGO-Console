package view;

import controller.IListDataController;
import controller.UserCommandController;
import javafx.beans.property.MapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.IBasicModel;
import model.UserCommand;

import java.util.List;

/**
 * Created by Tim on 01/03/16.
 */
public class UserCommandView extends BaseListView {

	public final static int DEFAULT_WIDTH = 200;
	public final static int DEFAULT_HEIGHT = 200;

	private MapProperty<String, List<String>> commandMapProperty;

	private IBasicModel myModel;
	private TableView userCommandTable;
	private IListDataController myController;
	private Pane uiNode;

	private ObservableList<UserCommand> commandOL;



	public UserCommandView(IBasicModel model){
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myModel = model;
		initialize();
	}


	private void initialize(){
		commandMapProperty = myModel.definedCommandsProperty();
		myController = new UserCommandController(this, myModel);

		Label paneTitle = new Label("User-Defined Commands");
		paneTitle.setFont(new Font(TITLE_SIZE));

		uiNode = new VBox();
		userCommandTable = new TableView();
		userCommandTable.setPrefSize(getWidth(), getHeight());

		commandOL = FXCollections.observableArrayList();

		TableColumn<UserCommand, String> variableName = new TableColumn<>("Command");
		variableName.setCellValueFactory(new PropertyValueFactory<>("command"));
		userCommandTable.getColumns().add(variableName);

		uiNode.getChildren().addAll(paneTitle, userCommandTable);

		this.setNode(uiNode);
	}

	@Override
	public void setOLData(ObservableList newList) {
		commandOL.clear();
		commandOL.addAll(newList);
		userCommandTable.setItems(commandOL);
	}
}
