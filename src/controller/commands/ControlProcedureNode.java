package controller.commands;

import controller.parser.ParsingException;


public abstract class ControlProcedureNode extends SimpleProcedureNode {

    public ControlProcedureNode (String text, int numberParameters) {
        super(text, numberParameters);
    }

    @Override
    public abstract void addParameter (AbstractExpressionNode node) throws ParsingException;

    protected boolean isList (AbstractExpressionNode node) {
        return node.getType() == SyntaxType.LISTSTART;
    }

    protected boolean isVariable (AbstractExpressionNode node) {
        return node.getType() == SyntaxType.VARIABLE;
    }

}
