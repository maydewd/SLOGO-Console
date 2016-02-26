package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ClearScreenNode extends SimpleProcedureNode {

    public ClearScreenNode (String text) {
        super(text);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return commands.clearScreen();
    }

}
