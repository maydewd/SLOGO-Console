package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.IBasicModel;

public class LineThicknessSelector extends Selector{
    private Menu thicknessSelector;

    public LineThicknessSelector (IBasicModel basicModel) {
        thicknessSelector = new Menu("Line Thickness");
        for(int i = 0; i < basicModel.LineThicknessOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    private void makeButton (int i, IBasicModel basicModel) {
        MenuItem button = new MenuItem(basicModel.LineThicknesssOptionsProperty().get(i));
        button.setOnAction(e -> basicModel.setActiveLineThickness(i));
    }

    @Override
    public Menu getMenu () {
        return thicknessSelector;
    }

}
