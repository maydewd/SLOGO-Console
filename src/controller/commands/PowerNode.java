package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class PowerNode extends SimpleProcedureNode {

    private static final int POW_NUM_PARAMS = 2;

    public PowerNode (String text) {
        super(text, POW_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double base = getChildren().get(0).execute(commands);
        double exp = getChildren().get(1).execute(commands);
        return Math.pow(base, exp);
    }

}
