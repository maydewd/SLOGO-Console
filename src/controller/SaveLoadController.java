package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import controller.configurations.XMLParser;
import controller.configurations.XMLReader;
import controller.configurations.XMLWriter;
import model.IBasicModel;
import view.BaseUIView;

public class SaveLoadController {
	private IBasicModel myModel;
	private BaseUIView myView;
	private XMLParser myParser;
	
	private SaveLoadController(IBasicModel model, BaseUIView view) {
		myModel = model;
		myView = view;
	}
	
	public void save(File f) {
		myParser = new XMLWriter(f, getPreferences());
		myParser.parse();
	}
	
	public void load(File f) {
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		myParser = new XMLReader(f, prefs);
		myParser.parse();
		myModel.setActiveBackgroundColorIndex(Integer.getInteger((String) prefs.get("background-color")));
		myModel.setImageList((ArrayList<String>) prefs.get("image-list"));
		myModel.setTurtleCount(prefs.get("turtle-count"));
		myModel.setActiveLanguageIndex(Integer.getInteger((String) prefs.get("language")));	
	}
	
	public Map<String, Object> getPreferences() {
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("background-color", myModel.getActiveBackgroundColorIndex());
		prefs.put("image-list", myModel.getImageList());
		prefs.put("turtle-count", myModel.getTurtleCount());
		prefs.put("language", myModel.getActiveLanguageIndex());
		return prefs;
	}
	
}
