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
public class VariableView extends BaseListView {

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
        myModel.variableMapProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated (Observable observable) {
                items.clear();
                items.addAll(myModel.variableMapProperty().entrySet());
            }
        });

        tableView = new TableView<Entry<String, Double>>(items);
        tableView.setPrefSize(getWidth(), getHeight());

        TableColumn<Entry<String, Double>, String> variableName = new TableColumn<>("Name");
        variableName
                .setCellValueFactory(entry -> new SimpleStringProperty(entry.getValue().getKey()));

        TableColumn<Entry<String, Double>, Double> variableValue = new TableColumn<>("Value");
        variableValue.setCellValueFactory(entry -> new SimpleObjectProperty<Double>(entry.getValue()
                .getValue()));

        tableView.getColumns().add(variableName);
        tableView.getColumns().add(variableValue);

        this.setNode(tableView);
    }

    @Override
    public void setOLData (ObservableList newList) {
        // TODO needs to be removed in hierarchy (leaving for timothy)

    }

}
