package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class ForNode extends NumberedLoopNode {

    private static final int FOR_NUM_PARAMS = 2;
    private static final int FIRST_LIST_PARAMS = 4;

    public ForNode (String text) {
        super(text, FOR_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        AbstractExpressionNode firstList = getChildren().get(0);
        String countVariable = firstList.getChildren().get(0).getText();
        double start = firstList.getChildren().get(1).execute(commands);
        double end = firstList.getChildren().get(2).execute(commands);
        double increment = firstList.getChildren().get(3).execute(commands);
        double lastValue = 0;
        for (double i = start; i <= end; i += increment) {
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
