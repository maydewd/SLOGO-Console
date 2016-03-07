package model;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;


public interface IAdvancedModel extends IBasicModel {

    Collection<? extends TurtleInfo> getAllTurtleInfo ();

    void addSelectedTurtles (int IDnumber);

    void clearSelectedTurtles ();

    Collection<Integer> getSelectedTurtleIDs ();

    List<Double> getLineThicknesses ();

    void setSelectedLineThickness ();

    List<Entry<Double, Double>> getLineTypes ();

    void setSelectedLineType ();

    void drawStamp ();

    void clearStamps ();

    int getActiveTurtleID ();

}
