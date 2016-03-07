package view;

import java.io.File;
import app.Main;
import controller.IParserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileSelector extends Selector {
    private Menu fileSelector;

    public FileSelector (IParserController parse) {
        fileSelector = new Menu("File");
        MenuItem save = new MenuItem("Save");
        save.setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent e) {
                                 FileChooser fileChooser = new FileChooser();
                                 File file = fileChooser.showSaveDialog(new Stage());
                                 if (file != null) {
                                    parse.saveWorkspace(file); 
                                 }
                         }
                         }
        );
        
        MenuItem open = new MenuItem("Load");
        open.setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent e) {
                                 FileChooser fileChooser = new FileChooser();
                                 File file = fileChooser.showOpenDialog(new Stage());
                                 if (file != null) {
                                    parse.loadWorkspace(file);
                                 }
                             }
                         }
        );
        
        MenuItem newButton = new MenuItem("new");
        newButton.setOnAction(e -> Main.main(null));
        
        fileSelector.getItems().addAll(newButton, open, save);
    }

    @Override
    public Menu getMenu () {
        return fileSelector;
    }

}
