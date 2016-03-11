package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import controller.commands.AbstractExpressionNode;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyListProperty;


public class AdvancedModelManager implements IAdvancedModelManager {
    
    private static final String DEFAULT_CONFIG_FILE = "default.xml";

    private File defaultConfigFile;
    private IAdvancedModel myActiveModel;
    private List<IAdvancedModel> myModels = new ArrayList<>();

    public AdvancedModelManager () {
        try {
            defaultConfigFile = new File(getClass().getClassLoader().getResource(DEFAULT_CONFIG_FILE).toURI());
        }
        catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createNewWorkspace () {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadNewWorkspace (File xmlConfigFile) {
        // TODO Auto-generated method stub

    }

    @Override
    public void switchToWorkspace (int index) {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeWorkspace (int index) {
        // TODO Auto-generated method stub

    }

    public void addSelectedTurtle (int IDnumber) {
        myActiveModel.addSelectedTurtle(IDnumber);
    }

    public void clearSelectedTurtles () {
        myActiveModel.clearSelectedTurtles();
    }

    public List<Integer> getAllTurtleIDs () {
        return myActiveModel.getAllTurtleIDs();
    }

    public List<Integer> getSelectedTurtleIDs () {
        return myActiveModel.getSelectedTurtleIDs();
    }

    public List<LineThickness> getLineThicknesses () {
        return myActiveModel.getLineThicknesses();
    }

    public void moveTurtleForward (double pixels) {
        myActiveModel.moveTurtleForward(pixels);
    }

    public void setLineThickness (int index) {
        myActiveModel.setLineThickness(index);
    }

    public void setTurtleCoordinates (Point newPoint) {
        myActiveModel.setTurtleCoordinates(newPoint);
    }

    public void setLineThickness (double thickness) {
        myActiveModel.setLineThickness(thickness);
    }

    public Point getTurtleCoordinates () {
        return myActiveModel.getTurtleCoordinates();
    }

    public List<LineType> getLineTypeValues () {
        return myActiveModel.getLineTypeValues();
    }

    public double getTurtleHeading () {
        return myActiveModel.getTurtleHeading();
    }

    public void setLineType (int i) {
        myActiveModel.setLineType(i);
    }

    public void setTurtleHeading (double heading) {
        myActiveModel.setTurtleHeading(heading);
    }

    public ReadOnlyListProperty<StampInfo> getStamps () {
        return myActiveModel.getStamps();
    }

    public void setPenDown (boolean penDown) {
        myActiveModel.setPenDown(penDown);
    }

    public void drawStamp () {
        myActiveModel.drawStamp();
    }

    public void clearStamps () {
        myActiveModel.clearStamps();
    }

    public boolean getPenDown () {
        return myActiveModel.getPenDown();
    }

    public int getActiveTurtleID () {
        return myActiveModel.getActiveTurtleID();
    }

    public void setTurtleVisibility (boolean visible) {
        myActiveModel.setTurtleVisibility(visible);
    }

    public Collection<? extends TurtleInfo> getAllTurtleInfo () {
        return myActiveModel.getAllTurtleInfo();
    }

    public boolean getTurtleVisibility () {
        return myActiveModel.getTurtleVisibility();
    }

    public TurtleInfo getTurtle (int id) {
        return myActiveModel.getTurtle(id);
    }

    public AdvancedOptionsModel getMyOptionsModel () {
        return myActiveModel.getMyOptionsModel();
    }

    public void clearLines () {
        myActiveModel.clearLines();
    }

    public ReadOnlyListProperty<LineInfo> getLines () {
        return myActiveModel.getLines();
    }

    public MapProperty<String, Double> variableMapProperty () {
        return myActiveModel.variableMapProperty();
    }

    public MapProperty<String, List<String>> definedCommandsProperty () {
        return myActiveModel.definedCommandsProperty();
    }

    public Map<String, AbstractExpressionNode> userCommandsBodies () {
        return myActiveModel.userCommandsBodies();
    }

    public ListProperty<String> commandHistoryProperty () {
        return myActiveModel.commandHistoryProperty();
    }

    public ReadOnlyListProperty<String> languageOptionsProperty () {
        return myActiveModel.languageOptionsProperty();
    }

    public ReadOnlyIntegerProperty getActiveLanguageIndex () {
        return myActiveModel.getActiveLanguageIndex();
    }

    public void setActiveLanguageIndex (int languageIndex) {
        myActiveModel.setActiveLanguageIndex(languageIndex);
    }

    public MapProperty<Integer, RGBColor> colorOptionsProperty () {
        return myActiveModel.colorOptionsProperty();
    }

    public ReadOnlyIntegerProperty getActiveBackgroundColorIndex () {
        return myActiveModel.getActiveBackgroundColorIndex();
    }

    public void setActiveBackgroundColorIndex (int backgroundColorIndex) {
        myActiveModel.setActiveBackgroundColorIndex(backgroundColorIndex);
    }

    public ReadOnlyIntegerProperty getPenColorIndex () {
        return myActiveModel.getPenColorIndex();
    }

    public void setPenColorIndex (int penColorIndex) {
        myActiveModel.setPenColorIndex(penColorIndex);
    }

    public ListProperty<String> turtleImageOptionsProperty () {
        return myActiveModel.turtleImageOptionsProperty();
    }

    public ReadOnlyIntegerProperty getTurtleImageIndex () {
        return myActiveModel.getTurtleImageIndex();
    }

    public void setTurtleImageIndex (int turtleImageIndex) {
        myActiveModel.setTurtleImageIndex(turtleImageIndex);
    }

    public void addCoreTurtleObserver (Observer observer) {
        myActiveModel.addCoreTurtleObserver(observer);
    }

    public Turtle getActiveTurtle () {
        return myActiveModel.getActiveTurtle();
    }

}
