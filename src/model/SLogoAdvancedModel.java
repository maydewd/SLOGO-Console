package model;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;

public class SLogoAdvancedModel extends SLogoBasicModel implements IAdvancedModel {
    private AdvancedTurtleModel myTurtleModel = new AdvancedTurtleModel();
    private AdvancedOptionsModel myOptionsModel = new AdvancedOptionsModel();

    public SLogoAdvancedModel () {
        setMyTurtleModel(myTurtleModel);

    }

    private AdvancedTurtleModel getMyTurtleModel () {
        return myTurtleModel;
    }

    private AdvancedOptionsModel getMyOptionsModel () {
        return myOptionsModel;
    }

    @Override
    public Collection<? extends TurtleInfo> getAllTurtleInfo () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addSelectedTurtles (int IDnumber) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clearSelectedTurtles () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Collection<Integer> getSelectedTurtleIDs () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Double> getLineThicknesses () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSelectedLineThickness () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Entry<Double, Double>> getLineTypes () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSelectedLineType () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void drawStamp () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clearStamps () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getActiveTurtleID () {
        // TODO Auto-generated method stub
        return 0;
    }


}
