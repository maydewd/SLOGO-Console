package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class NaturalLogNode extends SimpleProcedureNode {

    private static final int LN_NUM_PARAMS = 1;

    public NaturalLogNode (String text) {
        super(text, LN_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return Math.log(getChildren().get(0).execute(commands));
    }

}
