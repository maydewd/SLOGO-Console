package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;

public class SetHeadingNode extends TurtleCommandNode {
    
    private static final int HEADING_NUM_PARAMS = 1;

    public SetHeadingNode (String text) {
        super(text, HEADING_NUM_PARAMS);
    }


    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        double heading = getChildren().get(0).execute(commands);
        return commands.setHeading(heading);
    }

}
