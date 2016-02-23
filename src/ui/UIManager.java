package ui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Tim on 22/02/16.
 */
public class UIManager {

    public static final double DEFAULT_SPACING = 10;
    public static final double DEFAULT_X_SIZE = 600;
    public static final double DEFAULT_Y_SIZE = 400;


    private UITurtleView turtleView;
//    private UIConsoleView consoleView;
//    private UICommandHistoryView commandHistoryView;
//    private UIUserCommandListView userCommandListView;
//    private UISettingsMenu settingsMenu;
//    private UIErrorNotifier errorNotifier;

    private Pane myMainPaneNamedDane;
    private Stage stage;
    private Group group;
    private Scene uiSceneView;

    public UIManager(Stage primaryStage){
        // Init vars
        stage = primaryStage;
        group = new Group();
        uiSceneView = new Scene(group, DEFAULT_X_SIZE, DEFAULT_Y_SIZE);
        stage.setScene(uiSceneView);

        // Create the views
        turtleView = new UITurtleView();

        // Initialize Pane
        myMainPaneNamedDane = new VBox(DEFAULT_SPACING);
        myMainPaneNamedDane.getChildren().addAll(turtleView.getNode());

        stage.show();
    }
}
