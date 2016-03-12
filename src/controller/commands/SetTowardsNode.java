package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class SetTowardsNode extends TurtleCommandNode {

    private static final int TOWARDS_NUM_PARAMS = 2;

    public SetTowardsNode (String text) {
        super(text, TOWARDS_NUM_PARAMS);
    }

    @Override
    public double executeSingle (IAdvancedSLogoCommands commands) throws ParsingException {
        double leftValue = getChildren().get(0).execute(commands);
        double rightValue = getChildren().get(1).execute(commands);
        return commands.faceTowards(leftValue, rightValue);
    }

}
