package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import controller.configurations.Configuration;
import controller.configurations.FileManager;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;


public class SLogoAdvancedModel extends SLogoBasicModel implements IAdvancedModel {

	private final static String RESOURCES_FILE_PATH = "resources/";
    private AdvancedTurtleModel myTurtleModel = new AdvancedTurtleModel();
    private AdvancedOptionsModel myOptionsModel = new AdvancedOptionsModel();

    public SLogoAdvancedModel (Configuration config) throws FileNotFoundException {
        setMyTurtleModel(myTurtleModel);
        setMyOptionsModel(myOptionsModel);
        initializeBackground(config);
        initializeImageList(config);
        initializeTurtleCount(config);
        initializeLanguage(config);
        initializePalette(config);
        initializeCommandLibrary(config);
    }

    private void initializePalette(Configuration config) {
    	List<String> hexColors = config.getPaletteList();
    	ObservableMap<Integer, RGBColor> newPalette = FXCollections.observableHashMap();
    	
    	for (int i=0; i < hexColors.size(); i++) {
    		int red = Integer.parseInt(hexColors.get(i).substring(0,2),16);
    		int green = Integer.parseInt(hexColors.get(i).substring(2,4),16);
    		int blue = Integer.parseInt(hexColors.get(i).substring(4,6),16);
    		RGBColor rgbC = new RGBColor(red, green, blue);
    		newPalette.put(i, rgbC);
    	}
    	
    	getMyOptionsModel().colorOptionsProperty().set(newPalette);
		
	}

    private void initializeCommandLibrary(Configuration config) throws FileNotFoundException {
    	File f = new File(RESOURCES_FILE_PATH + config.getCommandLibrary());
    	FileManager fm = new FileManager(this);
    	fm.load(f);
    }
    
	private void initializeLanguage (Configuration config) {
        setActiveLanguageIndex(Integer.parseInt(config.getLanguageIndex()));
    }

    private void initializeTurtleCount (Configuration config) {
        for (int i = 1; i <= Integer.parseInt(config.getTurtleCount()); i++) {
        	addTurtle(i);
        }
    }

    private void initializeImageList (Configuration config) {
        getMyOptionsModel().turtleImageOptionsProperty().set(FXCollections.observableArrayList(config.getImageList()));
        
    }

    private void initializeBackground (Configuration config) {
        setActiveBackgroundColorIndex(Integer.parseInt(config.getBackgroundIndex()));
    }

    private AdvancedTurtleModel getMyTurtleModel () {
        return myTurtleModel;
    }

    public AdvancedOptionsModel getMyOptionsModel () {
        return myOptionsModel;
    }

    @Override
    public void addSelectedTurtle (int IDnumber) {
        getMyTurtleModel().selectTurtle(IDnumber);
    }

    @Override
    public void clearSelectedTurtles () {
        getMyTurtleModel().selectedTurtlesProperty().clear();
    }

    @Override
    public List<Integer> getSelectedTurtleIDs () {
        return new ArrayList<Integer>(getMyTurtleModel().selectedTurtlesProperty());
    }

    @Override
    public List<LineThickness> getLineThicknesses () {
        return getMyOptionsModel().lineThicknessOptionsProperty().get();
    }

    @Override
    public List<LineType> getLineTypeValues () {
        return getMyOptionsModel().lineTypeOptionsProperty().get();
    }

    @Override
    public void drawStamp () {
        getMyTurtleModel().drawStamp();

    }

    @Override
    public void clearStamps () {
        getMyTurtleModel().clearStamps();
    }

    @Override
    public int getActiveTurtleID () {
        return getMyTurtleModel().getActiveTurtle().getID();
    }

    @Override
    public void setLineThickness (int index) {
        double thickness =
                getMyOptionsModel().lineThicknessOptionsProperty().get(index).getMyThickness();
        getMyTurtleModel().setLineThickness(thickness);
    }

    @Override
    public void setLineThickness (double thickness) {
        getMyTurtleModel().setLineThickness(thickness);
    }

    @Override
    public void setLineType (int index) {
        LineType lineType =
                getMyOptionsModel().lineTypeOptionsProperty().get(index);
        getMyTurtleModel().setSelectedLineType(lineType);
    }

    @Override
    public ReadOnlyListProperty<StampInfo> getStamps () {
        return getMyTurtleModel().stampsProperty();
    }

    @Override
    public Collection<? extends TurtleInfo> getAllTurtleInfo () {
        return getMyTurtleModel().allTurtlesProperty().values();
    }

    @Override
    public TurtleInfo getTurtle (int id) {
        return getMyTurtleModel().allTurtlesProperty().get(id);
    }

    @Override
    public List<Integer> getAllTurtleIDs () {
        return new ArrayList<Integer>(getMyTurtleModel().allTurtlesProperty().keySet());
    }

	@Override
	public void addTurtle(int id) {
		if (!getMyTurtleModel().allTurtlesProperty().containsKey(id))
			getMyTurtleModel().allTurtlesProperty().put(id, new Turtle(id));
		
	}

}