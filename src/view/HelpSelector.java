package view;

import javafx.application.HostServices;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;


public class HelpSelector extends Selector {
    public static final String HELP_PAGE_1 =
            "https://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands.php";
    public static final String HELP_PAGE_2 =
            "https://www.cs.duke.edu/courses/compsci308/spring16/assign/03_slogo/commands2_J2W.php";
    private Menu myHelpSelector;

    public HelpSelector (HostServices hostServices) {
        myHelpSelector = new Menu("Help");
        MenuItem help = new MenuItem("Initial Commands");
        help.setOnAction(e -> hostServices.showDocument(HELP_PAGE_1));
        MenuItem help2 = new MenuItem("Advanced Commands");
        help2.setOnAction(e -> hostServices.showDocument(HELP_PAGE_2));
        myHelpSelector.getItems().addAll(help, help2);
    }

    @Override
    public Menu getMenu () {
        return myHelpSelector;
    }

}
