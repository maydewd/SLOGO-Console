package view;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import model.IBasicModel;

public class BackgroundColorSelector extends ColorSelector {
    private Menu myBackgroundSettings;
    
    public BackgroundColorSelector (IBasicModel basicModel) {
        myBackgroundSettings = new Menu("Background Color");
        for(int i = 0; i < basicModel.colorOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    @Override
    public Menu getMenu () {
        return myBackgroundSettings;
    }

    @Override
    public void addButton (CustomMenuItem button, int index, IBasicModel basicModel) {
        button.setOnAction(e -> basicModel.setActiveBackgroundColorIndex(index));
        getMenu().getItems().add(button);
    }

}
