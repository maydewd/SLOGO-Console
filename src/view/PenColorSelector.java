package view;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.IBasicModel;

public class PenColorSelector extends ColorSelector{

    private Menu penColorSettings;
    
    public PenColorSelector (IBasicModel basicModel) {
        penColorSettings = new Menu("Pen Color");
        for(int i = 0; i < basicModel.colorOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    @Override
    public Menu getMenu () {
        return penColorSettings;
    }

    @Override
    public void addButton (CustomMenuItem button, int i, IBasicModel basicModel) {
        button.setOnAction(e -> basicModel.setActivePenColorIndex(i));
        getMenu().getItems().add(button);
    }

    
}
