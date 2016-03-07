package view;

import javafx.scene.control.Menu;
import model.IBasicModel;

public class PenSelector extends Selector{
    private Menu penSettings;

    public PenSelector (IBasicModel basicModel) {
        penSettings = new Menu("Pen Settings");
        Selector penColor = new PenColorSelector(basicModel);
        penSettings.getItems().add(penColor.getMenu());
    }

    @Override
    public Menu getMenu () {
        return penSettings;
    }

}
