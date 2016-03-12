package controller.commands;

import controller.parser.ParsingException;


/**
 * Intermediate abstract type for facilitating implementation of control nodes
 *
 * @author David Maydew
 *
 */
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
