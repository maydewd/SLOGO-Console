package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class IsShowingNode extends SimpleProcedureNode {

    public IsShowingNode (String text) {
        super(text);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return commands.isShowing();
    }

}
