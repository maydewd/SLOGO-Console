package controller.commands;

import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class GroupEndNode extends AbstractExpressionNode {

    public GroupEndNode (String text) {
        super(text, SyntaxType.GROUPEND);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        String error = String.format(getErrorMessage("CantExecute"), SyntaxType.GROUPEND);
        throw new ParsingException(error);
    }

    @Override
    public boolean areParametersComplete () {
        return true;
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error = String.format(getErrorMessage("NoChildAllowed"), SyntaxType.GROUPEND);
        throw new ParsingException(error);
    }

    @Override
    protected List<AbstractExpressionNode> getChildren () throws ParsingException {
        String error = String.format(getErrorMessage("CantGetChildren"), SyntaxType.GROUPEND);
        throw new ParsingException(error);
    }

}
