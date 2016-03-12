package app;

import javafx.application.HostServices;
import javafx.stage.Stage;
import model.AdvancedModelManager;
import model.IAdvancedModel;
import model.IAdvancedModelManager;
import model.IBasicModel;
import model.SLogoAdvancedModel;
import model.SLogoBasicModel;
import view.UIManager;


/**
 * Created by Tim on 18/02/16.
 */
public class SLogoEngine {

    private UIManager uiManager;
   
    public void start (Stage stage, HostServices hostServices) {
        IAdvancedModelManager basicModel = new AdvancedModelManager();
        uiManager = new UIManager(stage, basicModel, hostServices);
    }
}
