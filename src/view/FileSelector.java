package view;

import java.io.File;
import app.Main;
import app.SLogoEngine;
import controller.IParserController;
import controller.ParserController;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileSelector extends Selector {
    private Menu myFileSelector;

    public FileSelector (HostServices hostServices) {
        myFileSelector = new Menu("File");
        MenuItem save = new MenuItem("Save");
        IParserController parse = new ParserController();
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
        
        MenuItem newButton = new MenuItem("New");
        SLogoEngine newGame = new SLogoEngine();
        newButton.setOnAction(e -> newGame.start(new Stage(), hostServices));
        
        myFileSelector.getItems().addAll(newButton, open, save);
    }

    @Override
    public Menu getMenu () {
        return myFileSelector;
    }

}
