package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class HomeNode extends TurtleCommandNode {

    public HomeNode (String text) {
        super(text);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        return commands.goHome();
    }

}
