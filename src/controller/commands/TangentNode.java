package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class TangentNode extends SimpleProcedureNode {

    private static final int TAN_NUM_PARAMS = 1;

    public TangentNode (String text) {
        super(text, TAN_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return Math.tan(getChildren().get(0).execute(commands)*Math.PI/180);
    }

}
