package controller.commands;

import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class ConstantNode extends AbstractExpressionNode {

    private double myValue;

    public ConstantNode (String doubleValue) {
        super(doubleValue, SyntaxType.CONSTANT);
        setValue(Double.parseDouble(doubleValue));
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) {
        return getValue();
    }

    @Override
    public boolean areParametersComplete () {
        return true;
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        String error = String.format(getErrorMessage("NoChildAllowed"), SyntaxType.CONSTANT);
        throw new ParsingException(error);
    }

    public double getValue () {
        return myValue;
    }

    private void setValue (double myValue) {
        this.myValue = myValue;
    }

    @Override
    protected List<AbstractExpressionNode> getChildren () throws ParsingException {
        String errorMessage =
                String.format(getErrorMessage("CantGetChildren"), SyntaxType.CONSTANT);
        throw new ParsingException(errorMessage);
    }

}
