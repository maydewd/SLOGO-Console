package app;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.UIManager;

/**
 * Created by Tim on 18/02/16.
 */
public class SLogoEngine {

    private UIManager uiManager;

    public void start(Stage stage){
        uiManager = new UIManager(stage);

    }
}
