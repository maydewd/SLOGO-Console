package model;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import javafx.beans.property.ReadOnlyListProperty;

public interface IAdvancedModel extends IBasicModel {

    void addSelectedTurtle (int IDnumber);

    void clearSelectedTurtles ();
    
    List<Integer> getAllTurtleIDs ();

    List<Integer> getSelectedTurtleIDs ();

    List<Double> getLineThicknesses ();
    
    void setSelectedLineThickness (int i);

    List<Entry<Double, Double>> getLineTypeValues ();

    void setSelectedLineType (int i);
    
    ReadOnlyListProperty<StampInfo> getStamps ();

    void drawStamp ();

    void clearStamps ();

    int getActiveTurtleID ();

	Collection<? extends TurtleInfo> getAllTurtleInfo();
	
	TurtleInfo getTurtle (int id);
    

	AdvancedOptionsModel getMyOptionsModel();
	
	

}

