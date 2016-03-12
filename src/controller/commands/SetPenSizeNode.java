package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class SetPenSizeNode extends SimpleProcedureNode {

    private static final int SETPC_NUM_PARAMS = 1;

    public SetPenSizeNode (String text) {
        super(text, SETPC_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double pixels = getChildren().get(0).execute(commands);
        return commands.setPenSize(pixels);
    }

}
