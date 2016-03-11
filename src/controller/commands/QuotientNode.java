package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class QuotientNode extends SimpleProcedureNode {

    private static final int REMAINDER_NUM_PARAMS = 2;

    public QuotientNode (String text) {
        super(text, REMAINDER_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double exp1 = getChildren().get(0).execute(commands);
        double exp2 = getChildren().get(1).execute(commands);
        return exp1 / exp2;
    }

}
