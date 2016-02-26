package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class EqualNode extends SimpleProcedureNode {

    private static final int EQUAL_NUM_PARAMS = 2;

    public EqualNode (String text) {
        super(text, EQUAL_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double firstValue = getChildren().get(0).execute(commands);
        for (AbstractExpressionNode child : getChildren().subList(1, getChildren().size())) {
            if (child.execute(commands) != firstValue) {
                return 0;
            }
        }
        return 1;
    }

}
