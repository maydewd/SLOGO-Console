package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ForNode extends ControlProcedureNode {

    private static final int FOR_NUM_PARAMS = 2;

    public ForNode (String text) {
        super(text, FOR_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if (!isList(node)) {
            String error = String.format(getErrorMessage("InvalidParameter"),
                                         getText(), SyntaxType.LISTSTART);
            throw new ParsingException(error);
        }
        else if (getChildren().size() == 0 && (node.getChildren().size() != 4 ||
                                               !isVariable(node.getChildren().get(0)))) {
            String error = String.format(getErrorMessage("InvalidListParameter"),
                                         getText(), SyntaxType.VARIABLE);
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
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

}
