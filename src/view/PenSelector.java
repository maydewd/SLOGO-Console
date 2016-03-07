package view;

import javafx.scene.control.Menu;
import model.IAdvancedModel;
import model.IBasicModel;

public class PenSelector extends Selector{
    private Menu penSettings;

    public PenSelector (IAdvancedModel iModel) {
        penSettings = new Menu("Pen Settings");
        Selector penColor = new PenColorSelector(iModel);
        Selector lineThickness = new LineThicknessSelector(iModel);
        Selector lineType = new LineTypeSelector(iModel);
        Selector penDown = new PenDownSelector(iModel);
        penSettings.getItems().addAll(penColor.getMenu(), lineThickness.getMenu(), lineType.getMenu(), penDown.getMenu());
    }

    @Override
    public Menu getMenu () {
        return penSettings;
    }

}
