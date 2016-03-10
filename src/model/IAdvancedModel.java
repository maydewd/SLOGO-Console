package model;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import javafx.beans.property.ReadOnlyListProperty;

public interface IAdvancedModel extends IBasicModel {

    void addSelectedTurtles (int IDnumber);

    void clearSelectedTurtles ();

    Collection<Integer> getSelectedTurtleIDs ();

    List<Double> getLineThicknesses ();
    
    void setSelectedLineThickness (int i);

    List<Entry<Double, Double>> getLineTypes ();

    void setSelectedLineType (int i);
    
    ReadOnlyListProperty<StampInfo> getStamps ();

    void drawStamp ();

    void clearStamps ();

    int getActiveTurtleID ();

	Collection<TurtleInfo> getAllTurtleInfo();
	
	TurtleInfo getTurtle (int id);

	AdvancedTurtleModel getMyTurtleModel();
    

}

