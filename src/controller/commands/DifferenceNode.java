package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class DifferenceNode extends SimpleProcedureNode {

    private static final int DIFF_NUM_PARAMS = 2;

    public DifferenceNode (String text) {
        super(text, DIFF_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double difference = getChildren().get(0).execute(commands);
        for (AbstractExpressionNode node : getChildren().subList(1, getChildren().size())) {
            difference -= node.execute(commands);
        }
        return difference;
    }

}
