package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class ForwardNode extends TurtleCommandNode {

    private static final int FORWARD_NUM_PARAMS = 1;

    public ForwardNode (String text) {
        super(text, FORWARD_NUM_PARAMS);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        double pixelValue = getChildren().get(0).execute(commands);
        return commands.moveForward(pixelValue);
    }

}
