package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class HideTurtleNode extends SimpleProcedureNode {

    public HideTurtleNode (String text) {
        super(text);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return commands.hideTurtle();
    }

}
