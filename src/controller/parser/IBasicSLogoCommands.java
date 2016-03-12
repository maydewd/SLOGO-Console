package controller.parser;

import java.util.List;
import controller.commands.AbstractExpressionNode;


/**
 * Interface detailing available commands associated with basic SLogo
 *
 * @author Carine Torres
 * @author David Maydew
 *
 */
public interface IBasicSLogoCommands {

    /**
     * move active turtle forward
     *
     * @param pixels distance to move
     * @return distance moved
     */
    public double moveForward (double pixels);

    /**
     * move active turtle back
     *
     * @param pixels distance to move
     * @return distance moved
     */
    public double moveBack (double pixels);

    /**
     * rotates the active turtle left
     *
     * @param degrees to rotate
     * @return degrees rotated
     */
    public double rotateLeft (double degrees);

    /**
     * rotates the active turtle right
     *
     * @param degrees to rotate
     * @return degrees rotated
     */
    public double rotateRight (double degrees);

    /**
     * rotates the active turtle to a specified heading
     *
     * @param degrees heading to set to
     * @return degrees rotated
     */
    public double setHeading (double degrees);

    /**
     * face towards a specified position
     *
     * @param x xcoord
     * @param y ycoord
     * @return degrees rotated
     */
    public double faceTowards (double x, double y);

    /**
     * move turtle to a specified position
     *
     * @param x xcoord to move to
     * @param y ycoord to move to
     * @return distance moved
     */
    public double setXY (double x, double y);

    /**
     * @return 1
     */
    public double setPenDown ();

    /**
     * @return 0
     */
    public double setPenUp ();

    /**
     * make the active turtle visible
     *
     * @return 1
     */
    public double showTurtle ();

    /**
     * make the active turtle not visible
     *
     * @return 0
     */
    public double hideTurtle ();

    /**
     * moves turtle to position 0 0
     *
     * @return distance moved
     */
    public double goHome ();

    /**
     * clear screen of all lines and go home
     *
     * @return distance moved to home
     */
    public double clearScreen ();

    /**
     * @return x coordinate of active turtle
     */
    public double getXCoord ();

    /**
     * @return y coordinate of active turtle
     */
    public double getYCoord ();

    /**
     * @return heading of active turtle
     */
    public double getHeading ();

    /**
     * @return 1 if pen down, 0 if not
     */
    public double isPenDown ();

    /**
     * @return 1 if pen down, 0 if not
     */
    public double isShowing ();

    /**
     * @param name variable name
     * @return variable value
     */
    public double getVariable (String name);

    /**
     * @param name variable name
     * @param value to set name to
     * @return value
     */
    public double setVariable (String name, double value);

    /**
     * make a user-defined function with:
     *
     * @param name function name
     * @param params parameters to associate with function
     * @param body to use for function execution
     * @return 1 if successfully defined, 0 or not
     */
    public double makeFunction (String name, List<String> params, AbstractExpressionNode body);

    /**
     * @param name function name
     * @return variable parameters associated with function
     */
    public List<String> getUserMethodParams (String name);

    /**
     * @param name function name
     * @return command node for the body of this function
     */
    public AbstractExpressionNode getUserMethodBody (String name);

}
