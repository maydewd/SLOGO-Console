package app;

import javafx.stage.Stage;
import model.IBasicModel;
import model.SLogoBasicModel;
import ui.UIManager;


/**
 * Created by Tim on 18/02/16.
 */
public class SLogoEngine {

    private UIManager uiManager;

    public void start (Stage stage) {
        IBasicModel basicModel = new SLogoBasicModel();
        // TODO pass this model to UIManager
        uiManager = new UIManager(stage, basicModel);

    }
}
