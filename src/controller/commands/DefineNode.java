package controller.commands;

import java.util.List;
import controller.parser.IAdvancedSLogoCommands;
import controller.parser.ParsingException;


public class DefineNode extends UserProcedureNode {

    private static final int DEF_NUM_PARAMS = 2;

    public DefineNode (String text) {
        super(text, DEF_NUM_PARAMS);
    }

    @Override
    public void addParameter (AbstractExpressionNode node) throws ParsingException {
        if (getChildren().size() == 1 && (!isList(node) || isNotAllVariables(node))) {
            String error = String.format(getErrorMessage("InvalidParameter"),
                                         getText(), SyntaxType.LISTSTART);
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
        return commands.defineCommand(name, parameters);
    }

}
