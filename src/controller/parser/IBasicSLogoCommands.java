package controller.parser;

public interface IBasicSLogoCommands {

    public double moveForward (double pixels);

    public double moveBack (double pixels);

    public double moveLeft (double pixels);

    public double moveRight (double pixels);

    public double rotateLeft (double degrees);

    public double rotateRight (double degrees);

    public double setHeading (double pixels);

    public double faceTowards (double x, double y);

    public double setXY (double x, double y);

    public double setPenDown ();

    public double setPenUp ();

    public double showTurtle ();

    public double hideTurtle ();

    public double goHome ();

    public double clearScreen ();

    public double getXCoord ();

    public double getYCoord ();

    public double getHeading ();

    public double isPenDown ();

    public double isShowing ();

    public double setVariable (String name, double value);

}
