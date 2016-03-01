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


public class BasicOptionsModel {

    private static final String[] LANGUAGE_OPTIONS =
            { "English", "Chinese", "French", "German", "Italian", "Portuguese", "Russian",
              "Spanish" };
    private static final RGBColor[] INITIAL_COLORS =
            { new RGBColor(0, 0, 0), new RGBColor(255, 255, 255), new RGBColor(255, 0, 0) };
    // TODO add initial images
    private static final String[] INITIAL_IMAGES = {};

    private MapProperty<String, Double> myVariableMap = new SimpleMapProperty<String, Double>();
    private MapProperty<String, List<String>> myDefinedCommands =
            new SimpleMapProperty<String, List<String>>();
    private Map<String, AbstractExpressionNode> myUserCommandsBodies =
            new HashMap<String, AbstractExpressionNode>();
    private ListProperty<String> myCommandHistoryProperty = new SimpleListProperty<String>();
    private ListProperty<RGBColor> myColorOptionsProperty = new SimpleListProperty<RGBColor>();
    private ListProperty<String> myImageOptionsProperty = new SimpleListProperty<String>();
    private ReadOnlyListProperty<String> myLanguageOptionsProperty;
    private IntegerProperty myActiveLanguageIndex = new SimpleIntegerProperty();

    public BasicOptionsModel () {
        initialize();
    }

    private void initialize () {
        initializeLanguageOptions();
        initializeColors();
        initializeTurtleImages();
    }

    private void initializeLanguageOptions () {
        ListProperty<String> languageOptions = new SimpleListProperty<String>();
        languageOptions.addAll(Arrays.asList(LANGUAGE_OPTIONS));
        myLanguageOptionsProperty = languageOptions;
    }

    private void initializeColors () {
        colorOptionsProperty().addAll(INITIAL_COLORS);
    }

    private void initializeTurtleImages () {
        turtleImageOptionsProperty().addAll(INITIAL_IMAGES);
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
            // TODO add message
            throw new IllegalArgumentException();
        }
        myActiveLanguageIndex.set(languageIndex);
    }

    public ListProperty<RGBColor> colorOptionsProperty () {
        return myColorOptionsProperty;
    }

    public ListProperty<String> turtleImageOptionsProperty () {
        return myImageOptionsProperty;
    }

}
