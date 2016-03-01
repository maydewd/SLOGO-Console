package view;

import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.IBasicModel;

/**
 * Created by Tim on 01/03/16.
 */
public class UICommandHistoryView extends BaseUIView {

	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGHT = 100;


	private Pane uiPane;
	private ListView listView;

	private IBasicModel myModel;

	public UICommandHistoryView(IBasicModel model){
		super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		myModel = model;
		init();
	}

	public UICommandHistoryView(int width, int height, IBasicModel model) {
		super(width, height);
		myModel = model;
		init();
	}

	private void init() {
		uiPane = new VBox();

	}


}
