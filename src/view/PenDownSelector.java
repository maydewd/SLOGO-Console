package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.IBasicModel;


public class PenDownSelector extends Selector {
    private Menu myPenDownSelector;

    public PenDownSelector (IBasicModel model) {
        myPenDownSelector = new Menu("Pen Up or Down");
        MenuItem up = new MenuItem("Lift Pen");
        up.setOnAction(e -> model.setPenDown(false));

        MenuItem down = new MenuItem("Set Down Pen");
        down.setOnAction(e -> model.setPenDown(true));

        myPenDownSelector.getItems().addAll(up, down);
    }

    @Override
    public Menu getMenu () {
        return myPenDownSelector;
    }

}
