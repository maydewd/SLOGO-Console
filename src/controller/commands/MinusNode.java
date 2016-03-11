package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class MinusNode extends SimpleProcedureNode {

    private static final int MINUS_NUM_PARAMS = 1;

    public MinusNode (String text) {
        super(text, MINUS_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return -getChildren().get(0).execute(commands);
    }

}
