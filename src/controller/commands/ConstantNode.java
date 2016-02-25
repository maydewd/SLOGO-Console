package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ConstantNode extends AbstractExpressionNode {

    private double myValue;

    public ConstantNode (String doubleValue) {
        super(doubleValue, SyntaxType.CONSTANT);
        setValue(Double.parseDouble(doubleValue));
    }

    @Override
    public double execute (IBasicSLogoCommands commands) {
        return getValue();
    }

    @Override
    public boolean areParametersComplete () {
        return true;
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        // TODO add message
        throw new ParsingException();
    }

    public double getValue () {
        return myValue;
    }

    private void setValue (double myValue) {
        this.myValue = myValue;
    }

}
