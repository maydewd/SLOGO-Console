package app;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Tim on 18/02/16.
 */
public class SLogoEngine {

    private Stage mainStage;

    public void init(Stage stage){
        mainStage = stage;
        Group g = new Group();
        Scene s = new Scene(g, 100, 100);
        stage.setScene(s);
    }

    public void start(){
        mainStage.show();
    }
}
