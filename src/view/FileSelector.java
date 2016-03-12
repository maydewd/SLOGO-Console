package view;

import java.io.File;
import java.io.FileNotFoundException;
import controller.IParserController;
import controller.ParserController;
import controller.configurations.FileManager;
import controller.parser.ParsingException;
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
    private FileManager myVarMeth;
    private BaseUIView errors;

    public FileSelector (HostServices hostServices, IAdvancedModel model, BaseUIView parent, UIManagerTabInterface uiManager) {
        myFileSelector = new Menu("File");
        myFileSelector.getItems().addAll(makeNew(model, hostServices), makeOpen(model), makeSave(model), makeExport(model), makeImport(model));
        myManager = uiManager;
        errors = parent;
        myParser= new ParserController(model, errors);
        myVarMeth = new FileManager(model);
    }

    private MenuItem makeExport (IAdvancedModel model) {
        MenuItem export = new MenuItem("Export Methods and Variables");
        export.setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent e) {
                                 FileChooser fileChooser = new FileChooser();
                                 File file = fileChooser.showSaveDialog(new Stage());
                                 if (file != null) {
                                    try {
                                        myVarMeth.save(file);
                                    }
                                    catch (FileNotFoundException | ParsingException e1) {
                                        errors.showError(e1.toString());
                                    }
                                 }
                             }
                         }
        );
        return export;
    }
    
    private MenuItem makeImport (IAdvancedModel model) {
        MenuItem export = new MenuItem("Import Methods and Variables");
        export.setOnAction(
                         new EventHandler<ActionEvent>() {
                             @Override
                             public void handle(final ActionEvent e) {
                                 FileChooser fileChooser = new FileChooser();
                                 File file = fileChooser.showOpenDialog(new Stage());
                                 if (file != null) {
                                    try {
                                        myVarMeth.load(file);
                                    }
                                    catch (FileNotFoundException e1) {
                                       errors.showError(e1.toString());
                                    }
                                 }
                             }
                         }
        );
        return export;
    }

    public Menu getMenu (){
        return myFileSelector;
    }
    
    public MenuItem makeSave(IBasicModel model){
        MenuItem save = new MenuItem("Save Workspace Preferences");
        
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
        MenuItem open = new MenuItem("Load Workspace From XML");
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
        MenuItem newButton = new MenuItem("New Workspace");
        newButton.setOnAction(e -> myManager.addTab());
        return newButton;
    }
}
