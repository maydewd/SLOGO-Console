package controller.commands;

import controller.parser.ParsingException;


public abstract class NumberedLoopNode extends ControlProcedureNode {

    public NumberedLoopNode (String text, int numberParameters) {
        super(text, numberParameters);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if (!isList(node)) {
            String error = String.format(getErrorMessage("InvalidParameter"),
                                         getText(), SyntaxType.LISTSTART);
            throw new ParsingException(error);
        }
        else if (getChildren().size() == 0 &&
                 (node.getChildren().size() != getFirstExpectedCount() ||
                  !isVariable(node.getChildren().get(0)))) {
            String error = String.format(getErrorMessage("InvalidListParameter"),
                                         getText(), SyntaxType.VARIABLE);
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    protected abstract int getFirstExpectedCount ();

}
