package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import controller.configurations.Configuration;
import javafx.beans.property.ReadOnlyListProperty;


public class SLogoAdvancedModel extends SLogoBasicModel implements IAdvancedModel {

    private AdvancedTurtleModel myTurtleModel = new AdvancedTurtleModel();
    private AdvancedOptionsModel myOptionsModel = new AdvancedOptionsModel();

    public SLogoAdvancedModel (Configuration config) {
        setMyTurtleModel(myTurtleModel);
        setMyOptionsModel(myOptionsModel);
        initializeBackground(config);
        initializeImageList(config);
        initializeTurtleCount(config);
        initializeLanguage(config);
    }

    private void initializeLanguage (Configuration config) {
        setActiveLanguageIndex(Integer.parseInt(config.getLanguageIndex()));
    }

    private void initializeTurtleCount (Configuration config) {
        for (int i = 0; i < Integer.parseInt(config.getTurtleCount()); i++) {
            getMyTurtleModel().selectTurtle(i + 1);
        }
    }

    private void initializeImageList (Configuration config) {
        // TODO Auto-generated method stub
        
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
        getMyTurtleModel().clearStamps();
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
        getMyTurtleModel().stampsProperty().clear();
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

}
