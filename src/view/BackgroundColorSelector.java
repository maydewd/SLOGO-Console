package view;

import javafx.scene.control.CustomMenuItem;
import model.IBasicModel;

public class BackgroundColorSelector extends ColorSelector {
    
    public BackgroundColorSelector (IBasicModel basicModel) {
        super(basicModel);
        getMenu().setText("Background Color");
    }

    @Override
    public void addButton (CustomMenuItem button, int index, IBasicModel basicModel) {
        button.setOnAction(e -> basicModel.setActiveBackgroundColorIndex(index));
        getMenu().getItems().add(button);
    }

}
