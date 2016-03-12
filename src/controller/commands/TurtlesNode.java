package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class TurtlesNode extends SimpleProcedureNode {

    public TurtlesNode (String text) {
        super(text);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.getTurtleCount();
    }

}
