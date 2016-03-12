package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import model.IBasicModel;

public class TurtleSelector extends Selector {
    private Menu turtleSettings;

    public TurtleSelector (IBasicModel basicModel) {
        turtleSettings = new Menu("Turtle Selector");
        initializeMenu(basicModel);
        createInvalidationListener(basicModel);
    }

    private void createInvalidationListener (IBasicModel basicModel) {
        basicModel.turtleImageOptionsProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated (Observable o) {
                initializeMenu(basicModel);
            }
        });
    }
    
    private void initializeMenu (IBasicModel basicModel) {
        getMenu().getItems().clear();
        for (int i=0; i < basicModel.turtleImageOptionsProperty().getSize(); i++) {
            makeButton(i, basicModel);
        }
    }

    
    public void makeButton (int index, IBasicModel basicModel) {
        MenuItem button = new MenuItem(String.valueOf(index));
        button.setGraphic(new ImageView(basicModel.turtleImageOptionsProperty().get(index)));
        int i = index;
        button.setOnAction(e -> basicModel.setTurtleImageIndex(i));
        getMenu().getItems().add(button);
    }

    @Override
    public Menu getMenu () {
        return turtleSettings;
    }

}
