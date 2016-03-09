package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.IAdvancedModel;

public class LineTypeSelector extends Selector {
    private Menu myTypeSelector;

    public LineTypeSelector (IAdvancedModel model) {
        myTypeSelector = new Menu("Line Type");
        for(int i = 0; i < model.getLineTypes().size(); i++){
            makeButton(i, model);
        }
    }

    private void makeButton (int i, IAdvancedModel model) {
        MenuItem button = new MenuItem(String.valueOf(model.getLineTypes().get(i)));
        button.setOnAction(e -> model.setSelectedLineType(i));
    }

    @Override
    public Menu getMenu () {
       return myTypeSelector;
    }

}
