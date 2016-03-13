package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class DoTimesNode extends NumberedLoopNode {

    private static final int DO_NUM_PARAMS = 2;
    private static final int FIRST_LIST_PARAMS = 2;

    public DoTimesNode (String text) {
        super(text, DO_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        AbstractExpressionNode firstList = getChildren().get(0);
        String countVariable = firstList.getChildren().get(0).getText();
        double limit = firstList.getChildren().get(1).execute(commands);
        double lastValue = 0;
        for (int i = 1; i <= limit; i++) {
            commands.setVariable(countVariable, i);
            lastValue = getChildren().get(1).execute(commands);
        }
        return lastValue;
    }

    @Override
    protected int getFirstExpectedCount () {
        return FIRST_LIST_PARAMS;
    }

}
