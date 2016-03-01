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
        // Point oldCoords = getModelActions().getTurtleCoordinates();
        // double heading = getModelActions().getTurtleHeading();
        // double newX = oldCoords.getX() + Math.cos(heading) * pixels;
        // double newY = oldCoords.getY() + Math.sin(heading) * pixels;
        // getModelActions().setTurtleCoordinates(new Point(newX, newY));
        return 0;
    }

    @Override
    public double moveBack (double pixels) {
        return moveForward(-pixels);
    }

    @Override
    public double rotateLeft (double degrees) {
        double oldHeading = getModelActions().getTurtleHeading();
        getModelActions().setTurtleHeading(oldHeading + degrees);
        return degrees;
    }

    @Override
    public double rotateRight (double degrees) {
        return rotateLeft(-degrees);
    }

    @Override
    public double setHeading (double pixels) {
        double oldHeading = getModelActions().getTurtleHeading();
        // TODO
        return 0;
    }

    @Override
    public double faceTowards (double x, double y) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double setXY (double x, double y) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double setPenDown () {
        // TODO Auto-generated method stub
    	getModelActions().setPenDown(true);
        return 1;
    }

    @Override
    public double setPenUp () {
        // TODO Auto-generated method stub
        getModelActions().setPenDown(false);
    	return 0;
    }

    @Override
    public double showTurtle () {
        // TODO Auto-generated method stub
    	getModelActions().setTurtleVisibility(true);
        return 1;
    }

    @Override
    public double hideTurtle () {
        // TODO Auto-generated method stub
    	getModelActions().setTurtleVisibility(false);
    	return 0;
    }

    @Override
    public double goHome () {
    	Point currentLoc = getModelActions().getTurtleCoordinates();
    	double dist = Math.sqrt(Math.pow(currentLoc.getX(), 2) + Math.pow(currentLoc.getY(), 2));
    	getModelActions().setTurtleCoordinates(new Point(0,0));
        // TODO Auto-generated method stub
        return dist;
    }

    @Override
    public double clearScreen () {
        // TODO Auto-generated method stub
    	getModelActions().clearLines();
    	return goHome();
    }

    @Override
    public double getXCoord () {
        // TODO Auto-generated method stub
        return getModelActions().getTurtleCoordinates().getX();
    }

    @Override
    public double getYCoord () {
        // TODO Auto-generated method stub
    	 return getModelActions().getTurtleCoordinates().getY();
    }

    @Override
    public double getHeading () {
        // TODO Auto-generated method stub
        return getModelActions().getTurtleHeading();
    }

    @Override
    public double isPenDown () {
        // TODO Auto-generated method stub
        if (getModelActions().getPenDown())
        	return 1;
        else
        	return 0;
    }

    @Override
    public double isShowing () {
        // TODO Auto-generated method stub
    	if (getModelActions().getTurtleVisibility())
        	return 1;
        else
        	return 0;
    }

    @Override
    public double getVariable (String name) {
        // TODO Auto-generated method stub
        return getModelActions().variableMapProperty().get(name);
    }

    @Override
    public double setVariable (String name, double value) {
        // TODO Auto-generated method stub
    	getModelActions().variableMapProperty().put(name, value);
        return value;
    }

    @Override
    public double makeFunction (String name,
                                List<AbstractExpressionNode> params,
                                AbstractExpressionNode body) {
        // TODO Auto-generated method stub
        return 0;
    }

    private IBasicModel getModelActions () {
        return myModelActions;
    }

    private void setModelActions (IBasicModel modelActions) {
        myModelActions = modelActions;
    }
}
