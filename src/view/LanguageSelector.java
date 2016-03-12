package view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.IBasicModel;


public class LanguageSelector extends Selector {
    private Menu myLanguageSettings;

    public LanguageSelector (IBasicModel basicModel) {
        myLanguageSettings = new Menu("Language");
        for (int i = 0; i < basicModel.languageOptionsProperty().getSize(); i++) {
            MenuItem button = new MenuItem(basicModel.languageOptionsProperty().get(i));
            int index = i;
            button.setOnAction(e -> basicModel.setActiveLanguageIndex(index));
            myLanguageSettings.getItems().add(button);
        }
    }

    @Override
    public Menu getMenu () {
        return myLanguageSettings;
    }

}
