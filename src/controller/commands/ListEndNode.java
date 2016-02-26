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
        // TODO add message
        throw new ParsingException();
    }

    @Override
    public boolean areParametersComplete () {
        return true;
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        // add message
        throw new ParsingException();
    }

    @Override
    protected List<AbstractExpressionNode> getChildren () throws ParsingException {
        // TODO Add message
        throw new ParsingException();
    }

}
