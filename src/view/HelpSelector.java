package view;

import javafx.application.HostServices;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class HelpSelector extends Selector {
    public static final String HELP_PAGE = "https://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands.php";
    private Menu helpSelector;

    public HelpSelector (HostServices hostServices) {
        helpSelector = new Menu("Help");
        MenuItem help = new MenuItem("Get Help");
        help.setOnAction(e -> hostServices.showDocument(HELP_PAGE));
        helpSelector.getItems().addAll(help);
    }
    
    @Override
    public Menu getMenu () {
        return helpSelector;
    }

}
