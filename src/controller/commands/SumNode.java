package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class SumNode extends SimpleProcedureNode {

    private static final int SUM_NUM_PARAMS = 2;

    public SumNode (String text) {
        super(text, SUM_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double sum = 0;
        for (AbstractExpressionNode node : getParameters()) {
            sum += node.execute(commands);
        }
        return sum;
    }

}
