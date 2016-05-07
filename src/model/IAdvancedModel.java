package model;

import java.util.Collection;
import java.util.List;
import javafx.beans.property.ReadOnlyListProperty;


/**
 * Description of available methods for use with an advanced model.
 *
 * @author David Maydew
 * @author Carine Torres
 *
 */
public interface IAdvancedModel extends IBasicModel {

    void addSelectedTurtle (int IDnumber);

    void clearSelectedTurtles ();

    List<Integer> getAllTurtleIDs ();

    List<Integer> getSelectedTurtleIDs ();

    List<LineThickness> getLineThicknesses ();

    void setLineThickness (int index);

    void setLineThickness (double thickness);

    List<LineType> getLineTypeValues ();

    void setLineType (int i);

    ReadOnlyListProperty<StampInfo> getStamps ();

    void drawStamp ();

    void clearStamps ();

    int getActiveTurtleID ();

    Collection<? extends TurtleInfo> getAllTurtleInfo ();

    TurtleInfo getTurtle (int id);

    void addTurtle (int id);
    
    void windowTurtles();
    
    void fenceTurtles();

}
