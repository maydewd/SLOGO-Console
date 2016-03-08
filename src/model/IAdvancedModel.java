package model;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import javafx.beans.property.ReadOnlyListProperty;
<<<<<<< HEAD
=======

>>>>>>> FrontEndExtentionPartOne


public interface IAdvancedModel extends IBasicModel {

    Collection<? extends TurtleInfo> getAllTurtleInfo ();

    void addSelectedTurtles (int IDnumber);

    void clearSelectedTurtles ();

    Collection<Integer> getSelectedTurtleIDs ();

    List<Double> getLineThicknesses ();

<<<<<<< HEAD

=======
>>>>>>> FrontEndExtentionPartOne
    void setSelectedLineThickness (int i);

    List<Entry<Double, Double>> getLineTypes ();

    void setSelectedLineType (int i);
    
    public ReadOnlyListProperty<StampInfo> getStamps ();
<<<<<<< HEAD
=======

>>>>>>> FrontEndExtentionPartOne

    void drawStamp ();

    void clearStamps ();

    int getActiveTurtleID ();

}
