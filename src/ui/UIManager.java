package ui;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by Tim on 22/02/16.
 */
public class UIManager {

    public static final double DEFAULT_SPACING = 10;
    public static final double DEFAULT_X_SIZE = 600;
    public static final double DEFAULT_Y_SIZE = 400;


    private UITurtleView turtleView;
    private UIConsoleView consoleView;
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
        uiSceneView = new Scene(group);
        stage.setScene(uiSceneView);

        // Create the views
        turtleView = new UITurtleView(this);
        consoleView = new UIConsoleView(this);

        // Initialize Pane
        myMainPaneNamedDane = new VBox(DEFAULT_SPACING);
        myMainPaneNamedDane.getChildren().addAll(turtleView.getNode(), consoleView.getNode());

        group.getChildren().add(myMainPaneNamedDane);

        setupInput();
        stage.show();
    }

    /**
     * This method for debugging only
     //TODO: Remove this method
     * @param command
     */
    public void debugPostNewCommand(String command){
        System.out.println(command);
    }

    private void setupInput(){
//      Quit the program if you press ESCAPE
//      Helpful for debugging.
        this.stage.getScene().setOnKeyPressed(event -> {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                    System.exit(0);
                }
        });
    }
}
