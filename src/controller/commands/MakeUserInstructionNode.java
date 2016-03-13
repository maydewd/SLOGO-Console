package controller.commands;

import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class MakeUserInstructionNode extends UserProcedureNode {

    private static final int TO_NUM_PARAMS = 3;

    public MakeUserInstructionNode (String text) {
        super(text, TO_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if ((getChildren().size() == 1 || getChildren().size() == 2) && !isList(node)) {
            String error = String.format(getErrorMessage("InvalidParameter"),
                                         getText(), SyntaxType.LISTSTART);
            throw new ParsingException(error);
        }
        else if (isNotAllVariables(node)) {
            String error = String.format(getErrorMessage("InvalidListParameter"),
                                         getText(), SyntaxType.VARIABLE);
            throw new ParsingException(error);
        }
        else {
            getChildren().add(node);
        }
    }

    @Override
    public double execute (IAdvancedSLogoCommands commands) throws ParsingException {
        String name = getChildren().get(0).getText();
        List<String> parameters = collectSecondParamValues();
        return commands.makeFunction(name, parameters, getChildren().get(2));
    }

}
