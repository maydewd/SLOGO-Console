package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ShowTurtleNode extends SimpleProcedureNode {

    public ShowTurtleNode (String text) {
        super(text);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return commands.showTurtle();
    }

}
