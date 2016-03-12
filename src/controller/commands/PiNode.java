package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class PiNode extends SimpleProcedureNode {

    public PiNode (String text) {
        super(text);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return Math.PI;
    }

}
