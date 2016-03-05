package view;

import controller.IListDataController;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.IBasicModel;


/**
 * Created by Tim on 01/03/16.
 */
public abstract class UIListView extends BaseUIView {

    public static final int DEFAULT_HEIGHT = 200;
    public static final int DEFAULT_WIDTH = 200;
    public static final double TITLE_SIZE = 14;

    private String TITLE_STRING;

    private Pane uiPane;
    private ListView<String> listView;

    private ObservableList<String> myObservableList;
    public UIListView (IBasicModel model, String title, ObservableList<String> listToWatch) {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        this.TITLE_STRING = title;
        this.myObservableList = listToWatch;

        init();
    }

    private void init () {
        uiPane = new VBox();
        Label listLabel = new Label(TITLE_STRING);
        listLabel.setFont(new Font(TITLE_SIZE));
        listView = new ListView<>();
        listView.setPrefSize(getWidth(), getHeight());
        listView.setItems(myObservableList);
        uiPane.getChildren().addAll(listLabel, listView);
        setNode(uiPane);
    }

}
