package app;

import javafx.stage.Stage;
import model.IBasicModel;
import model.SLogoBasicModel;
import view.UIManager;


/**
 * Created by Tim on 18/02/16.
 */
public class SLogoEngine {

    private UIManager uiManager;

    public void start (Stage stage) {
        IBasicModel basicModel = new SLogoBasicModel();
        uiManager = new UIManager(stage, basicModel);
    }
}
