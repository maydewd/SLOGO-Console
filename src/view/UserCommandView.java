package view;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import controller.IListDataController;
import controller.UserCommandController;
import javafx.beans.property.MapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

	private ObservableList<UserCommand> commandOL;



	public UserCommandView(IBasicModel model){
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myModel = model;
		initialize();
	}


	private void initialize(){
		commandMapProperty = myModel.definedCommandsProperty();
		myController = new UserCommandController(this, myModel);

		userCommandTable = new TableView();
		userCommandTable.setPrefSize(getWidth(), getHeight());

		commandOL = FXCollections.observableArrayList();

		TableColumn<UserCommand, String> variableName = new TableColumn<>("Command");

		variableName.setCellValueFactory(new PropertyValueFactory<>("command"));

		userCommandTable.getColumns().add(variableName);

		this.setNode(userCommandTable);
	}

	@Override
	public void setOLData(ObservableList newList) {
		commandOL.clear();
		commandOL.addAll(newList);
		userCommandTable.setItems(commandOL);
	}
}
