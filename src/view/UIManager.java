package view;

import java.io.File;
import javafx.application.HostServices;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.IAdvancedModel;
import model.IAdvancedModelManager;

/**
 * Created by Tim on 22/02/16.
 */
public class UIManager implements UIManagerTabInterface{

    public static final double DEFAULT_SPACING = 10;
    public static final double DEFAULT_X_SIZE = 400;
    public static final double DEFAULT_Y_SIZE = 400;

    private Stage myStage;
    private Group myGroup;
    private Scene mySceneView;
    private IAdvancedModel myModel;
    private IAdvancedModelManager myManager;
    private HostServices myHostServices;
    private TabPane myTabs;
    
    private int counter = 1;

    public UIManager(Stage primaryStage, IAdvancedModelManager model, HostServices hostServices){
        // Init vars
        myStage = primaryStage;
        myGroup = new Group();
        mySceneView = new Scene(myGroup);
        myStage.setScene(mySceneView);
        myManager = model;
        myModel = model;
        myHostServices = hostServices;
        
        myTabs = new TabPane();
        Tab main = new Tab("WorkSpace " + counter);
        main.setOnSelectionChanged(e -> myManager.switchToWorkspace(0));
        counter++;
        myTabs.getTabs().addAll(main);
        main.setContent(buildSubView());

        myGroup.getChildren().add(myTabs);
        setupInput();
        myStage.show();
    }

    private Pane buildSubView(){
        // Create the views
        BaseUIView myTurtleView = new TurtleView(myModel);
        BaseUIView myConsoleView = new ConsoleView(myModel);
        BaseUIView mySettingsMenu = new SettingsView(myModel, myHostServices, this);
        BaseUIView myVariableView = new VariableView(myModel);
        BaseUIView myCommandHistoryView = new CommandHistoryView(myModel);
        BaseUIView myUserCommandListView = new UserCommandView(myModel);

        // Initialize Pane
        HBox myPaneContainer = new HBox(0);
        VBox myMainPane = new VBox(DEFAULT_SPACING);
        myMainPane.getChildren().addAll(mySettingsMenu.getNode(),
                                                         myTurtleView.getNode(),
                                                         myConsoleView.getNode());

        Accordion mySidePane = new Accordion();
        mySidePane.getPanes().addAll(  new TitledPane("Variables", myVariableView.getNode()),
                                     new TitledPane("Command History", myCommandHistoryView.getNode()),
                                        new TitledPane("User Commands", myUserCommandListView.getNode()));
        mySidePane.setExpandedPane(mySidePane.getPanes().get(0));
        myPaneContainer.getChildren().addAll(myMainPane, mySidePane);
        
        return myPaneContainer;
    }
    
    
    public Stage getStage(){
        return myStage;
    }

    private void setupInput(){
//      Quit the program if you press ESCAPE
//      Helpful for debugging.
        this.myStage.getScene().setOnKeyPressed(event -> {
                if(event.getCode().equals(KeyCode.ESCAPE)){
                    System.exit(0);
                }
        });
    }


    @Override
    public void addTab (File settings) {
        myManager.loadNewWorkspace(settings);
        Tab tab = new Tab("Workspace " + counter);
        int index = counter - 1;
        counter++;
        tab.setContent(buildSubView());
        tab.setOnSelectionChanged(e -> myManager.switchToWorkspace(index));
        myTabs.getTabs().add(tab);
    }


    @Override
    public void addTab () {
        myManager.createNewWorkspace();
        Tab tab = new Tab("Workspace " + counter);
        int index = counter - 1;
        counter++;
        tab.setContent(buildSubView());
        tab.setOnSelectionChanged(e -> myManager.switchToWorkspace(index));
        myTabs.getTabs().add(tab);
    }
}
