package view;

import controller.IListDataController;
import controller.UserCommandController;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.IBasicModel;
import model.UserCommand;
import java.util.List;
import java.util.Map.Entry;


/**
 * Created by Tim on 01/03/16.
 */
public class UserCommandView extends BaseUIView {

    public final static int DEFAULT_WIDTH = 200;
    public final static int DEFAULT_HEIGHT = 200;

    private TableView<Entry<String, List<String>>> tableView;
    private IBasicModel myModel;

    public UserCommandView (IBasicModel model) {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myModel = model;
        initialize();
    }

    private void initialize () {
        ObservableList<Entry<String, List<String>>> items =
                FXCollections.observableArrayList(myModel.definedCommandsProperty().entrySet());
        myModel.definedCommandsProperty().addListener(createInvalidationListener(items));

        Label paneTitle = new Label("User-Defined Commands");
        paneTitle.setFont(new Font(TITLE_SIZE));

        tableView = new TableView<Entry<String, List<String>>>(items);
        tableView.setPrefSize(getWidth(), getHeight());

        TableColumn<Entry<String, List<String>>, String> command = new TableColumn<>("Name");
        command.setCellValueFactory(entry -> new SimpleStringProperty(entry.getValue().getKey()));

        TableColumn<Entry<String, List<String>>, String> parameters =
                new TableColumn<>("Parameters");
        parameters.setCellValueFactory(entry -> new SimpleStringProperty(String
                .join(", ", entry.getValue().getValue())));

        tableView.getColumns().add(command);
        tableView.getColumns().add(parameters);

        setNode(new Pane(tableView));
    }

    private InvalidationListener createInvalidationListener (ObservableList<Entry<String, List<String>>> items) {
        return new InvalidationListener() {
            @Override
            public void invalidated (Observable observable) {
                items.clear();
                items.addAll(myModel.definedCommandsProperty().entrySet());
            }
        };
    }

}
