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
        getModelActions().setTurtleHeading(pixels);
        return 0;
    }

    @Override
    public double faceTowards (double x, double y) {
        // TODO Auto-generated method stub
    	Point oldCoords=getModelActions().getTurtleCoordinates();
    	double newX=x-oldCoords.getX();
    	double newY=y-oldCoords.getY();
    	double pixels = Math.atan(newX/newY);
    	pixels=360*pixels/(Math.PI);
    	getModelActions().setTurtleHeading(pixels);
        return 0;
    }

    @Override
    public double setXY (double x, double y) {
        // TODO Auto-generated method stub
    	getModelActions().setTurtleCoordinates(new Point(x,y));
        return 0;
    }

    @Override
    public double setPenDown () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double setPenUp () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double showTurtle () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double hideTurtle () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double goHome () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double clearScreen () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getXCoord () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getYCoord () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getHeading () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double isPenDown () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double isShowing () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getVariable (String name) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double setVariable (String name, double value) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double makeFunction (String name,
                                List<AbstractExpressionNode> params,
                                AbstractExpressionNode body) {
        // TODO Auto-generated method stub
        return 0;
    }

    public IBasicModel getModelActions () {
        return myModelActions;
    }

    public void setModelActions (IBasicModel modelActions) {
        myModelActions = modelActions;
    }
}
