package controller.commands;

import java.util.LinkedList;
import java.util.List;
import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ListNode extends AbstractExpressionNode {

    private List<AbstractExpressionNode> myChildren = new LinkedList<AbstractExpressionNode>();

    private boolean isClosed;

    public ListNode (String token) {
        super(token, SyntaxType.LISTSTART);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double lastValue = 0;
        for (AbstractExpressionNode childNode : getChildren()) {
            lastValue = childNode.execute(commands);
        }
        return lastValue;
    }

    @Override
    public boolean areParametersComplete () {
        return isClosed();
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if (node.getType() == SyntaxType.LISTEND) {
            setClosed(true);
        }
        else {
            getChildren().add(node);
        }
    }

    protected List<AbstractExpressionNode> getChildren () {
        return myChildren;
    }

    public boolean isClosed () {
        return isClosed;
    }

    public void setClosed (boolean closed) {
        isClosed = closed;
    }

}
