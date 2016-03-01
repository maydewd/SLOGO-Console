package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class IsPenDownNode extends SimpleProcedureNode {

    public IsPenDownNode (String text) {
        super(text);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return commands.isPenDown();
    }

}
