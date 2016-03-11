package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class GreaterThanNode extends SimpleProcedureNode {

    private static final int GT_NUM_PARAMS = 2;

    public GreaterThanNode (String text) {
        super(text, GT_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double exp1 = getChildren().get(0).execute(commands);
        double exp2 = getChildren().get(1).execute(commands);
        return exp1 > exp2 ? 1 : 0;
    }

}
