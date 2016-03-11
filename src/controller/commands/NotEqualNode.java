package controller.commands;

import java.util.HashSet;
import java.util.Set;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class NotEqualNode extends SimpleProcedureNode {

    private static final int NEQUAL_NUM_PARAMS = 2;

    public NotEqualNode (String text) {
        super(text, NEQUAL_NUM_PARAMS);
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        Set<Double> values = new HashSet<>();
        for (AbstractExpressionNode child : getChildren()) {
            values.add(child.execute(commands));
        }
        return values.size() > 1 ? 1 : 0;
    }

}
