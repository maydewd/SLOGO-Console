package controller.commands;

import java.util.LinkedList;
import java.util.List;


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
        return getParameters().size() >= getNumberParameters();
    }

    protected List<AbstractExpressionNode> getParameters () {
        return myParameters;
    }
    
    @Override
    public void addParameter(AbstractExpressionNode node) {
        getParameters().add(node);
    }

    private int getNumberParameters () {
        return myNumberParameters;
    }

    private void setNumberParameters (int numberParameters) {
        myNumberParameters = numberParameters;
    }

}
