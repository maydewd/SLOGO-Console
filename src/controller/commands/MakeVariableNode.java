package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class MakeVariableNode extends ControlProcedureNode {

    private static final int MAKE_NUM_PARAMS = 2;

    public MakeVariableNode (String text) {
        super(text, MAKE_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error =
                String.format(getErrorMessage("InvalidParameter"), getText(), SyntaxType.VARIABLE);
        if (getChildren().size() == 0 && !isVariable(node)) {
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        String varName = getChildren().get(0).getText();
        return commands.setVariable(varName, getChildren().get(1).execute(commands));
    }

}
