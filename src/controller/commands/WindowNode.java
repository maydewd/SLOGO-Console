package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;

public class WindowNode extends SimpleProcedureNode {

    public WindowNode (String text) {
        super(text);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.windowTurtles();
    }
}
