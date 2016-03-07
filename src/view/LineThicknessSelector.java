package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.IAdvancedModel;
import model.IBasicModel;

public class LineThicknessSelector extends Selector{
    private Menu thicknessSelector;

    public LineThicknessSelector (IAdvancedModel model) {
        thicknessSelector = new Menu("Line Thickness");
        for(int i = 0; i < model.getLineThicknesses().size(); i++){
            makeButton(i, model);
        }
    }

    private void makeButton (int i, IAdvancedModel model) {
        MenuItem button = new MenuItem(String.valueOf(model.getLineThicknesses().get(i)));
        button.setOnAction(e -> model.setSelectedLineThickness(i));
    }

    @Override
    public Menu getMenu () {
        return thicknessSelector;
    }

}
