package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;

public class TowardsNode extends SimpleProcedureNode {
    
    private static final int TOWARDS_NUM_PARAMS = 2;

    public TowardsNode (String text) {
        super(text, TOWARDS_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double leftValue = getParameters().get(0).execute(commands);
        double rightValue = getParameters().get(1).execute(commands);
        return commands.faceTowards(leftValue, rightValue);
    }

}
