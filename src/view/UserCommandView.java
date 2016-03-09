package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.IAdvancedModel;
import model.IBasicModel;
import java.util.List;
import java.util.Map.Entry;


/**
 * Created by Tim on 01/03/16.
 */
public class UserCommandView extends BaseUIView {
    
    public static final int DEFAULT_HEIGHT = 200;
    public static final int DEFAULT_WIDTH = 200;

    private TableView<Entry<String, List<String>>> tableView = new TableView<Entry<String, List<String>>>();
    private IBasicModel myModel;

    public UserCommandView (IAdvancedModel model) {
        super(DEFAULT_HEIGHT, DEFAULT_WIDTH, model);
        myModel = model;
        initialize();
    }

    private void initialize () {
        ObservableList<Entry<String, List<String>>> items =
                FXCollections.observableArrayList(myModel.definedCommandsProperty().entrySet());
        myModel.definedCommandsProperty().addListener(createInvalidationListener(items));

        tableView.setItems(items);
        tableView.setPrefSize(getWidth(), getHeight());

        TableColumn<Entry<String, List<String>>, String> command = new TableColumn<>("Name");
        command.setCellValueFactory(entry -> new SimpleStringProperty(entry.getValue().getKey()));

        TableColumn<Entry<String, List<String>>, String> parameters =
                new TableColumn<>("Parameters");
        parameters.setCellValueFactory(entry -> new SimpleStringProperty(String
                .join(", ", entry.getValue().getValue())));

        tableView.getColumns().add(command);
        tableView.getColumns().add(parameters);
        
        setNode(tableView);
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
