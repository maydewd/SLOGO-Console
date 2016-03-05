package view;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.IBasicModel;

public class BackgroundColorSelector extends Selector {

    private int RADIUS = 20;
    private Menu backgroundSettings;
    
    public BackgroundColorSelector (IBasicModel basicModel) {
        backgroundSettings = new Menu("Background Color");
        for(int i = 0; i < basicModel.colorOptionsProperty().getSize(); i++){
            makeButton(i, basicModel);
        }
    }

    public void makeButton (int i, IBasicModel basicModel) {
        CustomMenuItem button = new CustomMenuItem();
        Circle fill = new Circle();
        fill.setRadius(RADIUS);
        fill.setFill(Color.rgb(basicModel.colorOptionsProperty().get(i).getRed(),
                               basicModel.colorOptionsProperty().get(i).getGreen(),
                               basicModel.colorOptionsProperty().get(i).getBlue()));
        button.setContent(fill);
        int index = i;
        button.setOnAction(e -> basicModel.setActiveBackgroundColorIndex(index));
        getMenu().getItems().add(button);
    }

    @Override
    public Menu getMenu () {
        return backgroundSettings;
    }

}
