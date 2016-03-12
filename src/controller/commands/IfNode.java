package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class IfNode extends ControlProcedureNode {

    private static final int DEF_NUM_PARAMS = 2;

    public IfNode (String text) {
        super(text, DEF_NUM_PARAMS);
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
        double fork = getChildren().get(0).execute(commands);
        return fork != 0 ? getChildren().get(1).execute(commands) : 0;
    }

}
