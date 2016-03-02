package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class IfElseNode extends ControlProcedureNode {

    private static final int IFELSE_NUM_PARAMS = 3;

    public IfElseNode (String text) {
        super(text, IFELSE_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error = String.format(getErrorMessage("InvalidParameter"),
                                     getText(), SyntaxType.LISTSTART);
        if ((getChildren().size() == 1 || getChildren().size() == 2) && !isList(node)) {
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double fork = getChildren().get(0).execute(commands);
        return fork != 0 ? getChildren().get(1).execute(commands) : getChildren().get(2).execute(commands);
    }

}
