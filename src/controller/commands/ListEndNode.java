package controller.commands;

import java.util.List;
import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ListEndNode extends AbstractExpressionNode {

    public ListEndNode (String text) {
        super(text, SyntaxType.LISTEND);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        String error = String.format(getErrorMessage("CantExecute"), SyntaxType.LISTEND);
        throw new ParsingException(error);
    }

    @Override
    public boolean areParametersComplete () {
        return true;
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error = String.format(getErrorMessage("NoChildAllowed"), SyntaxType.LISTEND);
        throw new ParsingException(error);
    }

    @Override
    protected List<AbstractExpressionNode> getChildren () throws ParsingException {
        String error = String.format(getErrorMessage("CantGetChildren"), SyntaxType.LISTEND);
        throw new ParsingException(error);
    }

}
