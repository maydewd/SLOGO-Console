package controller.parser;

import java.util.List;
import controller.commands.AbstractExpressionNode;
import model.IBasicModel;
import model.Point;


public class BasicSLogoInterpreter implements IBasicSLogoCommands {

    private IBasicModel myModelActions;

    public BasicSLogoInterpreter (IBasicModel basicModel) {
        setModelActions(basicModel);
    }

    @Override
    public double moveForward (double pixels) {
        getModelActions().moveTurtleForward(pixels);
        return pixels;
    }

    @Override
    public double moveBack (double pixels) {
        return moveForward(-pixels);
    }

    @Override
    public double rotateLeft (double degrees) {
        double oldHeading = getModelActions().getTurtleHeading();
        getModelActions().setTurtleHeading(oldHeading - degrees);
        return degrees;
    }

    @Override
    public double rotateRight (double degrees) {
        return rotateLeft(-degrees);
    }

    @Override
    public double setHeading (double degrees) {

        getModelActions().setTurtleHeading(-degrees);
        return degrees;
    }

    @Override
    public double faceTowards (double x, double y) {
        // TODO Auto-generated method stub
        Point oldCoords = getModelActions().getTurtleCoordinates();
        double oldHeading = getModelActions().getTurtleHeading();
        double diffX = x - oldCoords.getX();
        double diffY = y - oldCoords.getY();
        double degrees = Math.toDegrees(Math.atan(diffY / diffX));
        if (diffY > 0) {
            degrees = 180 * degrees / (Math.PI);
        }
        else {
            degrees = 180 + 180 * degrees / (Math.PI);
        }
        getModelActions().setTurtleHeading(degrees);
        return Math.abs(degrees - oldHeading);
    }

    @Override
    public double setXY (double x, double y) {
        Point currentLoc = getModelActions().getTurtleCoordinates();
        double deltaX = Math.abs(currentLoc.getX() - x);
        double deltaY = Math.abs(currentLoc.getY() - y);
        double dist = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        getModelActions().setTurtleCoordinates(new Point(x, y));
        return dist;
    }

    @Override
    public double setPenDown () {
        getModelActions().setPenDown(true);
        return 1;
    }

    @Override
    public double setPenUp () {
        getModelActions().setPenDown(false);
        return 0;
    }

    @Override
    public double showTurtle () {
        getModelActions().setTurtleVisibility(true);
        return 1;
    }

    @Override
    public double hideTurtle () {
        getModelActions().setTurtleVisibility(false);
        return 0;
    }

    @Override
    public double goHome () {
        return setXY(0, 0);
    }

    @Override
    public double clearScreen () {
        getModelActions().clearLines();
        return goHome();
    }

    @Override
    public double getXCoord () {
        return getModelActions().getTurtleCoordinates().getX();
    }

    @Override
    public double getYCoord () {
        return getModelActions().getTurtleCoordinates().getY();
    }

    @Override
    public double getHeading () {
        return getModelActions().getTurtleHeading();
    }

    @Override
    public double isPenDown () {
        if (getModelActions().getPenDown())
            return 1;
        else
            return 0;
    }

    @Override
    public double isShowing () {
        if (getModelActions().getTurtleVisibility())
            return 1;
        else
            return 0;
    }

    @Override
    public double getVariable (String name) {
        return getModelActions().variableMapProperty().get(name);
    }

    @Override
    public double setVariable (String name, double value) {
        getModelActions().variableMapProperty().put(name, value);
        return value;
    }

    @Override
    public double makeFunction (String name,
                                List<String> params,
                                AbstractExpressionNode body) {
        getModelActions().definedCommandsProperty().put(name, params);
        getModelActions().userCommandsBodies().put(name, body);

        return 1;
    }

    @Override
    public List<String> getUserMethodParams (String name) {
        return getModelActions().definedCommandsProperty().get(name);
    }

    @Override
    public AbstractExpressionNode getUserMethodBody (String name) {
        return getModelActions().userCommandsBodies().get(name);
    }

    private IBasicModel getModelActions () {
        return myModelActions;
    }

    private void setModelActions (IBasicModel modelActions) {
        myModelActions = modelActions;
    }
}
