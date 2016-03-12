package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.IAdvancedModel;


public class LineTypeSelector extends Selector {
    private Menu myTypeSelector;

    public LineTypeSelector (IAdvancedModel model) {
        myTypeSelector = new Menu("Line Type");
        for (int i = 0; i < model.getLineTypeValues().size(); i++) {
            makeButton(i, model);
        }
    }

    private void makeButton (int i, IAdvancedModel model) {
        MenuItem button = new MenuItem(model.getLineTypeValues().get(i).toString());
        button.setOnAction(e -> model.setLineType(i));
        getMenu().getItems().add(button);
    }

    @Override
    public Menu getMenu () {
        return myTypeSelector;
    }

}
