package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import controller.configurations.XMLParser;
import controller.configurations.XMLReader;
import controller.configurations.XMLWriter;
import javafx.collections.ObservableList;
import model.Turtle;
import view.BaseUIView;
import model.IAdvancedModel;



public class ParserController implements IParserController {

	private IAdvancedModel myModel;
	private XMLParser myParser;
	private BaseUIView errorHandler;
	
	public ParserController(IAdvancedModel model, BaseUIView view) {
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

    @Override
    public void loadWorkspace (File file) {
    	HashMap<String, Object> prefs = new HashMap<String, Object>();
		myParser = new XMLReader(file, prefs);
		try {
            myParser.parse();
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            errorHandler.showError(e.getMessage());
        }
		myModel.setActiveBackgroundColorIndex(Integer.valueOf((String) (prefs.get("background-color"))));
		myModel.turtleImageOptionsProperty().set((ObservableList<String>) (prefs.get("image-list")));
		for (int i=1; i <= Integer.valueOf((String) (prefs.get("turtle-count"))); i++) {
			myModel.getMyTurtleModel().allTurtlesProperty().put(i, new Turtle(i));
		}
		myModel.setActiveLanguageIndex(Integer.valueOf((String) (prefs.get("language"))));	

    }
    
    public Map<String, Object> getPreferences() {
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("background-color", myModel.getActiveBackgroundColorIndex());
		prefs.put("image-list", myModel.turtleImageOptionsProperty().get());
		prefs.put("turtle-count", myModel.getAllTurtleInfo().size());
		prefs.put("language", myModel.getActiveLanguageIndex());
		return prefs;
	}

}
