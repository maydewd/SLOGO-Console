package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class NotNode extends SimpleProcedureNode {

    private static final int NOT_NUM_PARAMS = 1;

    public NotNode (String text) {
        super(text, NOT_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return getChildren().get(0).execute(commands) == 0 ? 1 : 0;
    }

}
