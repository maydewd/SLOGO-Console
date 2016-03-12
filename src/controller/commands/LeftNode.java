package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class LeftNode extends TurtleCommandNode {

    private static final int LEFT_NUM_PARAMS = 1;

    public LeftNode (String text) {
        super(text, LEFT_NUM_PARAMS);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        double degrees = getChildren().get(0).execute(commands);
        return commands.rotateLeft(degrees);
    }

}
