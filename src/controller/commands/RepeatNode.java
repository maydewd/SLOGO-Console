package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class RepeatNode extends ControlProcedureNode {

    private static final int REPEAT_NUM_PARAMS = 2;

    public RepeatNode (String text) {
        super(text, REPEAT_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error = String.format(getErrorMessage("InvalidParameter"),
                                     getText(), SyntaxType.LISTSTART);
        if (getChildren().size() == 1 && !isList(node)) {
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double limit = getChildren().get(0).execute(commands);
        double lastValue = 0;
        for (double i = 1; i <= limit; i++) {
            commands.setVariable(":repcount", i);
            lastValue = getChildren().get(1).execute(commands);
        }
        return lastValue;
    }

}
