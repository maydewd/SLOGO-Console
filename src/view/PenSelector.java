package view;

import javafx.scene.control.Menu;
import model.IAdvancedModel;

public class PenSelector extends Selector{
    private Menu myPenSettings;

    public PenSelector (IAdvancedModel iModel) {
        myPenSettings = new Menu("Pen Settings");
        Selector penColor = new PenColorSelector(iModel);
        Selector lineThickness = new LineThicknessSelector(iModel);
        Selector lineType = new LineTypeSelector(iModel);
        Selector penDown = new PenDownSelector(iModel);
        myPenSettings.getItems().addAll(penColor.getMenu(), lineThickness.getMenu(), lineType.getMenu(), penDown.getMenu());
    }

    @Override
    public Menu getMenu () {
        return myPenSettings;
    }

}
