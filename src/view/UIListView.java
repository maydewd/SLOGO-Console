package view;

import controller.CommandHistoryController;
import controller.IListDataController;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.IBasicModel;

/**
 * Created by Tim on 01/03/16.
 */
public abstract class UIListView extends BaseUIView{

	public static final int DEFAULT_HEIGHT = 200;
	public static final int DEFAULT_WIDTH = 200;
	public static final double TITLE_SIZE = 14;

	private String TITLE_STRING;


	private Pane uiPane;
	private javafx.scene.control.ListView<String> listView;

	private ObservableList observableList;
	private IBasicModel myModel;
	private IListDataController controller;

	public UIListView(IBasicModel model, String title, ObservableList listToWatch){
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myModel = model;
		this.TITLE_STRING = title;
		this.observableList = listToWatch;

		init();
	}

	private void init() {
		uiPane = new VBox();
		Label listLabel = new Label(TITLE_STRING);
		listLabel.setFont(new Font(TITLE_SIZE));
		listView = new javafx.scene.control.ListView<>();
		listView.setPrefSize(getWidth(), getHeight());
		controller = new CommandHistoryController(this, myModel);

		listView.setItems(observableList);
		listView.setCellFactory((javafx.scene.control.ListView<String> l) -> new ListCell<>());

		uiPane.getChildren().addAll(listLabel, listView);
		setNode(uiPane);
	}


}
