package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;

public class SetHeadingNode extends SimpleProcedureNode {
    
    private static final int HEADING_NUM_PARAMS = 1;

    public SetHeadingNode (String text) {
        super(text, HEADING_NUM_PARAMS);
    }


    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double heading = getChildren().get(0).execute(commands);
        return commands.setHeading(heading);
    }

}
