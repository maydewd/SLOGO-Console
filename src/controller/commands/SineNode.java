package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class SineNode extends SimpleProcedureNode {

    private static final int SINE_NUM_PARAMS = 1;

    public SineNode (String text) {
        super(text, SINE_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        return Math.sin(getChildren().get(0).execute(commands)*Math.PI/180);
    }

}
