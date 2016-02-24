package app;

import controller.FrontEndControllerInterface;
import javafx.stage.Stage;
import model.IBasicModel;
import model.SLogoBasicModel;
import view.UIManager;


/**
 * Created by Tim on 18/02/16.
 */
public class SLogoEngine {

    private UIManager uiManager;
    private FrontEndControllerInterface controller;

    public void start (Stage stage) {
        IBasicModel basicModel = new SLogoBasicModel();
        // TODO pass this model to UIManager
        uiManager = new UIManager(stage, controller);

    }
}
