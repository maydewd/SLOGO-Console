package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class ClearScreenNode extends TurtleCommandNode {

    public ClearScreenNode (String text) {
        super(text);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.clearScreen();
    }

}
