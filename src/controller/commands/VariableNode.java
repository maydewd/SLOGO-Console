package controller.commands;

import java.util.List;
import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class VariableNode extends AbstractExpressionNode {

    public VariableNode (String text) {
        super(text, SyntaxType.VARIABLE);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) {
        return commands.getVariable(getText());
    }

    @Override
    public boolean areParametersComplete () {
        return true;
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error = String.format(getErrorMessage("NoChildAllowed"), SyntaxType.VARIABLE);
        throw new ParsingException(error);
    }

    @Override
    protected List<AbstractExpressionNode> getChildren () throws ParsingException {
        String error = String.format(getErrorMessage("CantGetChildren"), SyntaxType.VARIABLE);
        throw new ParsingException(error);
    }

}
