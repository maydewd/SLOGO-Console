package app;

import javafx.application.HostServices;
import javafx.stage.Stage;
import model.AdvancedModelManager;
import model.IAdvancedModelManager;
import view.UIManager;


/**
 * Created by Tim on 18/02/16.
 */
public class SLogoEngine {

    public void start (Stage stage, HostServices hostServices) {
        IAdvancedModelManager basicModel = new AdvancedModelManager();
        new UIManager(stage, basicModel, hostServices);
    }
}
