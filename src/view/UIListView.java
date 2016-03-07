package view;

import controller.ConsoleController;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.IBasicModel;


/**
 * Created by Tim on 01/03/16.
 */
public abstract class UIListView extends BaseUIView {

    public static final int DEFAULT_HEIGHT = 200;
    public static final int DEFAULT_WIDTH = 200;

    private ListView<String> listView = new ListView<>();

    private ObservableList<String> myObservableList;

    public UIListView (IBasicModel model, ObservableList<String> listToWatch) {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT, model);
        this.myObservableList = listToWatch;

        init();
        setNode(listView);
    }

    private void init () {
        listView.setPrefSize(getWidth(), getHeight());
        listView.setItems(myObservableList);

        listView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2){
                ConsoleController.getController()
                        .executeCommand(listView.getSelectionModel().getSelectedItem());
            }
        });
    }

}
