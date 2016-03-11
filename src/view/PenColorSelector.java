package view;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import model.IBasicModel;

public class PenColorSelector extends ColorSelector{

    private Menu myPenColorSettings;
    
    public PenColorSelector (IBasicModel basicModel) {
        myPenColorSettings = new Menu("Pen Color");
        for(int i = 0; i < basicModel.colorOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    @Override
    public Menu getMenu () {
        return myPenColorSettings;
    }

    @Override
    public void addButton (CustomMenuItem button, int i, IBasicModel basicModel) {
        button.setOnAction(e -> basicModel.setPenColorIndex(i));
        getMenu().getItems().add(button);
    }

    
}
