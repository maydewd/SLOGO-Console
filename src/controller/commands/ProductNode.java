package controller.commands;

import controller.parser.IBasicSLogoCommands;
import controller.parser.ParsingException;


public class ProductNode extends SimpleProcedureNode {

    private static final int PRODUCT_NUM_PARAMS = 2;

    public ProductNode (String text) {
        super(text, PRODUCT_NUM_PARAMS);
    }

    @Override
    public double execute (IBasicSLogoCommands commands) throws ParsingException {
        double product = getChildren().get(0).execute(commands);
        for (AbstractExpressionNode node : getChildren().subList(1, getChildren().size())) {
            product *= node.execute(commands);
        }
        return product;
    }

}
