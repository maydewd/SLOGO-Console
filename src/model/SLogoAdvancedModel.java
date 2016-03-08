package model;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
<<<<<<< HEAD
import javafx.beans.property.MapProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleMapProperty;
=======
import javafx.beans.property.ReadOnlyListProperty;
>>>>>>> FrontEndExtentionPartOne

public class SLogoAdvancedModel extends SLogoBasicModel implements IAdvancedModel {
    private AdvancedTurtleModel myTurtleModel = new AdvancedTurtleModel();
    private AdvancedOptionsModel myOptionsModel = new AdvancedOptionsModel();

    public SLogoAdvancedModel () {
        setMyTurtleModel(myTurtleModel);

    }

    public AdvancedTurtleModel getMyTurtleModel () {
        return myTurtleModel;
    }

    public AdvancedOptionsModel getMyOptionsModel () {
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
    public List<Entry<Double, Double>> getLineTypes () {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void drawStamp () {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clearStamps () {
        // TODO Auto-generated method stub
        
    }

    public int getActiveTurtleID () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
<<<<<<< HEAD
=======
    public int getActiveTurtleID () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
>>>>>>> FrontEndExtentionPartOne
    public void setSelectedLineThickness (int i) {
        // TODO Auto-generated method stub
        
    }

    @Override
<<<<<<< HEAD

=======
>>>>>>> FrontEndExtentionPartOne
    public void setSelectedLineType (int i) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ReadOnlyListProperty<StampInfo> getStamps () {
        // TODO Auto-generated method stub
        return null;
<<<<<<< HEAD
=======
    }
    
    public void setSelectedLineThickness () {
        // TODO Auto-generated method stub
        
    }

    public void setSelectedLineType () {
        // TODO Auto-generated method stub
        
>>>>>>> FrontEndExtentionPartOne
    }


}
