package view;

import javafx.scene.control.CustomMenuItem;
import model.IBasicModel;


public class PenColorSelector extends ColorSelector {

    public PenColorSelector (IBasicModel basicModel) {
        super(basicModel);
        getMenu().setText("Pen Color");
    }

    @Override
    public void addButton (CustomMenuItem button, int i, IBasicModel basicModel) {
        button.setOnAction(e -> basicModel.setPenColorIndex(i));
        getMenu().getItems().add(button);
    }

}
