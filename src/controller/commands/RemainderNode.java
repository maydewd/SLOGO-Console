package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class RemainderNode extends SimpleProcedureNode {

    private static final int QUOTIENT_NUM_PARAMS = 2;

    public RemainderNode (String text) {
        super(text, QUOTIENT_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double exp1 = getChildren().get(0).execute(commands);
        double exp2 = getChildren().get(1).execute(commands);
        return exp1 % exp2;
    }

}
