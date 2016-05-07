package controller.parser;

import java.util.List;
import java.util.Map;


/**
 * Interface detailing available commands associated with extended SLogo
 *
 * @author Carine Torres
 * @author David Maydew
 *
 */
public interface IAdvancedSLogoCommands extends IBasicSLogoCommands {

    /**
     * @return list of IDs of the selected (sometimes called active) turtles
     */
    List<Integer> getSelectedTurtles ();

    /**
     * @return list of IDs of all turtles
     */
    List<Integer> getAllTurtles ();

    /**
     * @param index of background color
     * @return background index
     */
    double setBackground (int index);

    /**
     * @param index of pen color to set
     * @return pen color index
     */
    double setPenColor (int index);

    /**
     * @param pixels thickness of pen stroke
     * @return pen stroke thickness
     */
    double setPenSize (double pixels);

    /**
     * @param index of shape to set
     * @return shape index
     */
    double setShape (int index);

    /**
     * @param index of palette to set
     * @param r red value of color
     * @param g green value of color
     * @param b blue value of color
     * @return palette index
     */
    double setPalette (int index, int r, int g, int b);

    /**
     * @return active pen color index
     */
    double getPenColor ();

    /**
     * @return active shape index
     */
    double getShape ();

    /**
     * creates a stamp on all active turtles
     *
     * @return index of turtle image
     */
    double stamp ();

    /**
     * clear all stamps from all turtles
     *
     * @return 1 if stamps were cleared, 0 if not
     */
    double clearStamps ();

    /**
     * @return the id of the active turtle
     */
    double getCurrentActiveID ();

    /**
     * @return number of turtles created
     */
    double getTurtleCount ();

    /**
     * activate the given turtle
     *
     * @param id turtle to activate
     * @return id of turtle
     */
    double tell (Integer id);

    /**
     * activate all the given turtles
     *
     * @param ids all turtles to activate
     * @return last turtle id in list
     */
    double tellAll (List<Integer> ids);

    /**
     * @param name command name
     * @param params list of variable pararmeters
     * @return
     */
    double defineCommand (String name, List<String> params);

    /**
     * @return a map of variables at this point in time
     */
    Map<String, Double> getAllVariables ();

    /**
     * restore variables from a given map
     *
     * @param allVars variable map
     */
    void setAllVariables (Map<String, Double> allVars);

    /**
     * sets the current window border behavior such that if the turtle moves past an edge of the
     * window, it will disappear until it is moved back into view
     * 
     * @return 2
     */
    double windowTurtles ();

    /**
     * sets the current window border behavior such that any move that attempts to take the turtle
     * past the edge of the window will stop at the edge
     * 
     * @return 3
     */
    double fenceTurtles ();

}
