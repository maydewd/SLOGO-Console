package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class ShowTurtleNode extends TurtleCommandNode {

    public ShowTurtleNode (String text) {
        super(text);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.showTurtle();
    }

}
