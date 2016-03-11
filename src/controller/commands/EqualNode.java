package controller.commands;

import java.util.HashSet;
import java.util.Set;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class EqualNode extends SimpleProcedureNode {

    private static final int EQUAL_NUM_PARAMS = 2;

    public EqualNode (String text) {
        super(text, EQUAL_NUM_PARAMS);
    }

    /**
     * Does not short circuit, i.e. all children will be executed
     */
    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        Set<Double> values = new HashSet<>();
        for (AbstractExpressionNode child : getChildren()) {
            values.add(child.execute(commands));
        }
        return values.size() == 1 ? 1 : 0;
    }

}
