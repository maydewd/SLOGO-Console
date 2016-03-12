package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.IBasicModel;


public abstract class ColorSelector extends Selector {
    private final int RADIUS = 20;
    private Menu myMenu;

    public ColorSelector (IBasicModel basicModel) {
        myMenu = new Menu();
        initializeMenu(basicModel);
        createInvalidationListener(basicModel);
    }

    private void createInvalidationListener (IBasicModel basicModel) {
        basicModel.colorOptionsProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated (Observable o) {
                initializeMenu(basicModel);
            }
        });
    }

    private void initializeMenu (IBasicModel basicModel) {
        getMenu().getItems().clear();
        for (Integer key : basicModel.colorOptionsProperty().keySet()) {
            makeButton(key, basicModel);
        }
    }

    private void makeButton (int index, IBasicModel basicModel) {
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

    protected abstract void addButton (CustomMenuItem button, int i, IBasicModel basicModel);

    @Override
    public Menu getMenu () {
        return myMenu;
    }

}
