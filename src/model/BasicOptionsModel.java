package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.commands.AbstractExpressionNode;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;


public class BasicOptionsModel {

    private static final String[] LANGUAGE_OPTIONS =
            { "English", "Chinese", "French", "German", "Italian", "Portuguese", "Russian",
              "Spanish" };
    private static final RGBColor[] INITIAL_COLORS =
            { new RGBColor(255, 255, 255), new RGBColor(0, 0, 0), new RGBColor(255, 0, 0) };
    // TODO add initial images
    private static final String[] INITIAL_IMAGES = {"blackturtle.png"};


    private MapProperty<String, Double> myVariableMap = new SimpleMapProperty<String, Double>(FXCollections.observableHashMap());
    private MapProperty<String, List<String>> myDefinedCommands =
            new SimpleMapProperty<String, List<String>>(FXCollections.observableHashMap());
    private Map<String, AbstractExpressionNode> myUserCommandsBodies =
            new HashMap<String, AbstractExpressionNode>();
    private ListProperty<String> myCommandHistoryProperty = new SimpleListProperty<String>(FXCollections.observableArrayList());
    private MapProperty<Integer, RGBColor> myColorOptionsProperty = new SimpleMapProperty<Integer, RGBColor>(FXCollections.observableHashMap());
    private ListProperty<String> myImageOptionsProperty = new SimpleListProperty<String>(FXCollections.observableArrayList());
    private ReadOnlyListProperty<String> myLanguageOptionsProperty;
    private IntegerProperty myActiveLanguageIndex = new SimpleIntegerProperty(0);

    public BasicOptionsModel () {
        initialize();
    }
    
    public BasicOptionsModel (List<String> imageFiles) {
        initializeLanguageOptions();
        initializeColors();
        initializeTurtleImages(imageFiles);
    }

    private void initialize () {
        initializeLanguageOptions();
        initializeColors();
        initializeTurtleImages();
    }

    private void initializeLanguageOptions () {
    	ObservableList<String> langs = FXCollections.observableArrayList(Arrays.asList(LANGUAGE_OPTIONS));
        ListProperty<String> languageOptions = new SimpleListProperty<String>(langs);
        myLanguageOptionsProperty = languageOptions;
    }

    private void initializeColors () {
        for (int i = 0; i < INITIAL_COLORS.length; i++) {
            colorOptionsProperty().put(i, INITIAL_COLORS[i]);
        }
    }

    private void initializeTurtleImages () {
    	ObservableList<String> imgs = FXCollections.observableArrayList(Arrays.asList(INITIAL_IMAGES));
        turtleImageOptionsProperty().addAll(imgs);
    }
    
    private void initializeTurtleImages (List<String> imageFiles) {
        turtleImageOptionsProperty().addAll(imageFiles);
    }

    public MapProperty<String, Double> variableMapProperty () {
        return myVariableMap;
    }

    public MapProperty<String, List<String>> definedCommandsProperty () {
        return myDefinedCommands;
    }

    public Map<String, AbstractExpressionNode> userCommandsBodies () {
        return myUserCommandsBodies;
    }

    public ListProperty<String> commandHistoryProperty () {
        return myCommandHistoryProperty;
    }

    public ReadOnlyListProperty<String> languageOptionsProperty () {
        return myLanguageOptionsProperty;
    }

    public ReadOnlyIntegerProperty getActiveLanguageIndex () {
        return myActiveLanguageIndex;
    }

    public void setActiveLanguageIndex (int languageIndex) {
        if (languageIndex >= languageOptionsProperty().size()) {
            throw new IndexOutOfBoundsException();
        }
        myActiveLanguageIndex.set(languageIndex);
    }

    public MapProperty<Integer, RGBColor> colorOptionsProperty () {
        return myColorOptionsProperty;
    }

    public ListProperty<String> turtleImageOptionsProperty () {
        return myImageOptionsProperty;
    }

}
