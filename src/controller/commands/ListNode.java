package controller.commands;

import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class ListNode extends UnlimitedParamNode {

    public ListNode (String token) {
        super(token, SyntaxType.LISTSTART);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        double lastValue = 0;
        for (AbstractExpressionNode childNode : getChildren()) {
            lastValue = childNode.execute(commands);
        }
        return lastValue;
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

    @Override
    public String toString () {
        StringBuilder parameters = new StringBuilder();
        getChildren().forEach(node -> parameters.append(node.toString()));
        return getText() + " " + parameters + "] ";
    }

}
