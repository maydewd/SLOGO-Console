package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class CosineNode extends SimpleProcedureNode {

    private static final int COS_NUM_PARAMS = 1;

    public CosineNode (String text) {
        super(text, COS_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return Math.cos(getChildren().get(0).execute(commands)*Math.PI/180);
    }

}
