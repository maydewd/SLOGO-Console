package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class SetShapeNode extends SimpleProcedureNode {

    private static final int SETSH_NUM_PARAMS = 1;

    public SetShapeNode (String text) {
        super(text, SETSH_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double index = getChildren().get(0).execute(commands);
        return commands.setShape((int) index);
    }

}
