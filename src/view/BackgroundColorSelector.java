package view;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.IBasicModel;

public class BackgroundColorSelector extends ColorSelector {

    private int RADIUS = 20;
    private Menu backgroundSettings;
    
    public BackgroundColorSelector (IBasicModel basicModel) {
        backgroundSettings = new Menu("Background Color");
        for(int i = 0; i < basicModel.colorOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    @Override
    public Menu getMenu () {
        return backgroundSettings;
    }

    @Override
    public void addButton (CustomMenuItem button, int index, IBasicModel basicModel) {
        button.setOnAction(e -> basicModel.setActiveBackgroundColorIndex(index));
        getMenu().getItems().add(button);
    }

}
