package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class IsPenDownNode extends SimpleProcedureNode {

    public IsPenDownNode (String text) {
        super(text);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.isPenDown();
    }

}
