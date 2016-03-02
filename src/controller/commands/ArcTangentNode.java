package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ArcTangentNode extends SimpleProcedureNode {

    private static final int ATAN_NUM_PARAMS = 1;

    public ArcTangentNode (String text) {
        super(text, ATAN_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        return Math.atan(getChildren().get(0).execute(commands))*180/Math.PI;
    }

}
