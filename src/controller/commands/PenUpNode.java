package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class PenUpNode extends TurtleCommandNode {

    public PenUpNode (String text) {
        super(text);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.setPenUp();
    }

}
