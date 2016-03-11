package view;

import java.io.File;
import controller.IParserController;
import controller.ParserController;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.IAdvancedModel;

import model.IBasicModel;

public class FileSelector extends Selector {
    private Menu myFileSelector;
    private UIManagerTabInterface myManager;
    private IParserController myParser;

    public FileSelector (HostServices hostServices, IAdvancedModel model, BaseUIView parent, UIManagerTabInterface uiManager) {
        myFileSelector = new Menu("File");
        myFileSelector.getItems().addAll(makeNew(model, hostServices), makeOpen(model), makeSave(model));
        myManager = uiManager;
        myParser= new ParserController(model, parent);
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
                                    myManager.addTab(file);
                                 }
                             }
                         }
        );
        return open;
    }
    
    public MenuItem makeNew(IBasicModel model, HostServices hostServices){
        MenuItem newButton = new MenuItem("New");
        newButton.setOnAction(e -> myManager.addTab());
        return newButton;
    }
}
