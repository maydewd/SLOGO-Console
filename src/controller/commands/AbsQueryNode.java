package controller.commands;

import controller.parser.ParsingException;


public abstract class AbsQueryNode extends ControlProcedureNode {

    public AbsQueryNode (String text, int numberParameters) {
        super(text, numberParameters);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if (!isList(node)) {
            String error = String.format(getErrorMessage("InvalidParameter"),
                                         getText(), SyntaxType.LISTSTART);
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

}
