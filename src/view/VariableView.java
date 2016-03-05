package view;

import java.util.Map.Entry;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.IBasicModel;


/**
 * Created by Tim on 29/02/16.
 */
public class VariableView extends BaseUIView {

    public static final int DEFAULT_HEIGHT = 100;
    public static final int DEFAULT_WIDTH = 200;

    private TableView<Entry<String, Double>> tableView;
    private IBasicModel myModel;

    public VariableView (IBasicModel model) {
        super(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        myModel = model;
        initialize();
    }

    private void initialize () {
        ObservableList<Entry<String, Double>> items =
                FXCollections.observableArrayList(myModel.variableMapProperty().entrySet());
        // can't use lambda here since addListener uses overloading.
        myModel.variableMapProperty().addListener(createInvalidationListener(items));

        tableView = new TableView<Entry<String, Double>>(items);
        tableView.setPrefSize(getWidth(), getHeight());

        TableColumn<Entry<String, Double>, String> varName = new TableColumn<>("Name");
        varName.setCellValueFactory(entry -> new SimpleStringProperty(entry.getValue().getKey()));

        TableColumn<Entry<String, Double>, Double> varValue = new TableColumn<>("Value");
        varValue.setCellValueFactory(entry -> new SimpleObjectProperty<Double>(entry.getValue()
                .getValue()));

        tableView.getColumns().add(varName);
        tableView.getColumns().add(varValue);

        setNode(tableView);
    }

    private InvalidationListener createInvalidationListener (ObservableList<Entry<String, Double>> items) {
        return new InvalidationListener() {
            @Override
            public void invalidated (Observable observable) {
                items.clear();
                items.addAll(myModel.variableMapProperty().entrySet());
            }
        };
    }

}
