package view;

import java.io.File;
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
import model.IBasicModel;

public class FileSelector extends Selector {
    private Menu myFileSelector;
    private IParserController myParser;

    public FileSelector (HostServices hostServices, IBasicModel model, BaseUIView parent) {
        myFileSelector = new Menu("File");
        myParser = new ParserController(model, parent);
        myFileSelector.getItems().addAll(makeNew(model, hostServices), makeOpen(model), makeSave(model));
    }

    public Menu getMenu (){
        return myFileSelector;
    }
    
    public MenuItem makeSave(IBasicModel model){
        MenuItem save = new MenuItem("Save");
         
        save.setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent e) {
                                 FileChooser fileChooser = new FileChooser();
                                 File file = fileChooser.showSaveDialog(new Stage());
                                 if (file != null) {
                                    myParser.saveWorkspace(file); 
                                 }
                             }
                         }
        );
        return save;
    }
    
    
    public MenuItem makeOpen(IBasicModel model){
        MenuItem open = new MenuItem("Load");
        open.setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent e) {
                                 FileChooser fileChooser = new FileChooser();
                                 File file = fileChooser.showOpenDialog(new Stage());
                                 if (file != null) {
                                    myParser.loadWorkspace(file);
                                 }
                             }
                         }
        );
        return open;
    }
    
    public MenuItem makeNew(IBasicModel model, HostServices hostServices){
        MenuItem newButton = new MenuItem("New");
        SLogoEngine newGame = new SLogoEngine();
        newButton.setOnAction(e -> newGame.start(new Stage(), hostServices));
        return newButton;
    }
}
