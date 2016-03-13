package controller.commands;

import java.util.LinkedList;
import java.util.List;


public abstract class UnlimitedParamNode extends AbstractExpressionNode {

    private List<AbstractExpressionNode> myChildren = new LinkedList<AbstractExpressionNode>();

    private boolean isClosed;

    public UnlimitedParamNode (String text, SyntaxType type) {
        super(text, type);
    }

    @Override
    public boolean areParametersComplete () {
        return isClosed();
    }

    public boolean isClosed () {
        return isClosed;
    }

    protected void setClosed (boolean closed) {
        isClosed = closed;
    }

    @Override
    protected List<AbstractExpressionNode> getChildren () {
        return myChildren;
    }

}
