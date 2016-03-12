package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.IAdvancedModel;

public class LineThicknessSelector extends Selector{
    private Menu myThicknessSelector;

    public LineThicknessSelector (IAdvancedModel model) {
        myThicknessSelector = new Menu("Line Thickness");
        for(int i = 0; i < model.getLineThicknesses().size(); i++){
            makeButton(i, model);
        }
    }

    private void makeButton (int i, IAdvancedModel model) {
        MenuItem button = new MenuItem(model.getLineThicknesses().get(i).toString());
        button.setOnAction(e -> model.setLineThickness(i));
        getMenu().getItems().add(button);
    }

    @Override
    public Menu getMenu () {
        return myThicknessSelector;
    }

}
