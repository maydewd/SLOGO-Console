package view;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.IBasicModel;

public class PenColorSelector extends Selector{

    private int RADIUS = 20;
    private Menu penColorSettings;
    
    public PenColorSelector (IBasicModel basicModel) {
        penColorSettings = new Menu("Pen Color");
        for(int i = 0; i < basicModel.colorOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    
    
    public void makeButton(int index, IBasicModel basicModel){
        CustomMenuItem button = new CustomMenuItem();
        Circle fill = new Circle();
        fill.setRadius(RADIUS);
        fill.setFill(Color.rgb(basicModel.colorOptionsProperty().get(index).getRed(),
                               basicModel.colorOptionsProperty().get(index).getGreen(),
                               basicModel.colorOptionsProperty().get(index).getBlue()));
        button.setContent(fill);
        int i = index;
        button.setOnAction(e -> basicModel.setActivePenColorIndex(i));
        getMenu().getItems().add(button);
    }



    @Override
    public Menu getMenu () {
        return penColorSettings;
    }

    
}
