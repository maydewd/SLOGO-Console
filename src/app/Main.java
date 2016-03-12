package app;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;


/**
 * Created by Tim on 18/02/16.
 */
public class Main extends Application {

    public static void main (String[] args) {
        Application.launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception {
        SLogoEngine engine = new SLogoEngine();

        engine.start(primaryStage, getHostServices());
    }

    public HostServices getHost () {
        return getHostServices();
    }
}
