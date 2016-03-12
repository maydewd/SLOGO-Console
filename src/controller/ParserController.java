package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import controller.configurations.XMLParser;
import controller.configurations.XMLWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.IAdvancedModel;
import model.RGBColor;
import view.BaseUIView;


public class ParserController implements IParserController {

    private IAdvancedModel myModel;
    private XMLParser myParser;
    private BaseUIView errorHandler;

    public ParserController (IAdvancedModel model, BaseUIView view) {
        myModel = model;
        errorHandler = view;
    }

    @Override
    public void saveWorkspace (File file) {
        myParser = new XMLWriter(file, getPreferences());
        try {
            myParser.parse();
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            errorHandler.showError(e.getMessage());
        }
    }

    public Map<String, Object> getPreferences () {
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("background-color", myModel.getActiveBackgroundColorIndex().get());
        prefs.put("image-list", myModel.turtleImageOptionsProperty().get());
        prefs.put("turtle-count", myModel.getAllTurtleInfo().size());
        prefs.put("language", myModel.getActiveLanguageIndex().get());
        prefs.put("palette", FXCollections.observableArrayList(new ArrayList<String>()));
        for (RGBColor c : myModel.colorOptionsProperty().get().values()) {
            ((ObservableList<String>) prefs.get("palette")).add(c.toString());
        }
        return prefs;
    }

}
