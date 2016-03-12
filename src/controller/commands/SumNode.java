package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class SumNode extends SimpleProcedureNode {

    private static final int SUM_NUM_PARAMS = 2;

    public SumNode (String text) {
        super(text, SUM_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double sum = 0;
        for (AbstractExpressionNode node : getChildren()) {
            sum += node.execute(commands);
        }
        return sum;
    }

}
