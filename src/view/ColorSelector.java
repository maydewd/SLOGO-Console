package view;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.IBasicModel;

public abstract class ColorSelector extends Selector {
    private final int RADIUS = 20;
    
    public void makeButton(int index, IBasicModel basicModel){
        CustomMenuItem button = new CustomMenuItem();
        Pane organize = new Pane();
        organize.setPrefSize(RADIUS * 2.5, RADIUS * 2.5);
        Circle fill = new Circle();
        fill.setRadius(RADIUS);
        fill.setFill(Color.rgb(basicModel.colorOptionsProperty().get(index).getRed(),
                               basicModel.colorOptionsProperty().get(index).getGreen(),
                               basicModel.colorOptionsProperty().get(index).getBlue()));
        fill.relocate(RADIUS * .5, RADIUS * .5);
        Text text = new Text();
        text.setText(String.valueOf(index));
        text.relocate(0, RADIUS);
        organize.getChildren().addAll(text, fill);
        button.setContent(organize);
        int i = index;
        addButton(button, i, basicModel);
    }
    
    public abstract void addButton(CustomMenuItem button, int i, IBasicModel basicModel);

}
