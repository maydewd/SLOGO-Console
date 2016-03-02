package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class LessThanNode extends SimpleProcedureNode {

    private static final int LT_NUM_PARAMS = 2;

    public LessThanNode (String text) {
        super(text, LT_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double exp1 = getChildren().get(0).execute(commands);
        double exp2 = getChildren().get(1).execute(commands);
        return exp1 < exp2 ? 1 : 0;
    }

}
