package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;

public class SetPenColorNode extends SimpleProcedureNode {
    
    private static final int SETPC_NUM_PARAMS = 1;

    public SetPenColorNode (String text) {
        super(text, SETPC_NUM_PARAMS);
    }


    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double index = getChildren().get(0).execute(commands);
        return commands.setPenColor((int) index);
    }

}
