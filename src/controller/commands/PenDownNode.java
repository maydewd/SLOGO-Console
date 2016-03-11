package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class PenDownNode extends TurtleCommandNode {

    public PenDownNode (String text) {
        super(text);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.setPenDown();
    }

}
