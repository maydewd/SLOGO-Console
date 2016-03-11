package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;

public class SetBackgroundNode extends SimpleProcedureNode {
    
    private static final int SETBG_NUM_PARAMS = 1;

    public SetBackgroundNode (String text) {
        super(text, SETBG_NUM_PARAMS);
    }


    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double degrees = getChildren().get(0).execute(commands);
        return commands.setBackground((int) degrees);
    }

}
