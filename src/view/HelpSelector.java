package view;

import javafx.application.HostServices;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class HelpSelector extends Selector {
    public static final String HELP_PAGE = "https://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands.php";
    private Menu myHelpSelector;

    public HelpSelector (HostServices hostServices) {
        myHelpSelector = new Menu("Help");
        MenuItem help = new MenuItem("Get Help");
        help.setOnAction(e -> hostServices.showDocument(HELP_PAGE));
        myHelpSelector.getItems().addAll(help);
    }
    
    @Override
    public Menu getMenu () {
        return myHelpSelector;
    }

}
