package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;

public class PenUpNode extends SimpleProcedureNode {


    public PenUpNode (String text) {
        super(text);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return commands.setPenUp();
    }

}
