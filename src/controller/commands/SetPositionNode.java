package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;

public class SetPositionNode extends SimpleProcedureNode {

    private static final int SETXY_NUM_PARAMS = 2;
    
    public SetPositionNode (String text) {
        super(text, SETXY_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double x = getChildren().get(0).execute(commands);
        double y = getChildren().get(1).execute(commands);
        return commands.setXY(x, y);
    }

}
