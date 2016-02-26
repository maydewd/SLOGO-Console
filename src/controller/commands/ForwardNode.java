package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;

public class ForwardNode extends SimpleProcedureNode {
    
    private static final int FORWARD_NUM_PARAMS = 1;

    public ForwardNode (String text) {
        super(text, FORWARD_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double pixelValue = getParameters().get(0).execute(commands);
        return commands.moveForward(pixelValue);
    }

}
