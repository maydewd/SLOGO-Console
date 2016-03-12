package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class HeadingNode extends SimpleProcedureNode {

    public HeadingNode (String text) {
        super(text);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.getHeading();
    }

}
