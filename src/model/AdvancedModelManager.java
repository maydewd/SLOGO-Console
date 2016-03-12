package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import controller.commands.AbstractExpressionNode;
import controller.configurations.Configuration;
import controller.configurations.ConfigurationException;
import controller.configurations.XMLReader;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyListProperty;


public class AdvancedModelManager implements IAdvancedModelManager {

    private static final String DEFAULT_CONFIG_FILE = "resources/default.xml";

    private File defaultConfigFile;
    private IAdvancedModel myActiveModel;
    private List<IAdvancedModel> myModels = new ArrayList<>();

    public AdvancedModelManager () {
        defaultConfigFile =
                new File(getClass().getClassLoader().getResource(DEFAULT_CONFIG_FILE).getFile());
        createNewWorkspace();
    }

    @Override
    public void createNewWorkspace () {
        try {
            loadNewWorkspace(defaultConfigFile);
        }
        catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadNewWorkspace (File xmlConfigFile) throws ConfigurationException {
        XMLReader reader = new XMLReader();
        Configuration config;
        try {
            config = reader.parse(xmlConfigFile);
            IAdvancedModel newModel = new SLogoAdvancedModel(config);
            myModels.add(newModel);
            myActiveModel = newModel;
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ConfigurationException(e);
        }
    }

    @Override
    public void switchToWorkspace (int index) {
        myActiveModel = myModels.get(index);
    }

    @Override
    public void closeWorkspace (int index) {
        myModels.remove(index);
    }

    @Override
    public void addSelectedTurtle (int IDnumber) {
        myActiveModel.addSelectedTurtle(IDnumber);
    }

    @Override
    public void clearSelectedTurtles () {
        myActiveModel.clearSelectedTurtles();
    }

    @Override
    public List<Integer> getAllTurtleIDs () {
        return myActiveModel.getAllTurtleIDs();
    }

    @Override
    public List<Integer> getSelectedTurtleIDs () {
        return myActiveModel.getSelectedTurtleIDs();
    }

    @Override
    public List<LineThickness> getLineThicknesses () {
        return myActiveModel.getLineThicknesses();
    }

    @Override
    public void moveTurtleForward (double pixels) {
        myActiveModel.moveTurtleForward(pixels);
    }

    @Override
    public void setLineThickness (int index) {
        myActiveModel.setLineThickness(index);
    }

    @Override
    public void setTurtleCoordinates (Point newPoint) {
        myActiveModel.setTurtleCoordinates(newPoint);
    }

    @Override
    public void setLineThickness (double thickness) {
        myActiveModel.setLineThickness(thickness);
    }

    @Override
    public Point getTurtleCoordinates () {
        return myActiveModel.getTurtleCoordinates();
    }

    @Override
    public List<LineType> getLineTypeValues () {
        return myActiveModel.getLineTypeValues();
    }

    @Override
    public double getTurtleHeading () {
        return myActiveModel.getTurtleHeading();
    }

    @Override
    public void setLineType (int i) {
        myActiveModel.setLineType(i);
    }

    @Override
    public void setTurtleHeading (double heading) {
        myActiveModel.setTurtleHeading(heading);
    }

    @Override
    public ReadOnlyListProperty<StampInfo> getStamps () {
        return myActiveModel.getStamps();
    }

    @Override
    public void setPenDown (boolean penDown) {
        myActiveModel.setPenDown(penDown);
    }

    @Override
    public void drawStamp () {
        myActiveModel.drawStamp();
    }

    @Override
    public void clearStamps () {
        myActiveModel.clearStamps();
    }

    @Override
    public boolean getPenDown () {
        return myActiveModel.getPenDown();
    }

    @Override
    public int getActiveTurtleID () {
        return myActiveModel.getActiveTurtleID();
    }

    @Override
    public void setTurtleVisibility (boolean visible) {
        myActiveModel.setTurtleVisibility(visible);
    }

    @Override
    public Collection<? extends TurtleInfo> getAllTurtleInfo () {
        return myActiveModel.getAllTurtleInfo();
    }

    @Override
    public boolean getTurtleVisibility () {
        return myActiveModel.getTurtleVisibility();
    }

    @Override
    public TurtleInfo getTurtle (int id) {
        return myActiveModel.getTurtle(id);
    }

    @Override
    public AdvancedOptionsModel getMyOptionsModel () {
        return myActiveModel.getMyOptionsModel();
    }

    @Override
    public void clearLines () {
        myActiveModel.clearLines();
    }

    @Override
    public ReadOnlyListProperty<LineInfo> getLines () {
        return myActiveModel.getLines();
    }

    @Override
    public MapProperty<String, Double> variableMapProperty () {
        return myActiveModel.variableMapProperty();
    }

    @Override
    public MapProperty<String, List<String>> definedCommandsProperty () {
        return myActiveModel.definedCommandsProperty();
    }

    @Override
    public Map<String, AbstractExpressionNode> userCommandsBodies () {
        return myActiveModel.userCommandsBodies();
    }

    @Override
    public ListProperty<String> commandHistoryProperty () {
        return myActiveModel.commandHistoryProperty();
    }

    @Override
    public ReadOnlyListProperty<String> languageOptionsProperty () {
        return myActiveModel.languageOptionsProperty();
    }

    @Override
    public ReadOnlyIntegerProperty getActiveLanguageIndex () {
        return myActiveModel.getActiveLanguageIndex();
    }

    @Override
    public void setActiveLanguageIndex (int languageIndex) {
        myActiveModel.setActiveLanguageIndex(languageIndex);
    }

    @Override
    public MapProperty<Integer, RGBColor> colorOptionsProperty () {
        return myActiveModel.colorOptionsProperty();
    }

    @Override
    public ReadOnlyIntegerProperty getActiveBackgroundColorIndex () {
        return myActiveModel.getActiveBackgroundColorIndex();
    }

    @Override
    public void setActiveBackgroundColorIndex (int backgroundColorIndex) {
        myActiveModel.setActiveBackgroundColorIndex(backgroundColorIndex);
    }

    @Override
    public ReadOnlyIntegerProperty getPenColorIndex () {
        return myActiveModel.getPenColorIndex();
    }

    @Override
    public void setPenColorIndex (int penColorIndex) {
        myActiveModel.setPenColorIndex(penColorIndex);
    }

    @Override
    public ListProperty<String> turtleImageOptionsProperty () {
        return myActiveModel.turtleImageOptionsProperty();
    }

    @Override
    public ReadOnlyIntegerProperty getTurtleImageIndex () {
        return myActiveModel.getTurtleImageIndex();
    }

    @Override
    public void setTurtleImageIndex (int turtleImageIndex) {
        myActiveModel.setTurtleImageIndex(turtleImageIndex);
    }

    @Override
    public void addCoreTurtleObserver (Observer observer) {
        myActiveModel.addCoreTurtleObserver(observer);
    }

    @Override
    public Turtle getActiveTurtle () {
        return myActiveModel.getActiveTurtle();
    }

    @Override
    public void addTurtle (int id) {
        myActiveModel.addTurtle(id);
    }

}
