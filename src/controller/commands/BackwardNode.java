package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class BackwardNode extends TurtleCommandNode {

    private static final int BACK_NUM_PARAMS = 1;

    public BackwardNode (String text) {
        super(text, BACK_NUM_PARAMS);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        double pixelValue = getChildren().get(0).execute(commands);
        return commands.moveBack(pixelValue);
    }

}
