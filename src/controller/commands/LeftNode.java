package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;

public class LeftNode extends SimpleProcedureNode {
    
    private static final int LEFT_NUM_PARAMS = 1;

    public LeftNode (String text) {
        super(text, LEFT_NUM_PARAMS);
    }


    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double degrees = getChildren().get(0).execute(commands);
        return commands.rotateLeft(degrees);
    }

}
