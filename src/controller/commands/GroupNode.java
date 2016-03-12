package controller.commands;

import java.util.LinkedList;
import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class GroupNode extends AbstractExpressionNode {

    private List<AbstractExpressionNode> myChildren = new LinkedList<AbstractExpressionNode>();

    private boolean isClosed;

    public GroupNode (String token) {
        super(token, SyntaxType.GROUPSTART);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        for (AbstractExpressionNode childNode : getChildren().subList(1, getChildren().size())) {
            getChildren().get(0).addParameter(childNode);
        }
        return getChildren().get(0).execute(commands);
    }

    @Override
    public boolean areParametersComplete () {
        return isClosed();
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if (node.getType() == SyntaxType.GROUPEND) {
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

    private void setClosed (boolean closed) {
        isClosed = closed;
    }
    
    @Override
    public String toString() {
        StringBuilder parameters = new StringBuilder();
        getChildren().forEach(node -> parameters.append(node.toString()));
        return getText() + " " + parameters + ") ";
    }

}
