package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class StampNode extends SimpleProcedureNode {

    public StampNode (String text) {
        super(text);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.stamp();
    }

}
