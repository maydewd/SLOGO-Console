package controller.commands;

import java.util.LinkedList;
import java.util.List;
import controller.parser.ParsingException;


public abstract class SimpleProcedureNode extends AbstractExpressionNode {

    private List<AbstractExpressionNode> myParameters = new LinkedList<AbstractExpressionNode>();
    private int myNumberParameters;

    public SimpleProcedureNode (String text) {
        this(text, 0);
    }

    public SimpleProcedureNode (String text, int numberParameters) {
        super(text, SyntaxType.COMMAND);
        setNumberParameters(numberParameters);
    }

    @Override
    public boolean areParametersComplete () {
        return getChildren().size() >= getNumberParameters();
    }

    protected List<AbstractExpressionNode> getChildren () {
        return myParameters;
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        getChildren().add(node);
    }

    private int getNumberParameters () {
        return myNumberParameters;
    }

    private void setNumberParameters (int numberParameters) {
        myNumberParameters = numberParameters;
    }

}