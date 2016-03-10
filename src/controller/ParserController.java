package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import controller.configurations.XMLParser;
import controller.configurations.XMLReader;
import controller.configurations.XMLWriter;
import javafx.collections.ObservableList;
import model.IBasicModel;
import model.Turtle;
import view.BaseUIView;

public class ParserController implements IParserController {

	private IBasicModel myModel;
	private XMLParser myParser;
	
	public ParserController(IBasicModel model) {
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
		System.out.println(prefs.get("background-color"));
		System.out.println(prefs.get("turtle-count"));
		System.out.println(prefs.get("image-list").toString());
		System.out.println(prefs.get("language"));
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
