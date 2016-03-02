package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class PiNode extends SimpleProcedureNode {

    public PiNode (String text) {
        super(text);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return Math.PI;
    }

}
