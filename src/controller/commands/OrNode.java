package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class OrNode extends SimpleProcedureNode {

    private static final int OR_NUM_PARAMS = 2;

    public OrNode (String text) {
        super(text, OR_NUM_PARAMS);
    }

    /**
     * Does not short circuit, i.e. all children will be executed
     */
    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        boolean allNonZero = false;
        for (AbstractExpressionNode child : getChildren()) {
            allNonZero |= child.execute(commands) != 0;
        }
        return allNonZero ? 1 : 0;
    }

}
