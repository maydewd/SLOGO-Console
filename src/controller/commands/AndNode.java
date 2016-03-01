package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class AndNode extends SimpleProcedureNode {

    private static final int AND_NUM_PARAMS = 2;

    public AndNode (String text) {
        super(text, AND_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        boolean allNonZero = true;
        for (AbstractExpressionNode child : getChildren()) {
            allNonZero &= child.execute(commands) != 0;
        }
        return allNonZero ? 1 : 0;
    }

}
