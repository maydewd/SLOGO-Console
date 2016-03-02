package view;

import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.IBasicModel;

/**
 * Created by Tim on 22/02/16.
 */
public class UIManager {

    public static final double DEFAULT_SPACING = 10;
    public static final double DEFAULT_X_SIZE = 400;
    public static final double DEFAULT_Y_SIZE = 400;

    private TurtleView turtleView;
    private ConsoleView consoleView;
    private CommandHistoryView commandHistoryView;
    private UserCommandView userCommandListView;
    private SettingsView settingsMenu;
    private ErrorNotifier errorNotifier;
    private VariableView variableView;

    private Pane myMainPaneNamedDane;
    private Pane sidePane;
    private Pane paneContainer;

    private Stage stage;
    private Group group;
    private Scene uiSceneView;
	private IBasicModel myModel;

    public UIManager(Stage primaryStage, IBasicModel b, HostServices hostServices){
        // Init vars
        stage = primaryStage;
        group = new Group();
        uiSceneView = new Scene(group);
        stage.setScene(uiSceneView);
	    myModel = b;

        // Create the views
        turtleView = new TurtleView(b);
        consoleView = new ConsoleView(this, myModel);
        settingsMenu = new SettingsView(b, hostServices);
        variableView = new VariableView(myModel);

        commandHistoryView = new CommandHistoryView(myModel, "Command History", myModel.commandHistoryProperty());
        userCommandListView = new UserCommandView(myModel);

        // Initialize Pane
        paneContainer = new HBox(0);
        myMainPaneNamedDane = new VBox(DEFAULT_SPACING);
        myMainPaneNamedDane.getChildren().addAll(settingsMenu.getNode(),
		                                         turtleView.getNode(),
		                                         consoleView.getNode());

        sidePane = new VBox(DEFAULT_SPACING);
        sidePane.getChildren().addAll(  variableView.getNode(),
                                        commandHistoryView.getNode(),
                                        userCommandListView.getNode());
        paneContainer.getChildren().addAll(myMainPaneNamedDane, sidePane);

        group.getChildren().add(paneContainer);

        setupInput();
        stage.show();
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
