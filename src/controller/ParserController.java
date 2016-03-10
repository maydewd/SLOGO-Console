package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import controller.preferences.XMLParser;
import controller.preferences.XMLReader;
import controller.preferences.XMLWriter;
import javafx.collections.ObservableList;
import model.IAdvancedModel;
import model.Turtle;

public class ParserController implements IParserController {

	private IAdvancedModel myModel;
	private XMLParser myParser;
	
	public ParserController(IAdvancedModel model) {
		myModel = model;
	}
	
    @Override
    public void saveWorkspace (File file) {
    	myParser = new XMLWriter(file, getPreferences());
		myParser.parse();
    }

    @Override
    public void loadWorkspace (File file) {
    	HashMap<String, Object> prefs = new HashMap<String, Object>();
		myParser = new XMLReader(file, prefs);
		myParser.parse();
		myModel.setActiveBackgroundColorIndex(Integer.valueOf((String) (prefs.get("background-color"))));
		myModel.turtleImageOptionsProperty().set((ObservableList<String>) (prefs.get("image-list")));
		for (int i=1; i <= Integer.valueOf((String) (prefs.get("turtle-count"))); i++) {
			myModel.getAllTurtleInfo().add(new Turtle(i));
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
