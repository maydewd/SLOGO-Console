package controller.commands;

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
        // TODO add message
        throw new ParsingException();
    }

}
