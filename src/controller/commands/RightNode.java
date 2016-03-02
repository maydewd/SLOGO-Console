package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;

public class RightNode extends SimpleProcedureNode {
    
    private static final int RIGHT_NUM_PARAMS = 1;

    public RightNode (String text) {
        super(text, RIGHT_NUM_PARAMS);
    }


    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double degrees = getChildren().get(0).execute(commands);
        return commands.rotateRight(degrees);
    }

}